package com.ruoyi.framework.TDengine.Entity;

public class Test_01 {

    private String my_ts;
    private String my_name;
    private String my_age;

    public String getMy_ts() {
        return my_ts;
    }

    public void setMy_ts(String my_ts) {
        this.my_ts = my_ts;
    }

    public String getMy_name() {
        return my_name;
    }

    public void setMy_name(String my_name) {
        this.my_name = my_name;
    }

    public String getMy_age() {
        return my_age;
    }

    public void setMy_age(String my_age) {
        this.my_age = my_age;
    }

    @Override
    public String toString() {
        return "Test_01{" +
                "my_ts='" + my_ts + '\'' +
                ", my_name='" + my_name + '\'' +
                ", my_age='" + my_age + '\'' +
                '}';
    }
}
