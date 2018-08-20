
package com.stpl.trainee.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.stpl.trainee.bean.StudentBean;
import com.stpl.trainee.service.UpdateService;

@Controller
public class Update {
    
    private static final Logger logger = LogManager.getLogger("Update.class");

    @Autowired
    StudentBean bean;

    @Autowired
    UpdateService updateService;

    @RequestMapping("/UpdateServlet")
    public ModelAndView update(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        bean.setFullname(request.getParameter("fullname"));
        bean.setUsername(request.getParameter("username"));
        bean.setPasword(request.getParameter("password"));
        bean.setAddress(request.getParameter("address"));
        bean.setDob(request.getParameter("dob"));
        bean.setGender(request.getParameter("gender"));
        bean.setEmail(request.getParameter("email"));
        bean.setContact(request.getParameter("phone"));

        int result = updateService.update(bean);
        if (result != 0) {

            logger.info("Updated Successfully..!");
            modelAndView.setViewName("UserMenu");

        } else {
            logger.info("Failed To Upadate Record..!");
            modelAndView.setViewName("ViewAndUpdate");
        }
        return modelAndView;
    }
}
