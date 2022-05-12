package com.mes.controller;

import com.mes.dto.UserDTO;
import com.mes.entity.User;
import com.mes.exception.FailServiceException;
import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinProcController implements Controller {
    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return JoinProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // make service
        UserService userService = new UserService();

        // Dto
        UserDTO dto = new UserDTO();
        dto.setUserId(request.getParameter("userId"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));

        // join result
        try {
            userService.join(dto);
            request.setAttribute("result", "success");
            request.setAttribute("target", "/login.do");
            return "/error/errorHandle.jsp";

        } catch (FailServiceException e) {
            e.printStackTrace();
            request.setAttribute("result", "fail");
            request.setAttribute("message", e.getMessage());
            request.setAttribute("target", "/join.do");
            return "/error/errorHandle.jsp";
        }
    }
}
