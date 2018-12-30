package com.czn.fcpms.dao;

import com.czn.fcpms.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> accountList();
    Account account(int accountId);
    Integer addAccount(Account account);
}
