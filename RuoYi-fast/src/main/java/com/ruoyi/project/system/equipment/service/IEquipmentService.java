package com.ruoyi.project.system.equipment.service;

import com.ruoyi.project.system.equipment.domain.TiotSun5016;
import com.ruoyi.project.system.equipment.mysqlDomain.Equipment;
import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;
import io.swagger.models.auth.In;

import java.util.List;

public interface IEquipmentService {



    /**
     * 通过部门ID查询设备
     *
     * @param deptId
     * @return
     */
    public List<Equipment> selectEquipmentByDeptId(Integer deptId);

    /**
     * 通过部门ID查询设备使用数量
     *
     * @param deptId
     * @return
     */
    public int countEquipmentDeptByDeptId(Integer deptId);

    /**
     *根据条件分页查询设备列表
     *
     * @param equipment
     * @return
     */
    public List<Equipment> selectEquipmentList(EquipmentDept equipmentDept);

    /**
     * 通过设备ID删除设备
     *
     * @param equipmentId 设备ID
     * @return 结果
     */
    public int deleteEquipmentById(Integer equipmentId);

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备ID
     * @return
     */
    public int deleteEquipmentByIds(String ids) throws Exception;

    /**
     * 新增设备信息
     *
     * @param equipmentDept 设备信息
     * @return
     */
    public int insertEquipment(Equipment equipment, EquipmentDept equipmentDept);

    /**
     * 查询与设备相关的信息
     *
     * @param equipmentId
     * @return
     */
    public Equipment selectEquipmentById(String equipmentId);

    /**
     * 修改保存设备信息
     *
     * @param equipment
     * @return
     */
    public int updateEquipment(Equipment equipment, EquipmentDept equipmentDept);

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
     * 导入设备数据
     *
     * @param equipmentList 设备数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importEquipment(List<Equipment> equipmentList, Boolean isUpdateSupport);
}
