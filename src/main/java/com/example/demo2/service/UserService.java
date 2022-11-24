package com.example.demo2.service;

import com.example.demo2.mapper.UserMapper;
import com.example.demo2.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public User LoginIn(String username, String password) {
        return userMapper.getInfo(username,password);
    }
    public void Insert(String username,String password,String email,int roleId){
        userMapper.saveInfo(username, password,email,roleId);
    }
   public User queryOne(String username){
       User user = userMapper.queryOne(username);
       return user;
   }
   public void UpdateUser(String address, String birtherDay, String sex,String phoneNo,String academyName,String className,String userName){
        userMapper.UpDateUser(address,birtherDay,sex,phoneNo,academyName,className,userName);
   }
}


