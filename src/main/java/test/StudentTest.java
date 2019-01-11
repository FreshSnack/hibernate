package test;

import entity.Student;
import entity.Teacher;
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
 * @Date: 2018-11-26 10:37
 */
public class StudentTest {

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
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("王老师");

        Student student1 = new Student();
        student1.setName("张三");

        Student student2 = new Student();
        student2.setName("李四");

        List<Student> studentList = Arrays.asList(student1, student2);

        teacher.setStudentList(studentList);

        session.beginTransaction();
        /*session.save(student1);
        session.save(student2);
        session.persist(teacher);*/
        session.save(teacher);
        session.getTransaction().commit();
    }

    @Test
    public void deleteStudent() {
        session.beginTransaction();
        Student student = session.get(Student.class, 1);
        session.delete(student);
        session.getTransaction().commit();
    }

    @Test
    public void deleteTeacher() {
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, 3);
        session.delete(teacher);
        session.getTransaction().commit();
    }

    @Test
    public void getTeacher() {
        Teacher teacher = session.get(Teacher.class, 2);
        System.out.println(teacher);

        session.clear();
        Student student = session.get(Student.class, 1);
        System.out.println(student);

    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setName("zhangSan");
        student.setSage(10);
        student.setInformation1("IpQ");
        //student.setAddressType(new AddressType("hOmE","woRK"));

        /*Student student2 = new Student();
        student2.setName("张三");
        student2.setSageAge(15);

        Teacher teacher = new Teacher();
        teacher.setName("王老师");
        student.setTeacher(teacher);
        student2.setTeacher(teacher);*/

        session.beginTransaction();
        session.save(student);
        //session.save(student2);
        session.getTransaction().commit();
    }

    @Test
    public void getStudent() {
        Student student = session.get(Student.class, 17);
        System.out.println(student.getInformation1());
    }
}
