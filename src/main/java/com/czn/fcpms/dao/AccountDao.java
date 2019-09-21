package com.czn.fcpms.dao;

import com.czn.fcpms.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> accountList();
    Account account(int accountId);
    Integer addAccount(Account account);
    Integer updateAccount(int accountId, Account account);
    Integer deleteAccount(int accountId);
    String selectPassword(String mobile);
}
