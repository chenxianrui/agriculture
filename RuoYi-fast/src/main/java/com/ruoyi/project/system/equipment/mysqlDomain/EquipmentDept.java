package com.ruoyi.project.system.equipment.mysqlDomain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class EquipmentDept extends BaseEntity{

    private Integer deptId;
    private String equipmentId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
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
