package com.ruoyi.framework.TDengine.sql;

import com.ruoyi.framework.TDengine.Entity.TDengineUntil;
import com.ruoyi.framework.TDengine.connection.TDengineUtil;

import java.util.List;

public class TDfirst {

    public void selecTD() throws Exception{
        TDengineUtil util = new TDengineUtil("jdbc:TAOS://10.10.44.124:0/chen","root","taosdata",true);
        List<TDengineUntil> list = util.getList("select * from t0",TDengineUntil.class);
        System.out.println(list.get(1).getTs());
    }
}
