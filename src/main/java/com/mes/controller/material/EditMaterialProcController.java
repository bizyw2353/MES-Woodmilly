package com.mes.controller.material;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditMaterialProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EditMaterialProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/mes/material/materialList.jsp";
    }
}
