package com.ruoyi.project.system.td.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.td.service.SowService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StandardData {

    /**
     * 湿度平均值
     * @return
     * @throws IOException
     */
    public float HumidityData() throws IOException {
        RestfulTD restfulTD = new RestfulTD();
        GetTime getTime = new GetTime();
        String ymd = getTime.getDt();
        String beforeSixDay = getTime.getSixDay(6);
//        String sql = "select temperature, humidity from iot.t_iot_weather_station  where ts >= '"+ymd + "'";
//        String sql = "select avg(humidity) from iot.t_iot_weather_station where ts >= '"+ beforeSixDay + "' and ts <= '" +ymd+ "'";
//        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select avg(humidity) from iot.t_iot_weather_station where ts >= \"2019-11-24 00:00:03\" and ts <= '" +ymd+ "'");
        JSONObject jsonObject = JSON.parseObject(data);
        JSONArray list = jsonObject.getJSONArray("data");
        float humidityNum = Float.parseFloat(list.get(0).toString().substring(1,5));
        BigDecimal bigDecimal = new BigDecimal(humidityNum);
        float humidity = bigDecimal.setScale(9, BigDecimal.ROUND_HALF_UP).floatValue();
        return humidity;
    }

    /**
     * 温度平均值
     * 每天7:00至19:00执行
     * @return
     * @throws IOException
     */
    public float TemperatureData() throws IOException {
        SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String predate = predf.format(new Date(d.getTime()));
        String nightDay = predate + " 19:00";
        predate = predate + " 07:00:00";
        RestfulTD restfulTD = new RestfulTD();
        GetTime getTime = new GetTime();
        List list = getTime.getNDay(6);
        int i=0;
        String start = "";
        String end = "";
        String sql = "";
        float total = 0;
        float avg = 0;
        while (i<list.size()){
            start = list.get(i).toString();
            i++;
            end = list.get(i).toString();
            i++;
//            sql = "select avg(temperature) from iot.t_iot_weather_station where ts >= '"+ start + "' and ts <= '" +end+ "'";
            String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select avg(temperature) from iot.t_iot_weather_station where ts >= \"2019-11-24 00:00:03\" and ts <= '" +end+ "'");
//            String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
            JSONObject jsonObject = JSON.parseObject(data);
            JSONArray jsonList = jsonObject.getJSONArray("data");
            float temperatureNum = Float.parseFloat(jsonList.get(0).toString().substring(1,5));
            BigDecimal bigDecimal = new BigDecimal(temperatureNum);
            float temperature = bigDecimal.setScale(9, BigDecimal.ROUND_HALF_UP).floatValue();
            total += temperature;
        }
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select avg(temperature) from iot.t_iot_weather_station where ts >= \"2019-11-24 00:00:03\"");
        JSONObject jsonObject = JSON.parseObject(data);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        float sevenTemperature = Float.parseFloat(jsonArray.get(0).toString().substring(1,5));
        BigDecimal bigDecimal = new BigDecimal(sevenTemperature);
        float sTemperature = bigDecimal.setScale(9, BigDecimal.ROUND_HALF_UP).floatValue();
        avg = total/6;
        avg = (sTemperature+avg)/2;
        return avg;
    }

    /**
     * 总的标准
     * @return
     * @throws IOException
     */
    public int ITstate() throws IOException {
        float humidity = HumidityData();
        float temperature = TemperatureData();
        int humidityState = -2;
        int temperatureState = -2;
        int state = -2;
        if (humidity < 0.4){
            humidityState = -1;
        }else if (humidity >= 0.4 && humidity <= 0.7){
            humidityState = 0;
        }else if (humidity > 0.7 && humidity <= 0.8){
            humidityState = 1;
        }
        if (temperature < 8){
            temperatureState = -1;
        }else if (temperature >= 8 && temperature <= 15){
            temperatureState = 0;
        }else if (temperature > 15){
            temperatureState = 1;
        }

        if (humidityState == -1){
            state = -1;
        }else if (humidityState == 0 && temperatureState == -1){
            state = -1;
        }else if (humidityState == 0 && temperatureState > -1){
            state = 0;
        }else if (humidityState == 1 && temperatureState == -1){
            state = -1;
        }else if (humidityState == 1 && temperatureState == 0){
            state = 0;
        }else if (humidityState == 1 && temperatureState == 1){
            state = 1;
        }

        return state;
    }

}
