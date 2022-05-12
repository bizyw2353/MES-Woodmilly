package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.material.*;

import java.util.HashMap;

public class AddMaterialRouter {

    public AddMaterialRouter(HashMap<String, Controller> router) {

        router.put("/materialCreate.do", new CreateMaterialController());
        router.put("/materialCreateProc.do", new CreateMaterialProcController());
        router.put("/materialList.do", new MaterialListController());
        router.put("/materialDelete.do", new DeleteMaterialController());
        router.put("/materialEdit.do", new EditMaterialController());

    }
}
