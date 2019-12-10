package com.ruoyi.project.system.td.mapper;

import com.ruoyi.project.system.td.domain.Sow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SowMapper {

    /**
     * 历史数据
     * @param time
     * @return
     */
    @Select("select * from sys_sow where dtime >= #{start} and dtime <= #{end} limit #{curr}, #{limit}")
    public List<Sow> selectStandardHistory(@Param("start") String start, @Param("end") String end, @Param("curr") int curr, @Param("limit") int limit);

    /**
     * 更新温度平均值及标准
     */
    @Update("update sys_sow set state=#{state}, average_temperature=#{averageTemperature} where dtime=#{dtime}")
    public void updateStandardData(@Param("state") int state, @Param("averageTemperature") float averageTemperature, @Param("dtime") String dtime);

    /**
     * 更新湿度平均值及标准
     */
    @Update("update sys_sow set state=#{state}, average_humidity=#{averageHumidity} where dtime=#{dtime}")
    public void updateHumidityData(@Param("state") int state, @Param("averageHumidity") float averageHumidity, @Param("dtime") String dtime);

    /**
     * 增加数据
     */
    @Insert("insert into sys_sow(\n" +
            "        dtime,state,average_temperature,average_humidity\n" +
            "        )values(\n" +
            "        #{dtime},#{state},#{averageTemperature},#{averageHumidity}\n" +
            "        )")
    public void addStandardData(@Param("dtime") String dtime, @Param("state") int state, @Param("averageTemperature") float averageTemperature, @Param("averageHumidity") float averageHumidity);

    /**
     * 根据时间查找数据
     * @param dtime
     * @return
     */
    @Select("select * from sys_sow where dtime = #{dtime}")
    public List<Sow> selectStandardByTime(@Param("dtime") String dtime);

    /**
     * 查找标准
     */
    @Select("select state from sys_sow where dtime = #{dtime}")
    public int selectStateByTime(@Param("dtime") String dtime);

    @Select("select * from sys_sow where dtime >= #{start} and dtime <= #{end} order by dtime asc")
    public List<Sow> selectSevenData(@Param("start") String start, @Param("end") String end);

}
