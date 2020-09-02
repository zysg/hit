package com.htsc.controller;


import com.htsc.repository.User;
import com.htsc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session == null ||session.getAttribute("username") == null)
            return "redirect:/login";
        else
            return "index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }


    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody User user, HttpServletRequest request) {
        boolean flag=loginService.login(user.getUsername(), user.getUsername());
        if(flag) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
        }
        return flag;
    }

    @PostMapping("/register")
    @ResponseBody
    public boolean register(@RequestBody User user) {
        return loginService.register(user.getUsername(), user.getUsername());
    }
}
