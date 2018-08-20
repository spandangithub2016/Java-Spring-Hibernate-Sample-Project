package com.stpl.trainee.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.stpl.trainee.bean.StudentBean;

@Component
public class UpdateService {
    
    private static final Logger logger = LogManager.getLogger("UpdateService.class");

    public int update(StudentBean bean) {

        int result = 0;

        Configuration c = new Configuration();
        c.configure("/hibernate.cfg.xml");
        SessionFactory sf = c.buildSessionFactory();

        StudentRegistration student = new StudentRegistration();
        student.setFullname(bean.getFullname());
        student.setUsername(bean.getUsername());
        student.setPasword(bean.getPasword());
        student.setAddress(bean.getAddress());
        student.setDob(bean.getDob());
        student.setGender(bean.getGender());
        student.setEmail(bean.getEmail());
        student.setContact(bean.getContact());

        Session session = null;
        Transaction transaction = null;
        try {

            session = sf.openSession();
            transaction = session.beginTransaction();

            session.update(student);
            transaction.commit();

            result = 1;

        } catch (Exception e) {
            
            logger.info("Error in Updation: " + e);
            if (session != null) {

                transaction.rollback();
                session.close();
            }
        }
        return result;
    }
}
