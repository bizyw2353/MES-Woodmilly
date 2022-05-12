package com.mes.dao;

import com.mes.entity.Account;

import java.util.Date;
import java.util.List;

public class AccountDAO extends JpaDAO<Account> {

    @Override
    public Account create(Account account) {
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        return super.create(account);
    }

    @Override
    public Account update(Account account) {
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        return super.update(account);
    }


    public Account find(Object accountId) {
        return super.find(Account.class, accountId);
    }

    public List<Account> findAll()  {
        return super.findWithNamedQuery("Account.findAll");
    }

    public long countAll()  {
        return super.countWithNamedQuery("Account.countAll");
    }
}
