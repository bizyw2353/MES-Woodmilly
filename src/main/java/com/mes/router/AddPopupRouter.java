package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.popup.PopupAccountListController;

import java.util.HashMap;

public class AddPopupRouter {

    public AddPopupRouter(HashMap<String, Controller> router) {
        router.put("/popup/AccountList.do", new PopupAccountListController());
    }
}
