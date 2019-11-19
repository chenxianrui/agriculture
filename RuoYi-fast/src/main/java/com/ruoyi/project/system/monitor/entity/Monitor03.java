package com.ruoyi.project.system.monitor.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Monitor03 implements Monitor {



    @Value("${monitor3.id}")
    private String id;

    @Value("${monitor3.ip}")
    private String ip;

    @Value("${monitor3.port}")
    private String port;

    @Value("${monitor3.user}")
    private String user;

    @Value("${monitor3.password}")
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
