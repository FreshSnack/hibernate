package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Author: mxding
 * @Date: 2018-11-27 16:28
 */
public class HibernateUtil {

    private static SessionFactory factory;

    public static Session getSession() {
        if(factory == null || factory.isClosed()) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory.openSession();
    }
}
