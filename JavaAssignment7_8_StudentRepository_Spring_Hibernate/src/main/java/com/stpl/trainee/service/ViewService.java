 package com.stpl.trainee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import com.stpl.trainee.bean.StudentBean;

@Component
public class ViewService {

    public StudentRegistration view(StudentBean bean) {

        Configuration c = new Configuration();
        c.configure("/hibernate.cfg.xml");
        SessionFactory sf = c.buildSessionFactory();

        Session session;
        session = sf.openSession();

        StudentRegistration student = (StudentRegistration) session.get(StudentRegistration.class, bean.getUsername());
        session.close();

        return student;
    }

}
