package com.ruoyi.framework.TDengine.connection;

import com.ruoyi.framework.TDengine.Entity.TDengineUntil;
import io.swagger.models.auth.In;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionTDengine {
    private static final String JDBC_PROTOCAL = "jdbc:TAOS://";
    private static final String TSDB_DRIVER = "com.taosdata.jdbc.TSDBDriver";

    private String host = "10.10.44.124";
    private String user = "root";
    private String password = "taosdata";
    private int port = 0;
    private String jdbcUrl = "";

    static {
        try {
            Class.forName(TSDB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doMakeJdbcUrl() {
        // jdbc:TSDB://127.0.0.1:0/dbname?user=root&password=taosdata
        System.out.println("\nJDBC URL to use:");
        jdbcUrl = String.format("%s%s:%d/%s?user=%s&password=%s", JDBC_PROTOCAL, this.host, this.port, "",
                this.user, this.password);
        System.out.println(jdbcUrl);
    }

    public void doCreateDbAndTable(String databaseName,String metricsName, Integer tablesCount, String tablePrefix) {
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("开始新建数据库和表...");
        String sql = "";
        try (Connection conn = DriverManager.getConnection(jdbcUrl);
             Statement stmt = conn.createStatement()){

            sql = "create database if not exists " + databaseName;
            stmt.executeUpdate(sql);
            System.out.printf("成功执行: %s\n", sql);

            sql = "use " + databaseName;
            stmt.executeUpdate(sql);
            System.out.printf("成功执行: %s\n", sql);

            sql = "create table if not exists " + metricsName + " (ts timestamp, v1 int) tags(t1 int)";
            stmt.executeUpdate(sql);
            System.out.printf("成功执行: %s\n", sql);

            for (int i = 0; i < tablesCount; i++) {
                sql = String.format("create table if not exists %s%d using %s tags(%d)", tablePrefix, i,
                        metricsName, i);
                stmt.executeUpdate(sql);
                System.out.printf("成功执行: %s\n", sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("执行失败 SQL: %s\n", sql);
            System.exit(4);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }
        System.out.println("成功创造数据库和表！");
    }

    public void doExecuteInsert(String databaseName, Integer loopCount, Integer tablesCount, String tablePrefix, Integer batchSize, long beginTimestamp, long rowsInserted) {
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("开始插入数据...");
        int start = (int) System.currentTimeMillis();
        StringBuilder sql = new StringBuilder("");
        try (Connection conn = DriverManager.getConnection(jdbcUrl);
             Statement stmt = conn.createStatement()){
            stmt.executeUpdate("use " + databaseName);
            for (int loop = 0; loop < loopCount; loop++) {
                for (int table = 0; table < tablesCount; ++table) {
                    sql = new StringBuilder("insert into ");
                    sql.append(tablePrefix).append(table).append(" values");
                    for (int batch = 0; batch < batchSize; ++batch) {
                        int rows = loop * batchSize + batch;
                        sql.append("(").append(beginTimestamp + rows).append(",").append(rows).append(")");
                    }
                    int affectRows = stmt.executeUpdate(sql.toString());
                    rowsInserted += affectRows;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("执行失败 SQL: %s\n", sql.toString());
            System.exit(4);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }
        int end = (int) System.currentTimeMillis();
        System.out.println("插入数据成功!");
        System.out.printf("总共插入 %d 行, %d 行插入失败, 花费%d秒.\n", rowsInserted,
                loopCount * batchSize - rowsInserted, (end - start) / 1000);
    }

    public List doExecuteQuery(String databaseName, String tablePrefix, Integer tablesCount) {
        List list=new ArrayList();
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("开始检索数据...");
        ResultSet resSet = null;
        StringBuilder sql = new StringBuilder("");
        StringBuilder resRow = new StringBuilder("");
        try (Connection conn = DriverManager.getConnection(jdbcUrl);
             Statement stmt = conn.createStatement()){
            stmt.executeUpdate("use " + databaseName);
            for (int i = 0; i < tablesCount; ++i) {
                sql = new StringBuilder("select * from ").append(tablePrefix).append(i);

                resSet = stmt.executeQuery(sql.toString());
                if (resSet == null) {
                    System.out.println(sql + " 失败");
                    System.exit(4);
                }

                ResultSetMetaData metaData = resSet.getMetaData();
                System.out.println("检索元数据： " + tablePrefix + i);
                for (int column = 1; column <= metaData.getColumnCount(); ++column) {
                    System.out.printf("Column%d: name = %s, type = %d, type name = %s, display size = %d\n", column, metaData.getColumnName(column), metaData.getColumnType(column),
                            metaData.getColumnTypeName(column), metaData.getColumnDisplaySize(column));
                }
                int rows = 0;
                System.out.println("检索下列资料：" + tablePrefix + i);
                while (resSet.next()) {
                    resRow = new StringBuilder();
                    for (int col = 1; col <= metaData.getColumnCount(); col++) {
                        resRow.append(metaData.getColumnName(col)).append("=").append(resSet.getObject(col))
                                .append(" ");
                    }
                    list.add(resRow.toString());
                    System.out.println(resRow.toString());
                    rows++;
                }

                try {
                    if (resSet != null)
                        resSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.printf("成功执行查询: %s;\nTotal rows returned: %d\n", sql.toString(), rows);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("执行失败: %s\n", sql.toString());
            System.exit(4);
            list.add("失败");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }
        System.out.println("查询成功!");
        return list;
    }
}
