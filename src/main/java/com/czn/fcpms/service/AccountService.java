package com.czn.fcpms.service;

import com.czn.fcpms.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> accountList();
    Account account(int accountId);
    Integer addAccount(Account account);
    Integer updateAccount(int accountId, Account account);
    Integer deleteAccount(int accountId);
    String selectPassword(String mobile);
}
