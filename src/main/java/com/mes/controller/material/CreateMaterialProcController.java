package com.mes.controller.material;

import com.mes.controller.Controller;
import com.mes.dto.material.MaterialDTO;
import com.mes.service.MaterialService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateMaterialProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateMaterialProcController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MaterialDTO dto = new MaterialDTO();

        String account_id = request.getParameter("accountId");
        String purchaseUnitCost = request.getParameter("purchaseUnitCost");
        String price = request.getParameter("price");

        if (account_id.isEmpty()) {
            account_id = null;
        } else if (purchaseUnitCost.isEmpty()) {
            purchaseUnitCost = null;
        } else if (price.isEmpty()) {
            price = null;
        } else {
            dto.setAccountId(Integer.valueOf(account_id));
            dto.setPurchaseUnitCost(Integer.valueOf(purchaseUnitCost));
            dto.setPrice(Integer.valueOf(price));
        }

        dto.setNumber(request.getParameter("number"));
        dto.setName(request.getParameter("name"));
        dto.setUnit(request.getParameter("unit"));
        dto.setSc(request.getParameter("sc"));
        dto.setStandard(request.getParameter("std"));
        dto.setTexture(request.getParameter("texture"));
        dto.setRm(request.getParameter("rm"));
        dto.setShp(request.getParameter("shp"));
        dto.setMdt(request.getParameter("mdt"));
        dto.setMdw(request.getParameter("mdw"));
        dto.setMl(request.getParameter("ml"));
        dto.setMaker(request.getParameter("maker"));
        dto.setStorage1(request.getParameter("storage1"));
        dto.setStorage2(request.getParameter("storage2"));
        dto.setStorage3(request.getParameter("storage3"));

        MaterialService materialService = new MaterialService(request);
        boolean result = materialService.createMaterial(dto);
//        boolean result = materialService.insertMaterial(dto);


        String target = "materialList.do";
        request.setAttribute("target", target);

        return "/mes/script/redirect.jsp";
    }
}
