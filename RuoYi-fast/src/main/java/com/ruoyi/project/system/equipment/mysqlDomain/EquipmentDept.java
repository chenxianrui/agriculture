package com.ruoyi.project.system.equipment.mysqlDomain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class EquipmentDept extends BaseEntity{

    private Integer deptId;
    private Integer equipmentId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Override
    public String toString() {
        return "EquipmentDept{" +
                "deptId=" + deptId +
                ", equipmentId=" + equipmentId +
                '}';
    }
}
