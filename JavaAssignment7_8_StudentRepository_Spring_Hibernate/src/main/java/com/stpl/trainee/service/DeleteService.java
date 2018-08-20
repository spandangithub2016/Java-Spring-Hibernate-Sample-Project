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
public class DeleteService {
    
    private static final Logger logger = LogManager.getLogger("DeleteService.class");

    public int delete(StudentBean bean) {

        int result = 0;

        Configuration c = new Configuration();
        c.configure("/hibernate.cfg.xml");
        SessionFactory sf = c.buildSessionFactory();

        StudentRegistration student = new StudentRegistration();

        Session session = null;
        Transaction transaction = null;

        try {

            session = sf.openSession();
            transaction = session.beginTransaction();

            student = (StudentRegistration) session.get(StudentRegistration.class, bean.getUsername());

            if (student != null) {

                session.delete(student);
                transaction.commit();
                result = 1;
            }

        } catch (Exception e) {

            logger.info("Error in Deleteion: " + e);
            if (session != null) {

                transaction.rollback();
                session.close();
            }
        }
        return result;
    }

}
