package com.fegseg.dao;

import com.fegseg.bean.AdminBean;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface AdminDao {

    @Insert("insert into t_admin values(null,#{username},#{password})")
    public int addAdmin(@RequestBody AdminBean adminBean);


    @Delete("delete from t_admin where id = #{id}")
    public int deleteAdmin(int id);

    @Update("update t_admin set username=#{username}, password=#{password} where id=#{id}")
    public int updateAdmin(@RequestBody AdminBean adminBean);

    @Select("select * from t_admin where id = #{id}")
    public AdminBean getById(int id);

    @Select("select * from t_admin")
    public List<AdminBean> getAll();

    @Select("select * from t_admin where username = #{username} and password = #{password}")
    public AdminBean checking(@Param("username") String username, @Param("password")String password);

}
