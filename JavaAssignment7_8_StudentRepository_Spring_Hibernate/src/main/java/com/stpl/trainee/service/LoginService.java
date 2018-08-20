package com.stpl.trainee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import com.stpl.trainee.bean.StudentBean;


@Component
public class LoginService {

    public StudentRegistration login(StudentBean bean) {

        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session;
        session = sessionFactory.openSession();

        StudentRegistration student = (StudentRegistration) session.get(StudentRegistration.class, bean.getUsername());
        session.close();

        return student;
    }

}
