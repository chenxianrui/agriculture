package com.ruoyi.framework.TDengine.connection;

import com.ruoyi.framework.TDengine.Entity.TDengineUntil;
import io.swagger.models.auth.In;

import java.lang.reflect.Method;
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

    /**
     * 若无对应的数据库和表则创建
     * @param databaseName 数据库名称
     * @param metricsName 超级表名称
     * @param tablesCount 表的数量
     * @param tablePrefix 表前缀
     */
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

    /**
     * 插入数据
     * @param databaseName 数据库名称
     * @param loopCount
     * @param tablesCount 表的数目
     * @param tablePrefix 表的前缀
     * @param batchSize
     * @param beginTimestamp 创建时间
     * @param rowsInserted
     */
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

    /**
     * 查询数据
     * @param clazz 实体类
     * @param databaseName 数据库名称
     * @param tablePrefix 表的前缀
     * @param tablesCount 表的数目
     * @return
     */
    public <T> List<T> doExecuteQuery(Class<T> clazz, String databaseName, String tablePrefix, Integer tablesCount) {
        List<T> list=new ArrayList<>();
        Method[] setterMethods = getSetterMethods(clazz);
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
                    list.add(resultSetToObject(resSet, setterMethods, clazz));
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
//            list.add("失败");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }
        System.out.println("查询成功!");
        return list;
    }
    /**     * 获取指定类型方法的所有的setter方法     *     * @param clazz     * @return     */
    public static Method[] getSetterMethods(Class clazz) {
        Method[] methods = clazz.getMethods();
        Method[] setterMethods = new Method[methods.length / 2];
        int i = 0;
        for (Method m : methods) {
            if (m.getName().startsWith("set")) {
                setterMethods[i] = m;
                i++;
            }
        }
        return setterMethods;
    }
    /**
     * 将resultSet注入到指定的类型实例中，且返回
     * 对象遵从以下说明<br/>
     * 1.对象字段为String类型，数据库类型(通过jdbc读取到的)无论什么类型，都将调用Object.toString方法注入值<br/>
     * 2.对象字段为数据库类型(通过jdbc读取到的)一致的情况下，将会直接注入<br/>
     * 3.对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试使用{@link Class#cast(Object)}方法转型，失败此值会是类型默认值(故实体推荐使用封装类型)<br/>
     * 4.对象字段为{@link Date}时，数据库类型为Date才可以注入，如果为long(例如TDengine)将会被当作毫秒的时间戳注入<br/>
     * <p>
     * 注意，此方法只会注入一个结果,不会循环{@link ResultSet#next()}方法，请从外部调用。<br/>
     * 传入setterMethods的目的是为了方便外部循环使用此方法，这样方法内部不会重复调用，提高效率<br/>
     *
     * @param resultSet     查询结果，一定要是{@link ResultSet#next()}操作过的，不然没有数据
     * @param setterMethods clazz对应的所有setter方法，可以使用{@link this#getSetterMethods(Class)}获取
     * @param clazz         注入对象类型
     * @param <T>           注入对象类型
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> T resultSetToObject(ResultSet resultSet, Method[] setterMethods, Class<T> clazz) throws IllegalAccessException, InstantiationException
    {
        T result;
        try
        {
            result = clazz.newInstance();
        }
        catch (InstantiationException e)
        {
            System.out.println("请检查类" + clazz.getCanonicalName() + "是否有无参构造方法");
            throw e;
        }
        for (Method method : setterMethods)
        {
            try
            {
                String fieldName = getFieldNameBySetter(method);
                //因为标准的setter方法只会有一个参数，所以取一个就行了
                Class getParamClass = method.getParameterTypes()[0];
                //获得查询的结果
                Object resultObject;
                resultObject = resultSet.getObject(fieldName);
                //如果实体类的类型是String类型，那么无论x数据库类型是什么，都调用其toString方法获取值
                if (getParamClass.equals(String.class))
                {
                    method.invoke(result, resultObject.toString());
                }
                else if (getParamClass.equals(Date.class) && resultObject.getClass().equals(Long.class))
                {
                    method.invoke(result, new Date((Long) resultObject));
                }
                else
                {
                    try
                    {
                        method.invoke(result, resultObject);
                    }
                    catch (IllegalArgumentException e)
                    {
                        //对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试强制转型
                        method.invoke(result, getParamClass.cast(resultObject));
                    }
                }
            }
            catch (Exception ignored)
            {
                //所有的转型都失败了，则使用默认值
            }
        }
        return result;
    }
    /**
     * 通过setter method,获取到其对应的属性名
     *
     * @param method
     * @return
     */
    public static String getFieldNameBySetter(Method method)
    {
        return toLowerCaseFirstOne(method.getName().substring(3));
    }

    /**
     * 首字母转小写
     */
    public static String toLowerCaseFirstOne(String s)
    {
        if (Character.isLowerCase(s.charAt(0)))
        {
            return s;
        }
        else
        {
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }

}
