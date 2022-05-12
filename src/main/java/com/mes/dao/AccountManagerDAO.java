package com.mes.dao;

import com.mes.entity.AccountManager;

import java.util.Date;
import java.util.List;

public class AccountManagerDAO extends JpaDAO<AccountManager> {

    @Override
    public AccountManager create(AccountManager accountManager) {
        accountManager.setCreatedAt(new Date());
        accountManager.setUpdatedAt(new Date());
        return super.create(accountManager);
    }

    @Override
    public AccountManager update(AccountManager accountManager) {
        accountManager.setCreatedAt(new Date());
        accountManager.setUpdatedAt(new Date());
        return super.update(accountManager);
    }

    public List<AccountManager> findAll() {
        return super.findWithNamedQuery("AccountManager.findAll");
    }
}
