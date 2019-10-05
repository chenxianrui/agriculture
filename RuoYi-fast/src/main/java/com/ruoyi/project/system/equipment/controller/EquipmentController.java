package com.ruoyi.project.system.equipment.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;
import com.ruoyi.project.system.equipment.service.EquipmentServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/equipment")
public class EquipmentController extends BaseController {

    private String prefix = "system/equipment";

    @Autowired
    private EquipmentServiceImpl equipmentService;

    @RequiresPermissions("system:equipment:view")
    @GetMapping()
    public String equipment(){
        return prefix + "/equipment";
    }

    @RequiresPermissions("system:equipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo select(EquipmentDept equipmentDept)
    {
        startPage();
        List<EquipmentDept> list = equipmentService.selectEquipmentList(equipmentDept);
        return getDataTable(list);
    }

    @RequiresPermissions("system:equipment:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        System.out.println(ids+"-------------");
        try
        {
            return toAjax(equipmentService.deleteEquipmentByIds(ids));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    /**
     * 新增设备
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:equipment:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated EquipmentDept equipmentDept)
    {
        System.out.println(equipmentDept);
        return toAjax(equipmentService.insertEquipment(equipmentDept));
    }

    /**
     * 修改设备
     *
     * @param equipmentId
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{equipmentId}")
    public String edit(@PathVariable("equipmentId") Integer equipmentId, ModelMap mmap)
    {
        System.out.println(equipmentService.selectEquipmentById(equipmentId));
        mmap.put("equipmentDept", equipmentService.selectEquipmentById(equipmentId));
        return prefix + "/edit";
    }


    @RequiresPermissions("system:equipment:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated EquipmentDept equipmentDept)
    {
        System.out.println(equipmentDept);
        return toAjax(equipmentService.updateEquipment(equipmentDept));
    }
}
