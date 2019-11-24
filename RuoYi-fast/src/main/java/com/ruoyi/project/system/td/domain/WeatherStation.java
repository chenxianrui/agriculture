package com.ruoyi.project.system.td.domain;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class WeatherStation {

    private String ts;
    private String id;
    private float wind_speed;
    private float rainfall;
    private float temperature;
    private float humidity;
    private float illumination;
    private float photosynthesis;
    private float wind_direction;
    private float co2;
    private float ph;
    private float soil_temperature_1;
    private float soil_moisture_1;
    private float soil_temperature_2;
    private float soil_moisture_2;
    private float soil_temperature_3;
    private float soil_moisture_3;
    private float conductance;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getRainfall() {
        return rainfall;
    }

    public void setRainfall(float rainfall) {
        this.rainfall = rainfall;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getIllumination() {
        return illumination;
    }

    public void setIllumination(float illumination) {
        this.illumination = illumination;
    }

    public float getPhotosynthesis() {
        return photosynthesis;
    }

    public void setPhotosynthesis(float photosynthesis) {
        this.photosynthesis = photosynthesis;
    }

    public float getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public float getSoil_temperature_1() {
        return soil_temperature_1;
    }

    public void setSoil_temperature_1(float soil_temperature_1) {
        this.soil_temperature_1 = soil_temperature_1;
    }

    public float getSoil_moisture_1() {
        return soil_moisture_1;
    }

    public void setSoil_moisture_1(float soil_moisture_1) {
        this.soil_moisture_1 = soil_moisture_1;
    }

    public float getSoil_temperature_2() {
        return soil_temperature_2;
    }

    public void setSoil_temperature_2(float soil_temperature_2) {
        this.soil_temperature_2 = soil_temperature_2;
    }

    public float getSoil_moisture_2() {
        return soil_moisture_2;
    }

    public void setSoil_moisture_2(float soil_moisture_2) {
        this.soil_moisture_2 = soil_moisture_2;
    }

    public float getSoil_temperature_3() {
        return soil_temperature_3;
    }

    public void setSoil_temperature_3(float soil_temperature_3) {
        this.soil_temperature_3 = soil_temperature_3;
    }

    public float getSoil_moisture_3() {
        return soil_moisture_3;
    }

    public void setSoil_moisture_3(float soil_moisture_3) {
        this.soil_moisture_3 = soil_moisture_3;
    }

    public float getConductance() {
        return conductance;
    }

    public void setConductance(float conductance) {
        this.conductance = conductance;
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                "ts='" + ts + '\'' +
                ", id='" + id + '\'' +
                ", wind_speed=" + wind_speed +
                ", rainfall=" + rainfall +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", illumination=" + illumination +
                ", photosynthesis=" + photosynthesis +
                ", wind_direction=" + wind_direction +
                ", co2=" + co2 +
                ", ph=" + ph +
                ", soil_temperature_1=" + soil_temperature_1 +
                ", soil_moisture_1=" + soil_moisture_1 +
                ", soil_temperature_2=" + soil_temperature_2 +
                ", soil_moisture_2=" + soil_moisture_2 +
                ", soil_temperature_3=" + soil_temperature_3 +
                ", soil_moisture_3=" + soil_moisture_3 +
                ", conductance=" + conductance +
                '}';
    }
}
