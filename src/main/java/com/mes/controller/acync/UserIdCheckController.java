package com.mes.controller.acync;

import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userIdCheck")
public class UserIdCheckController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String userId =  req.getParameter("userId");
        boolean result =  userService.userIdCheck(userId);

        PrintWriter writer = resp.getWriter();
        writer.write(String.valueOf(result));
        writer.flush();
    }
}
