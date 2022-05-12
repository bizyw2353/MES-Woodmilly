package com.mes.controller.material;

import com.mes.controller.Controller;
import com.mes.service.MaterialService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditMaterialController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return EditMaterialController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String accountName = request.getParameter("accountName");
        System.out.println("클릭한 id : "+ id);
        MaterialService materialService = new MaterialService(request);
        materialService.findMaterialById(id, accountName);

        return "/mes/material/editMaterial.jsp";
    }
}
