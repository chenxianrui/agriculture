package com.ruoyi.project.system.td.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.td.domain.WeatherStation;
import okhttp3.*;
import okio.BufferedSink;
//import org.jetbrains.annotations.Nullable;

import javax.xml.transform.Result;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : 夕
 * @date : 2019/11/17
 */
public class RestfulTD {

    //Base64 编码，用户认证编码
    final static Base64.Encoder encoder = Base64.getEncoder();

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(30, TimeUnit.SECONDS).build();

    public String getTdData(String host,String port,String user,String password,String sql) throws IOException {

        //构建RequestBody
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"),sql);

        //构建Request
        Request request = new Request.Builder()
                .url("http://" + host + ":" + port + "/rest/sql")
                .post(requestBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic " + encoder.encodeToString((user + ":" + password).getBytes()))
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", host + ":" + port)
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }


//    public static void main(String[] args) throws IOException {
//        GetTime getTime = new GetTime();
//        String tdtime = getTime.getDt();
//        RestfulTD restfulTD = new RestfulTD();
//        System.out.println(restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select * from iot.t_iot_weather_station  where ts >= \"2019-11-18 20:17:03\""));
////        System.out.println(getTdData("49.235.215.208","6020","root","taosdata","select * from iot.t_iot_weather_station  where ts >= '"+tdtime + "'"));
//    }

    public List<WeatherStation> weatherStations(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        JSONArray list = jsonObject.getJSONArray("data");
        List<WeatherStation> weatherStations = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            String str = list.get(i).toString();
            String[] splits = str.split(",");
            if (splits != null && splits.length != 0){
                WeatherStation weatherStation = new WeatherStation();
                String[] st = splits[0].split("\"");
                String[] st2 = splits[1].split("\"");
                String[] split = splits[17].split("]");
                weatherStation.setTs(st[1]);
                weatherStation.setId(st2[1]);
                weatherStation.setWind_speed(Float.parseFloat(splits[2]));
                weatherStation.setRainfall(Float.parseFloat(splits[3]));
                weatherStation.setTemperature(Float.parseFloat(splits[4]));
                weatherStation.setHumidity(Float.parseFloat(splits[5]));
                weatherStation.setIllumination(Float.parseFloat(splits[6]));
                weatherStation.setPhotosynthesis(Float.parseFloat(splits[7]));
                weatherStation.setWind_direction(Float.parseFloat(splits[8]));
                weatherStation.setCo2(Float.parseFloat(splits[9]));
                weatherStation.setPh(Float.parseFloat(splits[10]));
                weatherStation.setSoil_temperature_1(Float.parseFloat(splits[11]));
                weatherStation.setSoil_moisture_1(Float.parseFloat(splits[12]));
                weatherStation.setSoil_temperature_2(Float.parseFloat(splits[13]));
                weatherStation.setSoil_moisture_2(Float.parseFloat(splits[14]));
                weatherStation.setSoil_temperature_3(Float.parseFloat(splits[15]));
                weatherStation.setSoil_moisture_3(Float.parseFloat(splits[16]));
                weatherStation.setConductance(Float.parseFloat(split[0]));
                weatherStations.add(i,weatherStation);
            }
        }
        return weatherStations;
    }

}
