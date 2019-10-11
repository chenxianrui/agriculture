package com.ruoyi.project.system.equipment.mysqlDomain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Equipment extends BaseEntity{

    /** 设备ID */
    @Excel(name = "设备序号", cellType = Excel.ColumnType.NUMERIC, prompt = "设备编号")
    private String equipmentId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date productionTime;

    /** 传感器种类 */
    @Excel(name = "传感器种类")
    private String sensorType;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 设备IP地址 */
    @Excel(name = "设备IP地址")
    private String equipmentIpAddress;

    /** 端口号 */
    @Excel(name = "端口号")
    private String port;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private EquipmentDept equipmentDept;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getEquipmentIpAddress() {
        return equipmentIpAddress;
    }

    public void setEquipmentIpAddress(String equipmentIpAddress) {
        this.equipmentIpAddress = equipmentIpAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public EquipmentDept getEquipmentDept() {
        return equipmentDept;
    }

    public void setEquipmentDept(EquipmentDept equipmentDept) {
        this.equipmentDept = equipmentDept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("equipmentId", getEquipmentId())
                .append("equipmentName", getEquipmentName())
                .append("productionTime", getProductionTime())
                .append("sensorType", getSensorType())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("equipmentIpAddress", getEquipmentIpAddress())
                .append("port", getPort())
                .append("createTime", getCreateTime())
                .append("equipmentDept", getEquipmentDept())
                .toString();
    }
}
