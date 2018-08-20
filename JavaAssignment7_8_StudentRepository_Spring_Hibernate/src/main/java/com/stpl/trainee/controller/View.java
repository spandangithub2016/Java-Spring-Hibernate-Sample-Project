package com.stpl.trainee.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stpl.trainee.bean.StudentBean;
import com.stpl.trainee.service.StudentRegistration;
import com.stpl.trainee.service.ViewService;

@Controller
public class View {
    
private static final Logger logger = LogManager.getLogger("View.class");

    @Autowired
    StudentBean bean;

    @Autowired
    ViewService viewService;

    @RequestMapping("/ViewServlet")
    public ModelAndView view(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter("username");
        bean.setUsername(username);

        StudentRegistration student = viewService.view(bean);
        if (student != null) {

            modelAndView.addObject("fullname", student.getFullname());
            modelAndView.addObject("username", student.getUsername());
            modelAndView.addObject("password", student.getPasword());
            modelAndView.addObject("address", student.getAddress());
            modelAndView.addObject("dob", student.getDob());
            modelAndView.addObject("gender", student.getGender());
            modelAndView.addObject("email", student.getEmail());
            modelAndView.addObject("contact", student.getContact());

            modelAndView.setViewName("ViewAndUpdate");

        } else {

            logger.info("Invalid username, record not found..!");
            modelAndView.setViewName("ViewInput");
        }
        return modelAndView;
    }

    @RequestMapping("/ViewInputJsp")
    public String view() {
        return "ViewInput";
    }
}
