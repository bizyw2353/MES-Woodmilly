package com.mes.service;

import com.mes.dao.AccountDAO;
import com.mes.dto.account.AccountInputDTO;
import com.mes.dto.account.AccountListDTO;
import com.mes.entity.Account;
import com.mes.model.Address;
import com.mes.model.Business;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AccountService {
    private final HttpServletRequest request;

    private final AccountDAO accountDAO = new AccountDAO();

    public AccountService(HttpServletRequest request) {
        this.request = request;
    }

    private void accountFields(Account account, AccountInputDTO dto) {
        account.setName(dto.getName());
        account.setCode(dto.getAccountCode());
        account.setCeo(dto.getCeo());
        account.setTel(dto.getTel());
        account.setFax(dto.getFax());
        account.setEmail(dto.getEmail());
        account.setEtc(dto.getEtc());

        Business business = new Business(
                dto.getBusinessNumber(),
                dto.getBusinessCategory(),
                dto.getBusinessType()
        );
        account.setBusiness(business);

        Address address1 = new Address(
                dto.getZipCode1(),
                dto.getAddress1(),
                dto.getAddressDetail1()
        );
        account.setAddress1(address1);

        Address address2 = new Address(
                dto.getZipCode2(),
                dto.getAddress2(),
                dto.getAddressDetail2()
        );
        account.setAddress2(address2);
    }


    public void accountList(AccountListDTO dto) {
        List<Account> accountList = accountDAO.findAll();
        long accountTotalCount = accountDAO.countAll();

        request.setAttribute("accountList", accountList);
        request.setAttribute("accountTotalCount", accountTotalCount);
    }
    public void accountList() {
        List<Account> accountList = accountDAO.findAll();
        long accountTotalCount = accountDAO.countAll();

        request.setAttribute("accountList", accountList);
        request.setAttribute("accountTotalCount", accountTotalCount);
    }

    public boolean createAccount(AccountInputDTO dto) {
        try {
            Account account = new Account();
            accountFields(account, dto);
            accountDAO.create(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean findAccountById(Integer accountId) {
        Account account = accountDAO.find(accountId);
        if (account != null) {
            request.setAttribute("account", account);
            return true;
        }
        return false;
    }

    public boolean updateAccount(AccountInputDTO dto) {
        Account account = accountDAO.find(dto.getId());
        if (account == null) {
            return false;
        }
        try {
            accountFields(account, dto);
            accountDAO.update(account);

            return true;
        }catch (Exception e){
            return false;
        }
    }

}
