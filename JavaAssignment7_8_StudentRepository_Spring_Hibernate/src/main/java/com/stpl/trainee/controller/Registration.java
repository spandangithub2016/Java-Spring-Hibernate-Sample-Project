
package com.stpl.trainee.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.stpl.trainee.bean.StudentBean;
import com.stpl.trainee.service.RegistrationService;

@Controller
public class Registration {

    private static final Logger logger = LogManager.getLogger("Registration.class");

    @Autowired
    StudentBean studentBean;

    @Autowired
    RegistrationService registrationService;

    @RequestMapping("/RegistrationServlet")
    public ModelAndView registration(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        studentBean.setFullname(request.getParameter("fullname"));
        studentBean.setUsername(request.getParameter("username"));
        studentBean.setPasword(request.getParameter("password"));
        studentBean.setAddress(request.getParameter("address"));
        studentBean.setDob(request.getParameter("dob"));
        studentBean.setGender(request.getParameter("gender"));
        studentBean.setEmail(request.getParameter("email"));
        studentBean.setContact(request.getParameter("phone"));

        int result = registrationService.insert(studentBean);
        if (result != 0) {

            logger.info("Registration Successfull..!");
            modelAndView.setViewName("Login");

        } else {
            logger.info("Username Violation Occured..!");
            modelAndView.setViewName("Registration");
        }
        return modelAndView;
    }

    @RequestMapping("/RegistrationJsp")
    public String registrationJsp() {
        return "Registration";

    }

}
