package com.ruoyi.project.system.equipment.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.equipment.mapper.EquipmentDeptMapper;
import com.ruoyi.project.system.equipment.mapper.EquipmentMapper;
import com.ruoyi.project.system.equipment.mysqlDomain.Equipment;
import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements IEquipmentService {


    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private EquipmentDeptMapper equipmentDeptMapper;

    /**
     * 通过部门ID查询设备
     *
     * @param deptId
     * @return
     */
    @Override
    public List<Equipment> selectEquipmentByDeptId(Integer deptId) {
        return equipmentMapper.selectEquipmentByDeptId(deptId);
    }

    /**
     * 通过部门ID查询设备使用数量
     *
     * @param deptId
     * @return
     */
    @Override
    public int countEquipmentDeptByDeptId(Integer deptId) {
        return equipmentMapper.countEquipmentDeptByDeptId(deptId);
    }

    /**
     * 通过条件分页查询设备
     *
     * @param equipmentDept
     * @return
     */
    @Override
    public List<Equipment> selectEquipmentList(EquipmentDept equipmentDept) {
        return equipmentMapper.selectEquipmentList(equipmentDept);
    }

    /**
     * 通过设备ID删除设备
     *
     * @param equipmentId 设备ID
     * @return
     */
    @Override
    public int deleteEquipmentById(Integer equipmentId) {
        return equipmentMapper.deleteEquipmentById(equipmentId);
    }

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备ID
     * @return
     */
    @Override
    public int deleteEquipmentByIds(String ids) throws BusinessException {
        String[] equipmentIds = Convert.toStrArray(ids);
        equipmentDeptMapper.deleteEquipmentDeptByIds(equipmentIds);
        return equipmentMapper.deleteEquipmentByIds(equipmentIds);
    }

    /**
     * 新增设备信息
     *
     * @param equipment 设备信息
     * @return
     */
    @Override
    public int insertEquipment(Equipment equipment, EquipmentDept equipmentDept) {
        equipmentDeptMapper.insertEquipmentDept(equipmentDept);
        return equipmentMapper.insertEquipment(equipment);
    }

    /**
     * 查询与设备相关的信息
     *
     * @param equipmentId
     * @return
     */
    @Override
    public Equipment selectEquipmentById(String equipmentId) {
        return equipmentMapper.selectEquipmentById(equipmentId);
    }

    /**
     * 修改保存设备信息
     *
     * @param equipment
     * @return
     */
    @Override
    public int updateEquipment(Equipment equipment, EquipmentDept equipmentDept) {
        equipmentDeptMapper.updateEquipmentDept(equipmentDept);
        return equipmentMapper.updateEquipment(equipment);
    }

    /**
     * 根据设备ID查询部门名称
     *
     * @param equipmentId
     * @return
     */
    @Override
    public String selectDeptNameByEquipmentId(String equipmentId) {
        return equipmentDeptMapper.selectDeptNameByEquipmentId(equipmentId);
    }

    /**
     * 根据设备ID查询部门ID
     *
     * @param equipmentId
     * @return
     */
    @Override
    public Integer selectDeptIdByEquipmentId(String equipmentId) {
        return equipmentDeptMapper.selectDeptIdByEquipmentId(equipmentId);
    }
}
