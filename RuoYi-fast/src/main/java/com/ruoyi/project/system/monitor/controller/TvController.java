package com.ruoyi.project.system.monitor.controller;


import com.ruoyi.project.system.monitor.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/system/monitor")
public class TvController {

    private String prefix = "system/monitor";

    @GetMapping()
    public String fourTv(){
        return prefix + "/winmonitor/demo/cn/demo-iframe";
    }

    @GetMapping("/iframe")
    public String iframe(){
        return prefix + "/winmonitor/demo/cn/iframe";
    }

    @GetMapping("/fouriframe")
    public String fouriFrame(){
        return prefix + "/sample";
    }

    @Autowired
    Monitor01 monitor01;
    @Autowired
    Monitor02 monitor02;
    @Autowired
    Monitor03 monitor03;
    @Autowired
    Monitor04 monitor04;

    @PostMapping("/tv")
    @ResponseBody
    public String getData(String id){
        List<Monitor> monitors = new ArrayList();
        monitors.add(monitor01);
        monitors.add(monitor02);
        monitors.add(monitor03);
        monitors.add(monitor04);
        Iterator<Monitor> iterator = monitors.iterator();
        while (iterator.hasNext()){
            Monitor temp = iterator.next();
            if(temp.getId().equals(id)){
                System.out.println(temp.getJson());
                return temp.getJson();
            }
        }
        return "error";
    }





}
