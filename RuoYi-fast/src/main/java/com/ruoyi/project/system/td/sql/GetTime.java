package com.ruoyi.project.system.td.sql;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getDtN(){
        SimpleDateFormat min=new SimpleDateFormat("mm");
        String minstr = "";
        SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String predate = predf.format(new Date(d.getTime() - (long)24 * 60 * 60 * 1000));
        int minint = Integer.parseInt(min.format(System.currentTimeMillis()));
        if (minint >= 0 && minint < 30){
            minstr = "00";
        }else {
            minstr = "30";
        }
        SimpleDateFormat sf=new SimpleDateFormat(predate + " HH:" + minstr + ":ss");
        String strchangetime = sf.format(System.currentTimeMillis());
        return strchangetime;
    }

}
