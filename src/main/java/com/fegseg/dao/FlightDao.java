package com.fegseg.dao;

import com.fegseg.bean.FlightBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface FlightDao {


    @Insert("insert into t_flight_info values(null, #{flight_number},#{airline_company},#{from_city},#{to_city},#{stopover},#{plan_takeoff_time},#{plan_arrival_time},#{actual_takeoff_time},#{actual_arrival_time},#{terminal},#{gate},#{check_in_counter}, null)")
    public int insert(FlightBean flightBean);

    @Update("update t_flight_info set flight_number = #{flight_number},airline_company = #{airline_company}," +
            "from_city = #{from_city},to_city = #{to_city},stopover = #{stopover},plan_takeoff_time = #{plan_takeoff_time},plan_arrival_time = #{plan_arrival_time}," +
            "actual_takeoff_time = #{actual_takeoff_time},actual_arrival_time = #{actual_arrival_time},terminal = #{terminal},gate = #{gate}," +
            "check_in_counter = #{check_in_counter},flight_statu = #{flight_statu} where flight_no = #{flight_no}")
    public int update(FlightBean flightBean);

    @Delete("delete from t_flight_info where flight_no = #{id}")
    public int delete(Integer id);

    @Select("select * from t_flight_info where flight_no = #{id}")
    public FlightBean getById(Integer id);

    @Select("select * from t_flight_info order by flight_no limit #{from}, #{to}")
    public List<FlightBean> getSome(@Param("from") Integer from, @Param("to")Integer to);

    @Select("select * from t_flight_info where (flight_number = #{keyWord} or from_city = #{keyWord} " +
            "or to_city = #{keyWord} or stopover = #{keyWord}) and (plan_takeoff_time between #{fromDateTime} " +
            "and #{toDateTime}) or actual_takeoff_time between #{fromDateTime} and #{toDateTime}")
    public List<FlightBean> searchKeyWord(@Param("keyWord")String keyWord, @Param("fromDateTime")String fromDateTime, @Param("toDateTime")String toDateTime);

    @Select("select * from t_flight_info where plan_takeoff_time between #{from} and #{to} or actual_takeoff_time between #{from} and #{to}")
    public List<FlightBean> searchTime(@Param("from")String from, @Param("to")String to);
    @Select("select * from t_flight_info")
    public List<FlightBean> getAll();

    @Select("select * from t_flight_info order by flight_no desc limit 1")
    public FlightBean getLastOne();
}
