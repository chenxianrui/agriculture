package com.ruoyi.project.system.screen.service;


import com.ruoyi.project.system.equipment.mysqlDomain.Equipment;
import com.ruoyi.project.system.screen.mapper.ScreenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    @Autowired
    private ScreenMapper screenMapper;


    public List<Equipment> selectEquipmentScreenList(){
        return screenMapper.selectEquipmentScreenList();
    }
}
