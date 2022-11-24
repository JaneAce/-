package com.example.demo2.controller;

import com.example.demo2.pojo.Nucleic;
import com.example.demo2.pojo.Result;
import com.example.demo2.service.PageHelpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/student/notice_class")
public class personPageController {
    @Resource
    PageHelpService pageHelpService;

    @RequestMapping("/personPage")
    public Result list(@RequestParam(required=false,defaultValue="1") int page,
                       @RequestParam(required=false,defaultValue="15") int limit,
             HttpSession session){
        Object username = session.getAttribute("username");
        System.out.println("分页获取的用户名称"+username.toString());
        List<Nucleic> nucleics = pageHelpService.personNRow(username.toString(),page,limit);
        System.out.println("查询结果"+nucleics.toString());
       int count = pageHelpService.personTotal(username.toString());
        Result result = new Result(0,"success",count,nucleics);
        System.out.println(result.toString());
        return result;
    }
}
