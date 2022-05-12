package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.account.AccountInputDTO;
import com.mes.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProcAccountController implements Controller {
    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcAccountController.METHOD;
    }

    private AccountInputDTO makeDTO(HttpServletRequest request) {
        String accountsCode = request.getParameter("accounts_code");
        String name = request.getParameter("name");
        String businessNumber = request.getParameter("business_number");
        String businessCategory = request.getParameter("business_category");
        String businessType = request.getParameter("business_type");
        String ceo = request.getParameter("ceo");
        String tel = request.getParameter("tel");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");
        String zipCode1 = request.getParameter("zip_code_1");
        String address1 = request.getParameter("address_1");
        String addressDetail1 = request.getParameter("address_detail_1");
        String zipCode2 = request.getParameter("zip_code_2");
        String address2 = request.getParameter("address_2");
        String addressDetail2 = request.getParameter("address_detail_2");
        String etc = request.getParameter("etc");

        return AccountInputDTO.builder()
                .accountCode(accountsCode)
                .name(name)
                .businessNumber(businessNumber)
                .businessCategory(businessCategory)
                .businessType(businessType)
                .ceo(ceo)
                .tel(tel)
                .fax(fax)
                .email(email)
                .zipCode1(zipCode1)
                .address1(address1)
                .addressDetail1(addressDetail1)
                .zipCode2(zipCode2)
                .address2(address2)
                .addressDetail2(addressDetail2)
                .etc(etc)
                .build();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountInputDTO dto = makeDTO(request);
        AccountService accountService = new AccountService(request);

        boolean result = accountService.createAccount(dto);

        if (result) {
            request.setAttribute("target", "/accountList.do");
            System.out.println("CreateProc ==========");
            return "/mes/script/redirect.jsp";
        }
        request.setAttribute("message", "거래처 등록이 실패하였습니다.");
        request.setAttribute("target", "/accountCreate.do");
        return "/mes/script/redirect.jsp";
    }
}
