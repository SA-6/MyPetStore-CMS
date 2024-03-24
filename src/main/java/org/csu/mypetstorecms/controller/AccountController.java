package org.csu.mypetstorecms.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.csu.mypetstorecms.entity.Admin;
import org.csu.mypetstorecms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/captcha")
    public void defaultCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/gif");

        // 三个参数分别为宽、高、位数
        SpecCaptcha captcha = new SpecCaptcha(150, 30, 4);

        // 设置字体
        captcha.setCharType(Captcha.FONT_9);

        // 验证码存入session
        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());

        // 输出图片流
        captcha.out(httpServletResponse.getOutputStream());
    }

    @RequestMapping("/loginForm")
    public String viewLoginForm(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return "account/loginForm";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest httpServletRequest, Model model){
//        String username = httpServletRequest.getParameter("username");
//        String password = httpServletRequest.getParameter("password");
        HttpSession session = httpServletRequest.getSession();
        Object realVerifyCode = session.getAttribute("verifyCode");
        String userVerifyCode = httpServletRequest.getParameter("userVerifyCode");

        Admin admin = new Admin();
        if(userVerifyCode!=null && realVerifyCode.equals(userVerifyCode.toLowerCase())){
            admin = adminService.login(username, password);
        }
        else {
            //前端显示“验证码错误”
            return "account/loginForm";
        }
        if(admin != null){
            model.addAttribute("admin",admin);
            return "main/mainForm";
        }
        else {
            return "account/loginForm";
        }
    }

    @RequestMapping("/registerForm")
    public String viewRegisterForm(){
        return "account/registerForm";
    }
}
