package com.mes.controller.material;

import com.mes.controller.Controller;
import com.mes.entity.Material;
import com.mes.service.MaterialService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class MaterialListController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return MaterialListController.METHOD;
    }


    private void setNavigation(HttpServletRequest request) {
        HashSet<String> navigation = new HashSet<>();
        navigation.add("원자재 관리");
        navigation.add(" 정보 관리");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setNavigation(request);

        MaterialService service = new MaterialService(request);
        boolean result = service.findAll();

        if (result) {
            return "mes/material/materialList.jsp";
        }

        return "mes/script/redirect.jsp";

    }
}
