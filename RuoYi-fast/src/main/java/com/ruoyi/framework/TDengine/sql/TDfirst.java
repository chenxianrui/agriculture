package com.ruoyi.framework.TDengine.sql;

import com.ruoyi.framework.TDengine.Entity.TDengineUntil;
import com.ruoyi.framework.TDengine.Entity.TiotSun5016;
import com.ruoyi.framework.TDengine.connection.TDengineUtil;

import java.util.List;

public class TDfirst {

    public void selecTD() throws Exception{
        TDengineUtil util = new TDengineUtil("jdbc:TAOS://49.235.215.208:0/iot","root","taosdata",true);
        System.out.println("lianjie");
        List<TiotSun5016> list = util.getList("select * from t_iot_sun5016 ",TiotSun5016.class);
        System.out.println("lianjie");
        System.out.println(list.get(1).getTs());
    }
}
