package com.czn.fcpms.service;

import com.czn.fcpms.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> accountList();
    Account account(int accountId);
    Integer addAccount(Account account);
}
