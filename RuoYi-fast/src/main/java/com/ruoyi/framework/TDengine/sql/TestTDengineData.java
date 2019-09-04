package com.ruoyi.framework.TDengine.sql;

import com.ruoyi.framework.TDengine.connection.ConnectionTDengine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTDengineData {

    private ConnectionTDengine connectionTDengine = new ConnectionTDengine();
    public void selectTDengine(){
        connectionTDengine.doMakeJdbcUrl();
        connectionTDengine.doCreateDbAndTable("chen","mt",1,"t");
        connectionTDengine.doExecuteInsert("chen",2,1,"t",10,1519833600000L,0);
        List lists = connectionTDengine.doExecuteQuery("chen","t",1);
        for (int i = 0;i<lists.size();i++){
            System.out.println("有点意思" + lists.get(i));
        }
        System.out.println("成功");
    }
}
