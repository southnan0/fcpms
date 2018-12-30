package com.czn.fcpms.service.impl;

import com.czn.fcpms.dao.AccountDao;
import com.czn.fcpms.entity.Account;
import com.czn.fcpms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> accountList(){
        return accountDao.accountList();
    }

    @Override
    public Account account(int accountId){
        return accountDao.account(accountId);
    }

    @Override
    public Integer addAccount(Account account){
        return accountDao.addAccount(account);
    }
}
