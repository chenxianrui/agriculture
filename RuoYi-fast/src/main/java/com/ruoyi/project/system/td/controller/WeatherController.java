package com.ruoyi.project.system.td.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
