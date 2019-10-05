package com.ruoyi.project.system.equipment.service;

import com.ruoyi.project.system.equipment.domain.TiotSun5016;
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
    public List<EquipmentDept> selectEquipmentByDeptId(Integer deptId);

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
     * @param equipmentDept
     * @return
     */
    public List<EquipmentDept> selectEquipmentList(EquipmentDept equipmentDept);

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
