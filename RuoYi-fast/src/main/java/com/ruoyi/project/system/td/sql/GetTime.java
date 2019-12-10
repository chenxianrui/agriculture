package com.ruoyi.project.system.td.sql;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    /**
     * 过去n天
     * @return
     */
    public String getSixDay(int time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        //过去六天
        c.setTime(new Date());
        c.add(Calendar.DATE, - time);
        Date d = c.getTime();
        String day = format.format(d);
        day = day + " 00:00:00";
        return day;
    }

    public List getNDay(int time){
        List list = new ArrayList();
        for (int i=1; i<time+1; i++){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();

            //过去六天
            c.setTime(new Date());
            c.add(Calendar.DATE, - i);
            Date d = c.getTime();
            String day = format.format(d);
            String dayNight = format.format(d);
            day = day + " 07:00:00";
            dayNight = dayNight + " 19:00:00";
            list.add(day);
            list.add(dayNight);
        }
        return list;
    }

}
