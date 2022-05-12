package com.mes.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController implements Controller {
    private static final String METHOD = "GET";
    @Override
    public String getMethod() {
        return MainController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/mes/main.jsp";
    }
}
