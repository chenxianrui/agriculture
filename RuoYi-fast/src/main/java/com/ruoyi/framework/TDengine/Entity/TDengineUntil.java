package com.ruoyi.framework.TDengine.Entity;

public class TDengineUntil {
    private String ts;
    private String v1;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    @Override
    public String toString() {
        return "TDengineUntil{" +
                "ts='" + ts + '\'' +
                ", v1='" + v1 + '\'' +
                '}';
    }
}
