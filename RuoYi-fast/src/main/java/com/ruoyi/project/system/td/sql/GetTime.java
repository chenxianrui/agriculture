package com.ruoyi.project.system.td.sql;

import java.text.SimpleDateFormat;

public class GetTime {

    public String getDt(){
        SimpleDateFormat min=new SimpleDateFormat("mm");
        String minstr = "";
        int minint = Integer.parseInt(min.format(System.currentTimeMillis()));
        if (minint >= 0 && minint < 30){
            minstr = "00";
        }else {
            minstr = "30";
        }
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:" + minstr + ":ss");
        String strchangetime = sf.format(System.currentTimeMillis());
        return strchangetime;
    }
}
