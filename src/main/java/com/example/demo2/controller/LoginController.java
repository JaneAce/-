package com.example.demo2.controller;

import com.example.demo2.pojo.User;
import com.example.demo2.service.UserService;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaType;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
public class LoginController {
    //将Service注入Web层
    @Resource
    UserService userService;
    @Resource
    JavaMailSenderImpl mailSender;
    private String codeNum = "";

    //    @Autowired
    @RequestMapping("/GetEmail")
    public String GetEmailMessage(String email) throws MessagingException {
        int count = 1;//默认发送一次
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        while (count-- != 0) {
            int[] code = new int[3];
            Random random = new Random();
            //自动生成验证码
            for (int i = 0; i < 3; i++) {
                int num = random.nextInt(10) + 48;
                int uppercase = random.nextInt(26) + 65;
                int lowercase = random.nextInt(26) + 97;
                code[0] = num;
                code[1] = uppercase;
                code[2] = lowercase;
                codeNum += (char) code[random.nextInt(3)];
            }
            System.out.println(codeNum);
            //标题
            helper.setSubject("您的验证码为：" + codeNum);
            //内容
            helper.setText("您好！感谢支持林童,您的验证码为：" + "<h2>" + codeNum + "</h2>" + "千万不能告诉别人哦！", true);
            //邮件接收者
            helper.setTo(email);
            //邮件发送者
            helper.setFrom("1532959075@qq.com");
            mailSender.send(mimeMessage);
            System.out.println("邮件发送成功！" + (count + 1));

        }
        return "signup";

    }

//    @GetMapping("/remove/captcha")
//    public void removeCaptcha(HttpServletRequest request){
//        HappyCaptcha.remove(request);
//    }

    @GetMapping("/Captcha")
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("======生成一次验证码======");
        HappyCaptcha.require(request, response).type(CaptchaType.ARITHMETIC).build().finish();
    }



    //实现登录
    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(HttpServletRequest request, String username, String password, String VerifyCode, Model model, HttpSession httpSession) {
        boolean flag = HappyCaptcha.verification(request, VerifyCode, true);
        System.out.println(flag);
        User user = userService.LoginIn(username, password);
        System.out.println(user);
        if (user != null) {
            if (!flag) {
                model.addAttribute("verify_err", "验证码错误");
                return "login";
            }
            httpSession.setAttribute("username", username);
            model.addAttribute("msg", user);
            return "student/indexstu";
        } else {
            model.addAttribute("login_err", "账号或者密码错误");
            return "login";
        }
    }

    @RequestMapping("/signup")
    public String disp() {
        return "signup";
    }
    //实现注册功能

    //    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @PostMapping(value = "/register")
    public String signUp(String username, String password, String email,int option1, String code, Model model) throws MessagingException {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || code.isEmpty()) {
            System.out.println("缺少必填项");
            model.addAttribute("info_err", "缺少必填项");
            return "signup";
        }

        if (!this.codeNum.toLowerCase().equals(code)) {
            model.addAttribute("code_err", "验证码错误");
            return "signup";
        }
        try {
            userService.Insert(username, password, email,option1);
            model.addAttribute("success", "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

}
