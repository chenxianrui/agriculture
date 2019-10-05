package com.ruoyi.project.system.equipment.mapper;

import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;

import java.util.List;

public interface EquipmentDeptMapper {

    /**
     * 根据部门ID查询设备列表
     *
     * @param deptId
     * @return
     */
    public List<EquipmentDept> selectEquipmentByDeptId(Integer deptId);

    /**
     * 通过部门ID查询设备使用数量
     *
     * @param deptId
     * @return
     */
    public int countEquipmentDeptByDeptId(Integer deptId);

    /**
     * 根据条件分页查询设备列表
     *
     * @param equipmentDept
     * @return
     */
    public List<EquipmentDept> selectEquipmentList(EquipmentDept equipmentDept);

    /**
     * 通过设备ID删除设备
     *
     * @param id 设备ID
     * @return
     */
    public int deleteEquipmentById(Integer equipmentId);

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备ID
     * @return
     */
    public int deleteEquipmentByIds(Integer[] ids);

    /**
     * 新增设备信息
     *
     * @param equipmentDept 设备信息
     * @return
     */
    public int insertEquipment(EquipmentDept equipmentDept);

    /**
     * 查询与设备相关的信息
     *
     * @param equipmentId
     * @return
     */
    public EquipmentDept selectEquipmentById(Integer equipmentId);

    /**
     * 修改保存设备信息
     *
     * @param equipmentDept
     * @return
     */
    public int updateEquipment(EquipmentDept equipmentDept);
}
