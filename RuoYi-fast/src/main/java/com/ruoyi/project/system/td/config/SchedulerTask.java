package com.ruoyi.project.system.td.config;

import com.ruoyi.project.system.td.domain.Sow;
import com.ruoyi.project.system.td.service.SowService;
import com.ruoyi.project.system.td.sql.StandardData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Configuration
@Component
@EnableScheduling
@EnableAsync
public class SchedulerTask {

    @Autowired
    private SowService sowService;

    /**
     * 每天新增数据至MySQL
     * 每天00:00新增
     * @throws IOException
     */
    @Async
    @Scheduled(cron = "0 0 0 */1 * ? ")
    public void insertMysql() throws IOException {
        SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String nowDay = predf.format(new Date(d.getTime()));
        String beforeDay = predf.format(new Date(d.getTime() - (long)24 * 60 * 60 * 1000));
        StandardData standardData = new StandardData();
        float humidity = standardData.HumidityData();
        List<Sow> sows = sowService.selectStandardByTime(beforeDay);
        float temperature = sows.get(0).getAverageTemperature();
        int state = sows.get(0).getState();
        sowService.addStandardData(nowDay,state,temperature,humidity);
    }

    /**
     * 更新数据至MySQL
     * 每天7:00-19:00半小时更新一次温度平均值及标准
     * @throws IOException
     */
    @Async
    @Scheduled(cron = "0 0/30 7-19 * * ? ")
    public void updateTemperatureMySQL() throws IOException {
//        System.out.println("-------------------------------------------------------------------");
//        System.out.println("温度任务触发" + new Date());
        StandardData standardData = new StandardData();
        float temperature = standardData.TemperatureData();
        int state = standardData.ITstate();
        SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String day = predf.format(new Date(d.getTime()));
        sowService.updateStandardData(state,temperature,day);
    }

    /**
     * 更新数据至MySQL
     * 每半小时更新一次湿度平均值及标准
     * @throws IOException
     */
    @Async
    @Scheduled(cron = "0 0/30 * * * ? ")
    public void updateHumidityMySQL() throws IOException {
//        System.out.println("-----------------------------------------------------------------------------");
//        System.out.println("湿度任务触发" + new Date());
        StandardData standardData = new StandardData();
        float humidity = standardData.HumidityData();
        int state = standardData.ITstate();
        SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String day = predf.format(new Date(d.getTime()));
        sowService.updateHumidityData(state,humidity,day);
    }

}

