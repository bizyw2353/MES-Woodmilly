package com.mes.controller.popup;

import com.mes.controller.Controller;
import com.mes.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PopupAccountListController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return PopupAccountListController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService(request);
        accountService.accountList();
        return "/mes/popup/popupAccountList.jsp";
    }
}
