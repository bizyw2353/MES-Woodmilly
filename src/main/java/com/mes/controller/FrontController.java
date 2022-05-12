package com.mes.controller;

import com.mes.router.*;
import com.mes.util.HibernateUtil;
import lombok.extern.java.Log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Log
@WebServlet("*.do")
public class FrontController extends HttpServlet {

    public FrontController() {super();}

    private static final long serialVersionUID = 1L;

    HashMap<String, Controller> router = new HashMap<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        new AddMainRouter(router);
        new AddAccountRouter(router);
        new AddMaterialRouter(router);
        new AddPopupRouter(router);
        new AddUserRouter(router);

        router.put("/main.do", new MainController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        if(router.containsKey(path)){
            Controller frontController = router.get(path);
            String method = req.getMethod();

            if(method.equals(frontController.getMethod())){
                String viewPath = frontController.execute(req, resp);
                req.getRequestDispatcher(viewPath).forward(req,resp);
            }else {
                log.severe("403error : " + url);
                getServletContext().getRequestDispatcher("/error/403error.jsp").forward(req,resp);
            }

        }else {
            log.severe("404error : " + url);
            getServletContext().getRequestDispatcher("/error/404error.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {
        HibernateUtil.closeEntityManagerFactory();
    }


}
