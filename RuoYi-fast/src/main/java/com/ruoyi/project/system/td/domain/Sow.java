package com.ruoyi.project.system.td.domain;

import java.util.Date;

public class Sow {

    private int id;
    private String dtime;
    private int state;
    private float averageTemperature;
    private float averageHumidity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(float averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public float getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(float averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    @Override
    public String toString() {
        return "Sow{" +
                "id=" + id +
                ", dtime=" + dtime +
                ", state=" + state +
                ", averageTemperature=" + averageTemperature +
                ", averageHumidity=" + averageHumidity +
                '}';
    }
}
