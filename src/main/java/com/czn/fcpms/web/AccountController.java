package com.czn.fcpms.web;

import com.czn.fcpms.annotation.Authorization;
import com.czn.fcpms.common.ResultUtil;
import com.czn.fcpms.common.TokenUtil;
import com.czn.fcpms.entity.Account;
import com.czn.fcpms.service.AccountService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private TokenUtil tokenUtil;

    @GetMapping(value="/accountList")
    @Authorization
    private Map<String,Object> accountList(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Account> list = accountService.accountList();
        modelMap.put("result",ResultUtil.success(list));
        return modelMap;
    }

    @GetMapping(value="/account/{accountId}")
    private Map<String,Object> account(@PathVariable("accountId") Integer accountId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Account account = accountService.account(accountId);

        modelMap.put("result",ResultUtil.success(account));
        return modelMap;
    }

    @PostMapping(value="/addAccount")
    private Map<String,Object> addAccount(@RequestBody Account account){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        account.setCreatedTime(new Date().getTime());
        account.setCreatedBy(0);  //todo:获取当前登录用户id

        Integer result = accountService.addAccount(account);
        modelMap.put("result",ResultUtil.success());
        return modelMap;
    }

    @PutMapping(value="/updateAccount/{accountId}")
    private Map<String,Object> updateAccount(@PathVariable("accountId") Integer accountId, @RequestBody Account account){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        account.setUpdatedTime(new Date().getTime());
        account.setUpdatedBy(0);  //todo:获取当前登录用户id

        Integer result = accountService.updateAccount(accountId, account);
        modelMap.put("result",ResultUtil.success());
        return modelMap;
    }

    @DeleteMapping(value = "/deleteAccount/{accountId}")
    private Map<String,Object> updateAccount(@PathVariable("accountId") Integer accountId){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        Integer result = accountService.deleteAccount(accountId);
        // todo 成功失败的判断
        modelMap.put("result",ResultUtil.success());
        return modelMap;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    @CrossOrigin
    private Map<String,Object> login(@Valid @RequestBody Account account, BindingResult bindingResult){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        String password = accountService.selectPassword(account.getMobile());

        Object result;
        if(bindingResult.hasErrors()){
            result = ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }else if(password != null && password.equals(account.getPassword())){

            String jws = tokenUtil.generateToken(account.getMobile());
            result = ResultUtil.success(jws);
        }else{
            result = ResultUtil.error(2,"用户名密码错误");
        }

//        Object j = tokenUtil.parseToken(jws,key).getBody();

        modelMap.put("result",result);
        return modelMap;
    }
}
