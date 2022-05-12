package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.account.AccountListDTO;
import com.mes.entity.Account;
import com.mes.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class AccountListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return AccountListController.METHOD;
    }

    private AccountListDTO makeDTO(HttpServletRequest request) {
        String accountCode = request.getParameter("account_code");
        String accountName = request.getParameter("account_name");
        String accountKind = request.getParameter("account_kind");

        return new AccountListDTO(accountCode, accountName, accountKind);
    }

    private void setNavigation(HttpServletRequest request) {
        HashSet<String> navigation = new HashSet<>();
        navigation.add("거래처 관리");
        navigation.add("거래처 정보 관리");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        AccountListDTO accountListDTO = makeDTO(request);

        AccountService accountService = new AccountService(request);
        accountService.accountList(accountListDTO);

        return "/mes/account/accountList.jsp";
    }
}
