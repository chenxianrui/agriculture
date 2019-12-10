package com.ruoyi.project.system.td.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.td.domain.WeatherStation;
import com.ruoyi.project.system.td.sql.GetTime;
import com.ruoyi.project.system.td.sql.RestfulTD;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * 气象数据
 */
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

    @GetMapping("/historyData")
    public String list() {
        return prefix + "/historyData";
    }

    /**
     * 历史数据
     * @param curr
     * @param limit
     * @param star
     * @param end
     * @return
     * @throws IOException
     */
    @PostMapping("/historyData/list")
    @ResponseBody
    public Map<String, Object> select(int curr, int limit, String star, String end) throws IOException{
        String pageCount;
        star = star + " 00:00:00";
        end = end + " 23:59:59";
        RestfulTD restfulTD = new RestfulTD();
        curr = (curr - 1) * limit;
        String sql = "select * from iot.t_iot_weather_station where ts >= '"+ star + "' and ts <= '" + end + "'" + " limit " + curr + ", " + limit;
        String countSql = "select count(*) from iot.t_iot_weather_station where ts >= '"+ star + "' and ts <= '" + end + "'";
        String data = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",sql);
        String count = restfulTD.getTdData("49.235.215.208","6020","root","taosdata",countSql);
        JSONObject jsonCount = JSON.parseObject(count);
        JSONArray countList = jsonCount.getJSONArray("data");
        if (countList.size() == 0){
            pageCount = "0";
        }else {
            pageCount = countList.get(0).toString().substring(1,3);
        }
        List<WeatherStation> historyList = restfulTD.weatherStations(data);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", historyList);
        map.put("ct", pageCount);
        return map;
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
