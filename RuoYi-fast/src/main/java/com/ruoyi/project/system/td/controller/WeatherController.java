package com.ruoyi.project.system.td.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.td.domain.WeatherStation;
import com.ruoyi.project.system.td.sql.GetTime;
import com.ruoyi.project.system.td.sql.RestfulTD;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.Mode;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/system/td")
public class WeatherController extends BaseController{

    private String prefix = "system/td";

    @GetMapping()
    public String echas(){
        return prefix + "/echas";
    }

    @GetMapping("/new")
    public String td(){
        return prefix + "/newtddata";
    }

    @PostMapping("/historyData/list")
    @ResponseBody
    public TableDataInfo select(HttpServletRequest request) throws IOException{
//        WeatherStation weatherStation1 = new WeatherStation();
        String beginTime = request.getParameter("params[beginTime]");
        String endTime = request.getParameter("params[endTime]");
        beginTime = beginTime + " 00:00:00";
        endTime = endTime + " 00:00:00";
        System.out.println(beginTime+endTime);
        RestfulTD restfulTD = new RestfulTD();
        String sql = "select * from iot.t_iot_weather_station where ts >= '"+ beginTime + "' and ts <= '" + endTime + "'";
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
//        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select * from iot.t_iot_weather_station  where ts >= \"2019-11-18 20:20:03\"");
        System.out.println(data);
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
                String[] split = splits[17].split("]");
                weatherStation.setConductance(Float.parseFloat(split[0]));
                weatherStations.add(i,weatherStation);
            }
        }
        startPage();
        List<WeatherStation> historyList = weatherStations;
        return getDataTable(historyList);
    }

    @GetMapping("/historyData")
    public String list() {
        return prefix + "/history";
    }

    /**
     * 最新数据
     * @return
     * @throws IOException
     */
    @PostMapping("/betternew")
    @ResponseBody
    public String getData() throws IOException {
        RestfulTD restfulTD = new RestfulTD();
        GetTime getTime = new GetTime();
        String ymd = getTime.getDt();
        String sql = "select * from iot.t_iot_weather_station  where ts >= '"+ymd + "'";
//        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select * from iot.t_iot_weather_station  where ts >= \"2019-11-18 20:20:03\"");
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
        System.out.println(data);
        return data;
    }

    /**
     * 前一天数据
     * @param str
     * @return
     * @throws IOException
     */
    @PostMapping("/ect")
    @ResponseBody
    public String getEData(String str) throws IOException {
        RestfulTD restfulTD = new RestfulTD();
        GetTime getTime = new GetTime();
        String ymd = getTime.getDtN();
        String sql = "select ts, " + str + " from iot.t_iot_weather_station where ts >= '"+ ymd + "'";
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
//        System.out.println(data);
//        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata","select ts, temperature1 from iot.t_iot_sun5015  where ts >= \"2019-11-18 20:20:03\"");
//        System.out.println(data);
        return data;
    }
}
