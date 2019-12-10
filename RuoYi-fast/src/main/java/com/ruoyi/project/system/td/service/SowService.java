package com.ruoyi.project.system.td.service;

import com.ruoyi.project.system.td.domain.Sow;
import com.ruoyi.project.system.td.mapper.SowMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SowService {

    @Autowired
    private SowMapper sowMapper;

    public List<Sow> selectStandardHistory(String start, String end, int curr, int limit){
        List<Sow> sows = sowMapper.selectStandardHistory(start, end, curr, limit);
        return sows;
    }

    public void updateStandardData(int state, float averageTemperature, String dtime){
        sowMapper.updateStandardData(state,averageTemperature,dtime);
    }

    public void updateHumidityData(int state, float averageHumidity, String dtime){
        sowMapper.updateStandardData(state,averageHumidity,dtime);
    }

    public void addStandardData(String dtime, int state, float averageTemperature, float averageHumidity){
        sowMapper.addStandardData(dtime, state, averageTemperature, averageHumidity);
    }

    public List<Sow> selectStandardByTime(String dtime){
        return sowMapper.selectStandardByTime(dtime);
    }

    public int selectStateByTime(String dtime){
        return sowMapper.selectStateByTime(dtime);
    }

    public List<Sow> selectSevenData(String start, String end){
        return sowMapper.selectSevenData(start, end);
    }
}
