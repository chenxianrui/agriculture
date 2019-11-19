package com.ruoyi.project.system.td.controller;


import com.ruoyi.project.system.td.sql.GetTime;
import com.ruoyi.project.system.td.sql.RestfulTD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/system/td")
public class WeatherController {

    private String prefix = "system/td";

    @GetMapping()
    public String echas(){
        return prefix + "/echas";
    }

    @GetMapping("/new")
    public String td(){
        return prefix + "/newtddata";
    }

    @PostMapping("/betternew")
    @ResponseBody
    public String getData() throws IOException {
        RestfulTD restfulTD = new RestfulTD();
        GetTime getTime = new GetTime();
        String ymd = getTime.getDt();
        String sql = "select * from iot.t_iot_weather_station  where ts >= '"+ymd + "'";
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select ts, temperature1 from iot.t_iot_sun5015  where ts >= \"2019-11-18 20:20:03\"");
        return data;
    }

    @PostMapping("/ect")
    @ResponseBody
    public String getEData(String str) throws IOException {
        RestfulTD restfulTD = new RestfulTD();
        GetTime getTime = new GetTime();
        String ymd = getTime.getDtN();
        System.out.println(ymd);
        System.out.println(str);
        String sql = "select ts, " + str + " from iot.t_iot_weather_station where ts >= '"+ ymd + "'";
        System.out.println(sql);
//        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
//        System.out.println(data);
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select ts, temperature1 from iot.t_iot_sun5015  where ts >= \"2019-11-18 20:20:03\"");
//        System.out.println(data);
        return data;
    }
}
