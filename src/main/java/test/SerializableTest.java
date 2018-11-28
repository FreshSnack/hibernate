package test;

import entity.Student;
import entity.Teacher;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: mxding
 * @Date: 2018-11-27 15:51
 */
public class SerializableTest {

    @Test
    public void testSave() {
        Student s = new Student();
        s.setName("Lily");
        s.setId(30);
        Teacher tt = new Teacher();
        tt.setName("teacher1");
        s.setTeacher(tt);
        try {
            FileOutputStream fos = new FileOutputStream("d:\\student1.ser");
            ObjectOutputStream os=new ObjectOutputStream(fos);
            os.writeObject(s);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadStudent() {
        try {
            FileInputStream fis = new FileInputStream("d:\\student1.ser");
            ObjectInputStream is=new ObjectInputStream(fis);
            Student ss = (Student)is.readObject();
            System.out.println(ss.getName());
            System.out.println(ss.getTeacher().getName());
            is.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
