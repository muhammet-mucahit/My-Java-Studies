package com.login.controller;

import com.login.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

//        if (uname.equals("admin") && pass.equals("admin")) {
//            modelAndView.setViewName("success.jsp");
//        }
        if (LoginService.check(uname, pass)) {
            modelAndView.setViewName("success.jsp");
        }
        else {
            modelAndView.setViewName("index.jsp");
        }

        return modelAndView;
    }
}
