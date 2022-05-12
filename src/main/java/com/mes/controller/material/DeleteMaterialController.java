package com.mes.controller.material;

import com.mes.controller.Controller;
import com.mes.service.MaterialService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMaterialController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return DeleteMaterialController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MaterialService materialService = new MaterialService(request);

        String[] selectedId = request.getParameterValues("selectedId");
        for (String ids : selectedId) {
            materialService.deleteMaterial(ids);
        }

        String target = "/mes/material/materialList.jsp";
        request.setAttribute("target", target);

        return "/error/errorHandle.jsp";
    }
}
