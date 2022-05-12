package com.mes.controller.material;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateMaterialController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return CreateMaterialController.METHOD;
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("원자재 관리");
        navigation.add("원자재 정보 관리");
        navigation.add("원자재 정보 등록");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setNavigation(request);

        return "/mes/material/createMaterial.jsp";
    }
}
