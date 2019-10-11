package com.ruoyi.project.system.equipment.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.TDengine.sql.TDfirst;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.equipment.mysqlDomain.Equipment;
import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;
import com.ruoyi.project.system.equipment.service.EquipmentServiceImpl;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public TableDataInfo select(Equipment equipment,EquipmentDept equipmentDept)
    {
        equipment.setEquipmentDept(equipmentDept);
        startPage();
        List<Equipment> list = equipmentService.selectEquipmentList(equipment);
        return getDataTable(list);
    }

    @Log(title = "设备管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:equipment:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Equipment> util = new ExcelUtil<Equipment>(Equipment.class);
        List<Equipment> equipmentList = util.importExcel(file.getInputStream());
        String message = equipmentService.importEquipment(equipmentList, updateSupport);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:equipment:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Equipment> util = new ExcelUtil<Equipment>(Equipment.class);
        return util.importTemplateExcel("设备数据");
    }

    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:equipment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Equipment equipment)
    {
        List<Equipment> list = equipmentService.selectEquipmentList(equipment);
        ExcelUtil<Equipment> util = new ExcelUtil<Equipment>(Equipment.class);
        return util.exportExcel(list, "设备数据");
    }

    /**
     * 批量删除设备
     *
     * @param ids
     * @return
     */
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
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Equipment equipment, @Validated EquipmentDept equipmentDept)
    {
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
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Equipment equipment, @Validated EquipmentDept equipmentDept)
    {
        return toAjax(equipmentService.updateEquipment(equipment, equipmentDept));
    }
}
