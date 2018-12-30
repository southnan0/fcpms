package com.czn.fcpms.web;

import com.czn.fcpms.entity.Account;
import com.czn.fcpms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value="/accountList")
    @CrossOrigin("http://localhost:4200")
    private Map<String,Object> accountList(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Account> list = accountService.accountList();
        modelMap.put("accountList",list);
        return modelMap;
    }

    @GetMapping(value="/account/{accountId}")
    private Map<String,Object> account(@PathVariable("accountId") Integer accountId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Account account = accountService.account(accountId);
        modelMap.put("account",account);
        return modelMap;
    }

    @PostMapping(value="/account")
    private Map<String,Object> addAccount(@RequestBody Account account){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Integer result = accountService.addAccount(account);
        modelMap.put("result",result);
        return modelMap;
    }
}
