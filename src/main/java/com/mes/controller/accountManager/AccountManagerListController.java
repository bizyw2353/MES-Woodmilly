package com.mes.controller.accountManager;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class AccountManagerListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return AccountManagerListController.METHOD;
    }

    private void setNavigation(HttpServletRequest request) {
        HashSet<String> navigation = new HashSet<>();
        navigation.add("거래처 관리");
        navigation.add("거래처 담당 관리");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);



        return null;
    }
}
