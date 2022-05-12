package com.mes.controller.account;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return CreateAccountController.METHOD;
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("거래처관리");
        navigation.add("거래처 정보 관리");
        navigation.add("거래처 등록 하기");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        return "/mes/account/accountCreate.jsp";
    }
}
