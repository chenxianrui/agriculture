package com.ruoyi.project.system.equipment.domain;

import java.sql.Date;

public class TiotSun5016 {

    private Date ts;            //时间戳
    private int id;             //ID
    private int address;        //地址
    private float ambientTemperature;   //环温
    private float temperature1;         //温度1
    private float temperature2;         //温度2
    private float temperature3;         //温度3
    private float temperature4;         //温度4
    private float temperature5;         //温度5
    private float dewPoint;             //露点
    private float ambientHumidity;      //环湿
    private float landHumidity1;        //土湿1
    private float landHumidity2;        //土湿2
    private float landHumidity3;        //土湿3
    private float flowOfWater;          //水势
    private float salinity;             //盐分
    private float waterLevel;           //水位
    private float co;                   //CO
    private float co2;                  //CO2
    private float evaporation;          //蒸发
    private float pressuer;             //气压
    private float windDirection;        //风向
    private float windSpeed;            //风速
    private float averageWindSpeed2;    //2分钟平均风速
    private float averageWindSpeed10;   //10分钟平均风速
    private float cumulativeRainfallInterval;   //雨量间隔累计
    private float dailyCumulativeRainfall;      //雨量日累计
    private float cumulativeSunshineInterval;   //日照间隔累计
    private float dailyCumulativeSunshine;      //日照时日累计
    private float totalRadiation;               //总辐射
    private float divergentRadiation;           //散辐射
    private float directRadiation;              //直辐射
    private float net_radiation;                //净辐射
    private float photosynthetic_radiation;     //光合辐射
    private float ultraviolet_radiation;        //紫外辐射
    private float soil_heat_flux1;              //土壤热通量
    private float total_radiation_interval_cumulative;          //总辐射间隔累计
    private float cumulative_divergent_radiation_interval;      //散辐射间隔累计
    private float cumulative_direct_radiation_interval;         //直辐射间隔累计
    private float cumulative_net_radiation_interval;            //净辐射间隔累计
    private float cumulative_interval_photosynthetic_radiation; //光合辐射间隔累计
    private float cumulative_interval_ultraviolet_radiation;    //紫外辐射间隔累计
    private float soil_heat_flux2;                              //土壤热通量
    private float daily_cumulative_total_radiation;             //总辐射日累计
    private float daily_accumulation_of_scattered_radiation;    //散辐射日累计
    private float direct_radiation_days_accumulation;           //直辐射日累计
    private float daily_cumulative_net_radiation;               //净辐射日累计
    private float daily_accumulation_of_photosynthetic_radiation;           //光合辐射日累计
    private float daily_accumulation_of_ultraviolet_radiatssion;            //紫外辐射日累计
    private float soil_heat_flux3;                                          //土壤热通量
    private float illumination;                                             //光照
    private float electric_quantity;                                        //电量

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public float getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(float ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public float getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(float temperature1) {
        this.temperature1 = temperature1;
    }

    public float getTemperature2() {
        return temperature2;
    }

    public void setTemperature2(float temperature2) {
        this.temperature2 = temperature2;
    }

    public float getTemperature3() {
        return temperature3;
    }

    public void setTemperature3(float temperature3) {
        this.temperature3 = temperature3;
    }

    public float getTemperature4() {
        return temperature4;
    }

    public void setTemperature4(float temperature4) {
        this.temperature4 = temperature4;
    }

    public float getTemperature5() {
        return temperature5;
    }

    public void setTemperature5(float temperature5) {
        this.temperature5 = temperature5;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public float getAmbientHumidity() {
        return ambientHumidity;
    }

    public void setAmbientHumidity(float ambientHumidity) {
        this.ambientHumidity = ambientHumidity;
    }

    public float getLandHumidity1() {
        return landHumidity1;
    }

    public void setLandHumidity1(float landHumidity1) {
        this.landHumidity1 = landHumidity1;
    }

    public float getLandHumidity2() {
        return landHumidity2;
    }

    public void setLandHumidity2(float landHumidity2) {
        this.landHumidity2 = landHumidity2;
    }

    public float getLandHumidity3() {
        return landHumidity3;
    }

    public void setLandHumidity3(float landHumidity3) {
        this.landHumidity3 = landHumidity3;
    }

    public float getFlowOfWater() {
        return flowOfWater;
    }

    public void setFlowOfWater(float flowOfWater) {
        this.flowOfWater = flowOfWater;
    }

    public float getSalinity() {
        return salinity;
    }

    public void setSalinity(float salinity) {
        this.salinity = salinity;
    }

    public float getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.waterLevel = waterLevel;
    }

    public float getCo() {
        return co;
    }

    public void setCo(float co) {
        this.co = co;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public float getEvaporation() {
        return evaporation;
    }

    public void setEvaporation(float evaporation) {
        this.evaporation = evaporation;
    }

    public float getPressuer() {
        return pressuer;
    }

    public void setPressuer(float pressuer) {
        this.pressuer = pressuer;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(float windDirection) {
        this.windDirection = windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getAverageWindSpeed2() {
        return averageWindSpeed2;
    }

    public void setAverageWindSpeed2(float averageWindSpeed2) {
        this.averageWindSpeed2 = averageWindSpeed2;
    }

    public float getAverageWindSpeed10() {
        return averageWindSpeed10;
    }

    public void setAverageWindSpeed10(float averageWindSpeed10) {
        this.averageWindSpeed10 = averageWindSpeed10;
    }

    public float getCumulativeRainfallInterval() {
        return cumulativeRainfallInterval;
    }

    public void setCumulativeRainfallInterval(float cumulativeRainfallInterval) {
        this.cumulativeRainfallInterval = cumulativeRainfallInterval;
    }

    public float getDailyCumulativeRainfall() {
        return dailyCumulativeRainfall;
    }

    public void setDailyCumulativeRainfall(float dailyCumulativeRainfall) {
        this.dailyCumulativeRainfall = dailyCumulativeRainfall;
    }

    public float getCumulativeSunshineInterval() {
        return cumulativeSunshineInterval;
    }

    public void setCumulativeSunshineInterval(float cumulativeSunshineInterval) {
        this.cumulativeSunshineInterval = cumulativeSunshineInterval;
    }

    public float getDailyCumulativeSunshine() {
        return dailyCumulativeSunshine;
    }

    public void setDailyCumulativeSunshine(float dailyCumulativeSunshine) {
        this.dailyCumulativeSunshine = dailyCumulativeSunshine;
    }

    public float getTotalRadiation() {
        return totalRadiation;
    }

    public void setTotalRadiation(float totalRadiation) {
        this.totalRadiation = totalRadiation;
    }

    public float getDivergentRadiation() {
        return divergentRadiation;
    }

    public void setDivergentRadiation(float divergentRadiation) {
        this.divergentRadiation = divergentRadiation;
    }

    public float getDirectRadiation() {
        return directRadiation;
    }

    public void setDirectRadiation(float directRadiation) {
        this.directRadiation = directRadiation;
    }

    public float getNet_radiation() {
        return net_radiation;
    }

    public void setNet_radiation(float net_radiation) {
        this.net_radiation = net_radiation;
    }

    public float getPhotosynthetic_radiation() {
        return photosynthetic_radiation;
    }

    public void setPhotosynthetic_radiation(float photosynthetic_radiation) {
        this.photosynthetic_radiation = photosynthetic_radiation;
    }

    public float getUltraviolet_radiation() {
        return ultraviolet_radiation;
    }

    public void setUltraviolet_radiation(float ultraviolet_radiation) {
        this.ultraviolet_radiation = ultraviolet_radiation;
    }

    public float getSoil_heat_flux1() {
        return soil_heat_flux1;
    }

    public void setSoil_heat_flux1(float soil_heat_flux1) {
        this.soil_heat_flux1 = soil_heat_flux1;
    }

    public float getTotal_radiation_interval_cumulative() {
        return total_radiation_interval_cumulative;
    }

    public void setTotal_radiation_interval_cumulative(float total_radiation_interval_cumulative) {
        this.total_radiation_interval_cumulative = total_radiation_interval_cumulative;
    }

    public float getCumulative_divergent_radiation_interval() {
        return cumulative_divergent_radiation_interval;
    }

    public void setCumulative_divergent_radiation_interval(float cumulative_divergent_radiation_interval) {
        this.cumulative_divergent_radiation_interval = cumulative_divergent_radiation_interval;
    }

    public float getCumulative_direct_radiation_interval() {
        return cumulative_direct_radiation_interval;
    }

    public void setCumulative_direct_radiation_interval(float cumulative_direct_radiation_interval) {
        this.cumulative_direct_radiation_interval = cumulative_direct_radiation_interval;
    }

    public float getCumulative_net_radiation_interval() {
        return cumulative_net_radiation_interval;
    }

    public void setCumulative_net_radiation_interval(float cumulative_net_radiation_interval) {
        this.cumulative_net_radiation_interval = cumulative_net_radiation_interval;
    }

    public float getCumulative_interval_photosynthetic_radiation() {
        return cumulative_interval_photosynthetic_radiation;
    }

    public void setCumulative_interval_photosynthetic_radiation(float cumulative_interval_photosynthetic_radiation) {
        this.cumulative_interval_photosynthetic_radiation = cumulative_interval_photosynthetic_radiation;
    }

    public float getCumulative_interval_ultraviolet_radiation() {
        return cumulative_interval_ultraviolet_radiation;
    }

    public void setCumulative_interval_ultraviolet_radiation(float cumulative_interval_ultraviolet_radiation) {
        this.cumulative_interval_ultraviolet_radiation = cumulative_interval_ultraviolet_radiation;
    }

    public float getSoil_heat_flux2() {
        return soil_heat_flux2;
    }

    public void setSoil_heat_flux2(float soil_heat_flux2) {
        this.soil_heat_flux2 = soil_heat_flux2;
    }

    public float getDaily_cumulative_total_radiation() {
        return daily_cumulative_total_radiation;
    }

    public void setDaily_cumulative_total_radiation(float daily_cumulative_total_radiation) {
        this.daily_cumulative_total_radiation = daily_cumulative_total_radiation;
    }

    public float getDaily_accumulation_of_scattered_radiation() {
        return daily_accumulation_of_scattered_radiation;
    }

    public void setDaily_accumulation_of_scattered_radiation(float daily_accumulation_of_scattered_radiation) {
        this.daily_accumulation_of_scattered_radiation = daily_accumulation_of_scattered_radiation;
    }

    public float getDirect_radiation_days_accumulation() {
        return direct_radiation_days_accumulation;
    }

    public void setDirect_radiation_days_accumulation(float direct_radiation_days_accumulation) {
        this.direct_radiation_days_accumulation = direct_radiation_days_accumulation;
    }

    public float getDaily_cumulative_net_radiation() {
        return daily_cumulative_net_radiation;
    }

    public void setDaily_cumulative_net_radiation(float daily_cumulative_net_radiation) {
        this.daily_cumulative_net_radiation = daily_cumulative_net_radiation;
    }

    public float getDaily_accumulation_of_photosynthetic_radiation() {
        return daily_accumulation_of_photosynthetic_radiation;
    }

    public void setDaily_accumulation_of_photosynthetic_radiation(float daily_accumulation_of_photosynthetic_radiation) {
        this.daily_accumulation_of_photosynthetic_radiation = daily_accumulation_of_photosynthetic_radiation;
    }

    public float getDaily_accumulation_of_ultraviolet_radiatssion() {
        return daily_accumulation_of_ultraviolet_radiatssion;
    }

    public void setDaily_accumulation_of_ultraviolet_radiatssion(float daily_accumulation_of_ultraviolet_radiatssion) {
        this.daily_accumulation_of_ultraviolet_radiatssion = daily_accumulation_of_ultraviolet_radiatssion;
    }

    public float getSoil_heat_flux3() {
        return soil_heat_flux3;
    }

    public void setSoil_heat_flux3(float soil_heat_flux3) {
        this.soil_heat_flux3 = soil_heat_flux3;
    }

    public float getIllumination() {
        return illumination;
    }

    public void setIllumination(float illumination) {
        this.illumination = illumination;
    }

    public float getElectric_quantity() {
        return electric_quantity;
    }

    public void setElectric_quantity(float electric_quantity) {
        this.electric_quantity = electric_quantity;
    }

    @Override
    public String toString() {
        return "TiotSun5016{" +
                "ts=" + ts +
                ", id=" + id +
                ", address=" + address +
                ", ambientTemperature=" + ambientTemperature +
                ", temperature1=" + temperature1 +
                ", temperature2=" + temperature2 +
                ", temperature3=" + temperature3 +
                ", temperature4=" + temperature4 +
                ", temperature5=" + temperature5 +
                ", dewPoint=" + dewPoint +
                ", ambientHumidity=" + ambientHumidity +
                ", landHumidity1=" + landHumidity1 +
                ", landHumidity2=" + landHumidity2 +
                ", landHumidity3=" + landHumidity3 +
                ", flowOfWater=" + flowOfWater +
                ", salinity=" + salinity +
                ", waterLevel=" + waterLevel +
                ", co=" + co +
                ", co2=" + co2 +
                ", evaporation=" + evaporation +
                ", pressuer=" + pressuer +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                ", averageWindSpeed2=" + averageWindSpeed2 +
                ", averageWindSpeed10=" + averageWindSpeed10 +
                ", cumulativeRainfallInterval=" + cumulativeRainfallInterval +
                ", dailyCumulativeRainfall=" + dailyCumulativeRainfall +
                ", cumulativeSunshineInterval=" + cumulativeSunshineInterval +
                ", dailyCumulativeSunshine=" + dailyCumulativeSunshine +
                ", totalRadiation=" + totalRadiation +
                ", divergentRadiation=" + divergentRadiation +
                ", directRadiation=" + directRadiation +
                ", net_radiation=" + net_radiation +
                ", photosynthetic_radiation=" + photosynthetic_radiation +
                ", ultraviolet_radiation=" + ultraviolet_radiation +
                ", soil_heat_flux1=" + soil_heat_flux1 +
                ", total_radiation_interval_cumulative=" + total_radiation_interval_cumulative +
                ", cumulative_divergent_radiation_interval=" + cumulative_divergent_radiation_interval +
                ", cumulative_direct_radiation_interval=" + cumulative_direct_radiation_interval +
                ", cumulative_net_radiation_interval=" + cumulative_net_radiation_interval +
                ", cumulative_interval_photosynthetic_radiation=" + cumulative_interval_photosynthetic_radiation +
                ", cumulative_interval_ultraviolet_radiation=" + cumulative_interval_ultraviolet_radiation +
                ", soil_heat_flux2=" + soil_heat_flux2 +
                ", daily_cumulative_total_radiation=" + daily_cumulative_total_radiation +
                ", daily_accumulation_of_scattered_radiation=" + daily_accumulation_of_scattered_radiation +
                ", direct_radiation_days_accumulation=" + direct_radiation_days_accumulation +
                ", daily_cumulative_net_radiation=" + daily_cumulative_net_radiation +
                ", daily_accumulation_of_photosynthetic_radiation=" + daily_accumulation_of_photosynthetic_radiation +
                ", daily_accumulation_of_ultraviolet_radiatssion=" + daily_accumulation_of_ultraviolet_radiatssion +
                ", soil_heat_flux3=" + soil_heat_flux3 +
                ", illumination=" + illumination +
                ", electric_quantity=" + electric_quantity +
                '}';
    }
}
