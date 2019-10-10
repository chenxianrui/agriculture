package com.ruoyi.project.system.equipment.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
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

    @Override
    public String importEquipment(List<Equipment> equipmentList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(equipmentList) || equipmentList.size() == 0){
            throw new BusinessException("导入设备数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
