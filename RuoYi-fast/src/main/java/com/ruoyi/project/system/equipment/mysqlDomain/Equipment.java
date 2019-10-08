package com.ruoyi.project.system.equipment.mysqlDomain;

public class Equipment {

    private String equipmentId;
    private String equipmentName;
    private String productionTime;
    private String sensorType;
    private String longitude;
    private String latitude;
    private String equipmentIpAddress;
    private String port;
    private String createTime;

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

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId='" + equipmentId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", productionTime='" + productionTime + '\'' +
                ", sensorType='" + sensorType + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", equipmentIpAddress='" + equipmentIpAddress + '\'' +
                ", port='" + port + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
