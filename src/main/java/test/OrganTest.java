package test;

import entity.SysOrgan;
import entity.SysUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2018-11-26 14:37
 */
public class OrganTest {

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
    public void addOrgan() {
        SysOrgan organ = new SysOrgan();
        organ.setName("瑞信软件");

        SysUser sysUser1 = new SysUser();
        sysUser1.setLoginName("admin");
        sysUser1.setName("后台管理员");
        sysUser1.setPassword("1111");

        SysUser sysUser2 = new SysUser();
        sysUser2.setLoginName("plat");
        sysUser2.setName("平台管理员");
        sysUser2.setPassword("1111");

        List<SysUser> userList = Arrays.asList(sysUser1, sysUser2);

        organ.setSysUserList(userList);

        session.beginTransaction();

        session.save(organ);

        session.getTransaction().commit();
    }

    @Test
    public void addUser() {
        SysOrgan organ = new SysOrgan();
        organ.setName("瑞信软件");

        SysUser sysUser = new SysUser();
        sysUser.setLoginName("admin");
        sysUser.setName("后台管理员");
        sysUser.setPassword("1111");

        sysUser.setOrganList(Arrays.asList(organ));
        session.beginTransaction();

        session.save(sysUser);

        session.getTransaction().commit();
    }
}
