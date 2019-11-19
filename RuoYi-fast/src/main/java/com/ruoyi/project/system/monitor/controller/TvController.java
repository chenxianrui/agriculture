package com.ruoyi.project.system.monitor.controller;


import com.ruoyi.project.system.monitor.entity.Monitor;
import com.ruoyi.project.system.monitor.entity.Monitor01;
import com.ruoyi.project.system.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/system/monitor")
public class TvController {

    private String prefix = "system/monitor";

    @RequiresPermissions("system:monitor:TV")
    @RequestMapping(value="/Tv",method = RequestMethod.POST)
    @ResponseBody
    public String  monitor(@RequestBody HashMap<String, String> map){
        System.out.println("test01");
        System.out.printf(map.get("id"));
        return "test";
    }

    @GetMapping("/iframe")
    public String iframe(){
        return prefix + "/winmonitor/demo/cn/iframe";
    }

    @GetMapping("/fouriframe")
    public String fouriFrame(){
        return prefix + "/winmonitor/demo/cn/demo";
    }
}
