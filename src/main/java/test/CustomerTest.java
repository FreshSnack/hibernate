package test;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author: mxding
 * @Date: 2018-11-27 15:12
 */
public class CustomerTest {

    private static Session session;

    @BeforeClass
    public static void setUp() {
        Configuration cfg = new Configuration();
        cfg.configure();

        //2.创建SessionFactory工厂
        SessionFactory factory = cfg.buildSessionFactory();

        //3.创建Session对象
        session = factory.openSession();
    }

    @AfterClass
    public static void dispose() {
        session.close();
    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setName("瑞信软件");
        customer.setAddress("安徽芜湖");
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }


    @Test
    public void getCustomer() {
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer.getId());
    }

    @Test
    public void loadCustomer() {
        Customer customer = session.load(Customer.class, 1);
        //System.out.println(customer.getId());

        System.out.println("abc");
    }
}
