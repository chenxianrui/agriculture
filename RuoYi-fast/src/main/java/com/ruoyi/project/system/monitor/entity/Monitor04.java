package com.ruoyi.project.system.monitor.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Monitor04 implements Monitor{


    @Value("${monitor4.id}")
    private String id;

    @Value("${monitor4.ip}")
    private String ip;

    @Value("${monitor4.port}")
    private String port;

    @Value("${monitor4.user}")
    private String user;

    @Value("${monitor4.password}")
    private String password;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getJson() {
        return null;
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
