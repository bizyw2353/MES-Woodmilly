package com.mes.controller;

import com.mes.dto.LoginDTO;
import com.mes.exception.FailServiceException;
import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginProcController implements Controller {
    private static final String METHOD = "POST";
    @Override
    public String getMethod() {
        return LoginProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginDTO loginDTO = new LoginDTO();
        UserService userService = new UserService();

        loginDTO.setUserId(request.getParameter("userId"));
        loginDTO.setPassword(request.getParameter("password"));

        try {
            userService.login(loginDTO);
            session.setAttribute("SESSION_ID", loginDTO.getUserId());
            session.setAttribute("target", "/main.do");
            return "/mes/script/redirect.jsp";
        }catch (FailServiceException e){
            e.printStackTrace();
            request.setAttribute("result", "fail");
            request.setAttribute("message", e.getMessage());
            request.setAttribute("target", "/login.do");
            return "/mes/script/redirect.jsp";
        }

    }
}
