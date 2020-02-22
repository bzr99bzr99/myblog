package nuc.edu.cn.bzr.controller;

import nuc.edu.cn.bzr.model.User;
import nuc.edu.cn.bzr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String logincheck(int userAccount, String userPassword, Model model, HttpSession session) {
        User user = loginService.findUserByAccount(userAccount);
        if (user!=null&&userPassword.equals(user.getUserPassword())&&1==user.getIsadmin()){
            session.setAttribute("user",user);
            model.addAttribute(user);
            return "redirect:/toAdmin/";
        }else{
            model.addAttribute("loginError","账号密码错误");
            return "/login";
        }
    }
}
