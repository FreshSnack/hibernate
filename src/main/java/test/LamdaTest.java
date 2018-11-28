package test;

import org.junit.Test;
import util.IWork;
import util.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2018-11-27 19:05
 */
public class LamdaTest {


    @Test
    public void sortTest() {
        List<String> list = Arrays.asList("1","3","9","5");
        list.sort((o1,o2) -> o1.compareTo(o2));

        list.sort(new Comparator() {


            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

        });
        System.out.println(list);
        list.forEach(s->System.out.println(s));
    }

    @Test
    public void testNoN() {
        new User().doWork(new IWork() {
            @Override
            public void doHomeWork() {
                System.out.println("doing homeworking");
            }

            @Override
            public void doPrint(String ss) {
                System.out.println("doing print" + ss);
            }

            @Override
            public String doReading(String ss) {
                System.out.println("doing Reading" + ss);
                return ss;
            }
        });

        /*new User().doWork((String s)->System.out.println("sss"));*/
    }

    @Test
    public void testPrint() {
        List<String> list = Arrays.asList("1","3","9","5");
        list.forEach(System.out::println);
    }

    @Test
    public void testThread() {
        new Thread(()->System.out.println("dsfj")).start();
    }
}
