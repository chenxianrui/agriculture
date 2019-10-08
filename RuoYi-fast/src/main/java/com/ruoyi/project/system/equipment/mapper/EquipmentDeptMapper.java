package com.ruoyi.project.system.equipment.mapper;

import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;

import java.util.List;

public interface EquipmentDeptMapper {

    /**
     * 通过设备ID删除设备和部门的关联
     *
     * @param equipmentId
     * @return
     */
    public int deleteEquipmentDeptByEquipmentId(Integer equipmentId);

    /**
     * 批量删除设备和部门关联
     *
     * @param ids
     * @return
     */
    public int deleteEquipmentDeptByIds(String[] ids);

    /**
     * 新增设备与部门ID信息
     *
     * @param equipmentDept 设备与部门ID信息
     * @return
     */
    public int insertEquipmentDept(EquipmentDept equipmentDept);

    /**
     * 根据设备ID查询部门名称
     *
     * @param equipmentId
     * @return
     */
    public String selectDeptNameByEquipmentId(String equipmentId);

    /**
     * 根据设备ID查询部门ID
     *
     * @param equipmentId
     * @return
     */
    public Integer selectDeptIdByEquipmentId(String equipmentId);

    /**
     * 根据设备ID更新部门信息
     *
     * @param equipmentId
     * @return
     */
    public Integer updateEquipmentDept(EquipmentDept equipmentDept);
}
