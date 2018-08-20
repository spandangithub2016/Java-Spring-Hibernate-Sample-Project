package com.stpl.trainee.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.stpl.trainee.bean.StudentBean;
import com.stpl.trainee.service.LoginService;
import com.stpl.trainee.service.StudentRegistration;

@Controller
public class Login {
    
    private static final Logger logger = LogManager.getLogger("Login.class");

    @Autowired
    StudentBean bean;

    @Autowired
    LoginService loginService;

    @RequestMapping("/LoginServlet")
    public ModelAndView login(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        bean.setUsername(username);
        bean.setPasword(password);

        if ("admin".equals(username) && "admin".equals(password)) {

            logger.info("Admin login success");
            modelAndView.setViewName("AdminMenu");

        } else {

             StudentRegistration student = loginService.login(bean);
            if (student != null && student.getPasword().equals(bean.getPasword())) {

                logger.info("User login success");
                modelAndView.setViewName("UserMenu");

            } else {

                logger.info("User login failed");
                modelAndView.setViewName("Login");

            }
        }
        return modelAndView;
    }

    @RequestMapping("/LoginJsp")
    public String login() {
        return "Login";
    }
}
