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
public class RegistrationService {
    
    private static final Logger logger = LogManager.getLogger("RegistrationService.class");

    public int insert(StudentBean bean) {

        int result = 0;

        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        SessionFactory sf = configuration.buildSessionFactory();

        StudentRegistration studentRegister = new StudentRegistration();

        studentRegister.setFullname(bean.getFullname());
        studentRegister.setUsername(bean.getUsername());
        studentRegister.setPasword(bean.getPasword());
        studentRegister.setAddress(bean.getAddress());
        studentRegister.setDob(bean.getDob());
        studentRegister.setGender(bean.getGender());
        studentRegister.setEmail(bean.getEmail());
        studentRegister.setContact(bean.getContact());

        Session session = null;
        Transaction transaction = null;
        try {

            session = sf.openSession();
            transaction = session.beginTransaction();

            session.save(studentRegister);
            transaction.commit();

            result = 1;

        } catch (Exception e) {
            
            logger.info("Error in Registration: " + e);
            if (session != null) {

                transaction.rollback();
                session.close();
            }
        }
        return result;
    }
}
