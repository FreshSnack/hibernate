package test;

import entity.MyOrgan;
import entity.MyRole;
import entity.MyUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2019-01-11 15:13
 */
public class MyOrganTest {

    @Test
    public void testAddOrgan() {
        MyOrgan myOrgan = new MyOrgan();
        myOrgan.setName("瑞信软件");

        MyUser myUser1 = new MyUser();
        myUser1.setName("Tom");

        MyUser myUser2 = new MyUser();
        myUser2.setName("Lily");

        myOrgan.setUserList(Arrays.asList(myUser1, myUser2));

        MyRole myRole = new MyRole();
        myRole.setName("经理");

        myOrgan.setRoleList(Arrays.asList(myRole));

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(myOrgan);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testAddOrgan1() {
        MyOrgan myOrgan = new MyOrgan();
        myOrgan.setName("基础软件");

        MyUser myUser1 = new MyUser();
        myUser1.setName("LiMing");

        myOrgan.setUserList(Arrays.asList(myUser1));

        MyRole myRole = new MyRole();
        myRole.setName("组长");

        myOrgan.setRoleList(Arrays.asList(myRole));

        Session session = HibernateUtil.getSession5_3();
        session.beginTransaction();
        session.save(myOrgan);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testOneToMany() {
        Session session = HibernateUtil.getSession5_3();
        MyOrgan organ = session.get(MyOrgan.class, 1);
        System.out.println(organ.getUserList().size());
        System.out.println(organ.getRoleList().size());
    }

    @Test
    public void testOneToMany2() {
        Session session = HibernateUtil.getSession5_3();
        Query query = session.createQuery("from MyOrgan");
        List<MyOrgan> organList = query.list();
        for(MyOrgan myOrgan:organList) {
            System.out.println(myOrgan.getUserList().size());
            System.out.println(myOrgan.getRoleList().size());
        }
    }
}
