package com.ruoyi.project.system.screen.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.equipment.mysqlDomain.Equipment;
import com.ruoyi.project.system.screen.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/system/screen")
public class ScreenController extends BaseController{

    private String prefix = "system/screen";

    @Autowired
    private ScreenService screenService;

    @GetMapping()
    public String screen(ModelMap mmap)
    {
        List<Equipment> equipmentList = screenService.selectEquipmentScreenList();
        System.out.println(equipmentList);
        mmap.put("equipmentList", equipmentList);
        return prefix + "/screen";
    }
}
