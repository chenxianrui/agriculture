package com.ruoyi.project.system.monitor.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Monitor01 extends Monitor {

        @Value("${monitor1.id}")
        private String id;

        @Value("${monitor1.ip}")
        private String ip;

        @Value("${monitor1.port}")
        private String port;

        @Value("${monitor1.user}")
        private String user;

        @Value("${monitor1.password}")
        private String password;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getJson() {

        Map<String, String> fastJsonMap = new HashMap<String, String>();
        fastJsonMap.put("id", getId());
        fastJsonMap.put("ip", getIp());
        fastJsonMap.put("port", getPort());
        fastJsonMap.put("user", getUser());
        fastJsonMap.put("password", getPassword());

        String str = JSONObject.toJSONString(fastJsonMap);
        return str;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
