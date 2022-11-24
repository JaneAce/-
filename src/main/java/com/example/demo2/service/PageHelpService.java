package com.example.demo2.service;

import com.example.demo2.mapper.UserMapper;
import com.example.demo2.pojo.Nucleic;
import com.example.demo2.pojo.PageHelp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PageHelpService {
    @Resource
   private UserMapper userMapper;
    public List<Nucleic> personNRow(String username, Integer pageCurrent,Integer pageSize){
        if(pageCurrent == null){

            System.out.println("页码值不合法");
        }
        int rowCount = userMapper.personNTotal(username);
        if (rowCount == 0){
            System.out.println("没有符合条件的记录");
        }
        int startIndex = (pageCurrent -1) *pageSize; //查询的起始条件
        List<Nucleic> records = userMapper.PersonNRow(username,startIndex,pageSize);
        PageHelp pageHelp = new PageHelp(rowCount,records,pageSize,pageCurrent);
        return records;
    }
    public int personTotal(String username){
        int rowCount = userMapper.personNTotal(username);
        return rowCount;
    }
}
