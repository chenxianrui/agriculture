package com.ruoyi.project.system.equipment.controller;

import com.ruoyi.framework.TDengine.sql.TDfirst;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.equipment.mysqlDomain.Equipment;
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
        List<Equipment> list = equipmentService.selectEquipmentList(equipmentDept);
        return getDataTable(list);
    }

    @RequiresPermissions("system:equipment:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
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
    public AjaxResult addSave(@Validated Equipment equipment, @Validated EquipmentDept equipmentDept)
    {
        System.out.println(equipment);
        System.out.println(equipmentDept.getDeptId()+"=============="+equipmentDept.getEquipmentId());
        return toAjax(equipmentService.insertEquipment(equipment, equipmentDept));
    }

    /**
     * 修改设备
     *
     * @param equipmentId
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{equipmentId}")
    public String edit(@PathVariable("equipmentId") String equipmentId, ModelMap mmap)
    {
        mmap.put("equipment", equipmentService.selectEquipmentById(equipmentId));
        mmap.put("deptName", equipmentService.selectDeptNameByEquipmentId(equipmentId));
        mmap.put("deptId", equipmentService.selectDeptIdByEquipmentId(equipmentId));
        return prefix + "/edit";
    }

    /**
     * 修改保存设备
     *
     * @param equipment
     * @param equipmentDept
     * @return
     */
    @RequiresPermissions("system:equipment:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Equipment equipment, @Validated EquipmentDept equipmentDept)
    {
        return toAjax(equipmentService.updateEquipment(equipment, equipmentDept));
    }
}
