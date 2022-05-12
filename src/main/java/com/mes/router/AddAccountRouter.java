package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.account.*;
import com.mes.controller.popup.account.PopupCreateAccountManager;

import java.util.HashMap;

public class AddAccountRouter {

    public AddAccountRouter(HashMap<String, Controller> router){
        router.put("/accountList.do", new AccountListController());
        router.put("/accountCreate.do", new CreateAccountController());
        router.put("/accountCreateProc.do", new CreateProcAccountController());
        router.put("/accountEdit.do", new EditAccountController());
        router.put("/accountEditProc.do", new EditProcAccountController());

        router.put("/accountManagerCreate.do", new PopupCreateAccountManager());

    }
}
