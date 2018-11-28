package test;

import entity.Student;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder
public class Demo {

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

    @Test
    public void testAdd(){

        Teacher teacher = new Teacher();
        teacher.setName("王老师");

        Student student1 = new Student();
        student1.setName("张三");

        Student student2 = new Student();
        student2.setName("李四");

        List<Student> studentList = Arrays.asList(student1, student2);

        teacher.setStudentList(studentList);

        Transaction tx = session.beginTransaction();

        session.persist(teacher);

        session.save(teacher);



//        List stuList = teacher.getStudentList();
//        List stuList2 = Arrays.asList(stuList.get(0));
//        teacher.setStudentList(stuList2);
        //Transaction tx2 = session.beginTransaction();
        session.saveOrUpdate(teacher);
        //tx2.commit();
        tx.commit();

    }

    @Test@Ignore
    public void testEdit() {
//        Student student1 = new Student();
//        student1.setName("张三");
//        Teacher teacher = session.get(Teacher.class, 16);
//        teacher.getStudentList().remove(0);
        Transaction tx = session.beginTransaction();
        Teacher teacher = new Teacher();
        teacher.setStudentList(new ArrayList<>());
        teacher.setName("王老师");
        teacher.setId(3);

        Teacher teacher2 = session.get(Teacher.class,teacher.getId());
        teacher2.setName(teacher.getName());
        teacher2.getStudentList().clear();

        session.saveOrUpdate(teacher2);
        /*Teacher teacher2=session.get(Teacher.class,teacher.getId());
        teacher2.setName("WANG");
        teacher2.setStudentList(teacher.getStudentList());
        session.update(teacher2);*/
        tx.commit();
    }


    @AfterClass
    public static void dispose() {
        session.close();
    }

}
