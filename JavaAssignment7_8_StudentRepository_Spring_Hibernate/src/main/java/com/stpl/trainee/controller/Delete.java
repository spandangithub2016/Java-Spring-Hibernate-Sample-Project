package com.stpl.trainee.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.stpl.trainee.bean.StudentBean;
import com.stpl.trainee.service.DeleteService;

@Controller
public class Delete {
    
    private static final Logger logger = LogManager.getLogger("Delete.class");

    @Autowired
    StudentBean bean;

    @Autowired
    DeleteService deleteService;

    @RequestMapping("/DeleteServlet")
    public ModelAndView delete(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter("username");
        bean.setUsername(username);

        int result = deleteService.delete(bean);

        if (result != 0) {

            logger.info("Username Deleted");
            modelAndView.setViewName("AdminMenu");

        } else {

            logger.info("Username Doesn't Exist");
            modelAndView.setViewName("Delete");

        }
        return modelAndView;
    }

    @RequestMapping("/DeleteJsp")
    public String delete() {
        return "Delete";
    }
}
