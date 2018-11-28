package test;

import entity.User;
import entity.UserInfo;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author: mxding
 * @Date: 2018-11-26 08:50
 */
public class UserTest {

    private static Session session;

    private static SessionFactory factory;

    @BeforeClass
    public static void setUp() {
        Configuration cfg = new Configuration();
        cfg.configure();

        //2.创建SessionFactory工厂
        factory = cfg.buildSessionFactory();

        //3.创建Session对象
        session = factory.getCurrentSession();

    }

    @AfterClass
    public static void dispose() {
        session.close();
    }


    @Test
    public void testAddUser() {
        User user = new User();
        user.setLoginName("admin");
        user.setName("管理员");
        user.setPassword("1111");


        UserInfo userInfo = new UserInfo();
        userInfo.setAge(20);
        userInfo.setSex("man");
        userInfo.setUser(user);

        user.setUserInfo(userInfo);

        //session.save(user);
        //session.save(userInfo);
        session.beginTransaction();
        session.persist(userInfo);
        session.getTransaction().commit();

    }

    @Test
    public void getUser() {
        //session.setCacheMode(CacheMode.GET);
        /*User user = session.get(User.class, 3, LockMode.PESSIMISTIC_READ);
        System.out.println(user);

        session.clear();*/
        /*session.close();

        session = factory.openSession();*/
        User user = session.get(User.class, 1);
        System.out.println(user.getId());

        /*UserInfo userInfo = session.get(UserInfo.class, 2);
        System.out.println(userInfo);*/
    }


    @Test
    public void deleteUser() {
        session.beginTransaction();
        User user = session.get(User.class, 1);
        session.delete(user);
        session.getTransaction().commit();
    }

    @Test
    public void deleteUserInfo() {
        session.beginTransaction();
        UserInfo userInfo = session.get(UserInfo.class, 2);
        session.delete(userInfo);
        session.getTransaction().commit();
    }

    @Test
    public void getCacheUser() {
        Criteria criteria = session.createCriteria(User.class);
        criteria.setCacheable(true);
        criteria.list();
        criteria.list();
    }


    @Test
    public void loadUser() {
        User user = session.load(User.class, 1);
        //System.out.println(user.getId());
        System.out.println(user.getId());
    }
}
