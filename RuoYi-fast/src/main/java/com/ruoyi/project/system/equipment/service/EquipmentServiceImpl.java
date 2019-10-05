package com.ruoyi.project.system.equipment.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.equipment.domain.TiotSun5016;
import com.ruoyi.project.system.equipment.mapper.EquipmentDeptMapper;
import com.ruoyi.project.system.equipment.mysqlDomain.EquipmentDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements IEquipmentService {


    @Autowired
    private EquipmentDeptMapper equipmentDeptMapper;

    /**
     * 通过部门ID查询设备
     *
     * @param deptId
     * @return
     */
    @Override
    public List<EquipmentDept> selectEquipmentByDeptId(Integer deptId) {
        return equipmentDeptMapper.selectEquipmentByDeptId(deptId);
    }

    /**
     * 通过部门ID查询设备使用数量
     *
     * @param deptId
     * @return
     */
    @Override
    public int countEquipmentDeptByDeptId(Integer deptId) {
        return equipmentDeptMapper.countEquipmentDeptByDeptId(deptId);
    }

    /**
     * 通过条件分页查询设备
     *
     * @param equipmentDept
     * @return
     */
    @Override
    public List<EquipmentDept> selectEquipmentList(EquipmentDept equipmentDept) {
        return equipmentDeptMapper.selectEquipmentList(equipmentDept);
    }

    /**
     * 通过设备ID删除设备
     *
     * @param equipmentId 设备ID
     * @return
     */
    @Override
    public int deleteEquipmentById(Integer equipmentId) {
        return equipmentDeptMapper.deleteEquipmentById(equipmentId);
    }

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备ID
     * @return
     */
    @Override
    public int deleteEquipmentByIds(String ids) throws BusinessException {
        Integer[] equipmentIds = Convert.toIntArray(ids);
        return equipmentDeptMapper.deleteEquipmentByIds(equipmentIds);
    }

    /**
     * 新增设备信息
     *
     * @param equipmentDept 设备信息
     * @return
     */
    @Override
    public int insertEquipment(EquipmentDept equipmentDept) {
        return equipmentDeptMapper.insertEquipment(equipmentDept);
    }

    /**
     * 查询与设备相关的信息
     *
     * @param equipmentId
     * @return
     */
    @Override
    public EquipmentDept selectEquipmentById(Integer equipmentId) {
        return equipmentDeptMapper.selectEquipmentById(equipmentId);
    }

    /**
     * 修改保存设备信息
     *
     * @param equipmentDept
     * @return
     */
    @Override
    public int updateEquipment(EquipmentDept equipmentDept) {
        return equipmentDeptMapper.updateEquipment(equipmentDept);
    }
}
