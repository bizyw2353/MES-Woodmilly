package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.JoinController;
import com.mes.controller.JoinProcController;

import java.util.HashMap;

public class AddUserRouter {

    public AddUserRouter(HashMap<String, Controller> router) {
        router.put("/join.do",new JoinController());
        router.put("/joinProc.do",new JoinProcController());
    }
}
