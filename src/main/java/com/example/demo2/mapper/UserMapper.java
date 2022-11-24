package com.example.demo2.mapper;

import com.example.demo2.pojo.Nucleic;
import com.example.demo2.pojo.PageHelp;
import com.example.demo2.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM tab_user WHERE username = #{username} AND password = #{password}")
    User getInfo(@org.apache.ibatis.annotations.Param("username") String username, @org.apache.ibatis.annotations.Param("password") String password);

    @Insert("insert into tab_user(username,password,emailNo,roleId) values(#{username},#{password},#{emailNo},#{roleId})")
    void saveInfo(@org.apache.ibatis.annotations.Param("username") String username, @Param("password") String password,@Param("emailNo") String email,@Param("roleId") int roleId);

    @Select("SELECT * FROM tab_user where username=#{username}")
    User queryOne(@Param("username") String username);
    @Update("update tab_user set address=#{address},birtherDay=#{birtherDay},sex=#{sex},phoneNo=#{phoneNo},academyName=#{academyName},className=#{className} where userName=#{userName}")
    void UpDateUser(@Param("address") String address, @Param("birtherDay") String birtherDay , @Param("sex") String sex, @Param("phoneNo") String phoneNo, @Param("academyName") String academyName, @Param("className") String className, @Param("userName") String userName);

    //分页查询个人核酸记录
    @Select("SELECT tab_user.userName,tab_nucleic.nDate,tab_nucleic.Nresult,tab_nucleic.nImage FROM tab_nucleic JOIN tab_user ON tab_user.userId=tab_nucleic.userId WHERE tab_user.userName=#{username} order by tab_nucleic.nDate LIMIT #{startIndex},#{pageSize}")
    List<Nucleic> PersonNRow(@Param("username") String username, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    //总记录条数
    @Select("SELECT COUNT(*) FROM  tab_nucleic JOIN tab_user ON tab_user.userId=tab_nucleic.userId WHERE tab_user.userName=#{username}")
    int personNTotal(@Param("username") String username);
}


