package com.example.demo2.controller;

import com.example.demo2.pojo.Nucleic;
import com.example.demo2.pojo.PageHelp;
import com.example.demo2.pojo.User;
import com.example.demo2.service.PageHelpService;
import com.example.demo2.service.UserService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    UserService userService;
    @Resource
    PageHelpService pageHelpService;
    //疫情信息
    @RequestMapping("/student/epidemic.html")
    public String GetEpidemic(){
        return "student/epidemic";
    }
    //核酸报告
    @RequestMapping("/student/report.html")
    public String GetReport(){
        return "student/report";
    }
    //个人信息
    @RequestMapping("/student/personalinfo.html")
    public String GetIndexMessage(){
        return "student/personalinfo";
    }
    @GetMapping("/student/GetMyInfo")
    @ResponseBody
    public User GetMyInfo(String username){
        return userService.queryOne(username);
    }

    @RequestMapping("/student/SupplyMyInfo")
    @ResponseBody
    public void ComplementUserInfo(String username, String address, String birtherDay, String sex, String phoneNo, String academyName, String className, Model model){
        System.out.println("输入的信息"+birtherDay);
        try {
            System.out.println("");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(birtherDay);
            userService.UpdateUser(address,date,sex,phoneNo,academyName,className,username);
            model.addAttribute("msg","保存成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //班级通知
    @RequestMapping("/student/notice_class.html")
    public String GetNotice_class(){
        return "student/notice_class";
    }
    //核酸打卡
    @RequestMapping("/student/clock_add.html")
    public String Clock_add(){
        return "student/clock_add";
    }




}
