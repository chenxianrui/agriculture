package com.ruoyi.project.system.td.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.td.domain.Sow;
import com.ruoyi.project.system.td.domain.WeatherStation;
import com.ruoyi.project.system.td.service.SowService;
import com.ruoyi.project.system.td.sql.GetTime;
import com.ruoyi.project.system.td.sql.RestfulTD;
import com.ruoyi.project.system.td.sql.StandardData;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

/**
 * 判断是否适宜播种标准
 */
@Controller
@RequestMapping("/system/standard")
public class StandardController {

    private String prefix = "system/td";

    @Autowired
    private SowService sowService;

    @GetMapping()
    public String standard(){
        return prefix + "/standard";
    }

//    @GetMapping("/calendarHeatmap")
//    public String calendarHeatmap(){
//        return prefix + "/CalendarHeatmap";
//    }

    @GetMapping("/SowHistoryData")
    public String sowHistoryData(){
        return prefix + "/sowHistoryData";
    }

    @PostMapping("/humidityColor")
    @ResponseBody
    public Map<String, Object> standardColor(){
        Map<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, - 6);
        Date day = c.getTime();
        String start = format.format(day);
        SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String end = predf.format(new Date(d.getTime()));
        List<Sow> sows = sowService.selectSevenData(start, end);
        map.put("data", sows);
        return map;
    }

//    @PostMapping("/historyData")
//    @ResponseBody
//    public List historyData(String star, String end){
//        List<Sow> list = sowService.selectStandardHistory(star, end);
//        System.out.println(list);
//        return list;
//    }

    @PostMapping("/SowHistoryData/historyList")
    @ResponseBody
    public Map<String, Object> selectHistoryData(int curr, int limit, String star, String end){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sow> list = sowService.selectStandardHistory(star, end, curr, limit);
        String pageCount = String.valueOf(list.size());
        map.put("data", list);
        map.put("ct", pageCount);
        return map;
    }
}
