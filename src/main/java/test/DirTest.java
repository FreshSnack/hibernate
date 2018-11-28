package test;

import org.junit.Test;

/**
 * @Author: mxding
 * @Date: 2018-11-26 14:14
 */
public class DirTest {


    @Test
    public void testDir() {
        System.out.println("user.dir:" + System.getProperty("user.dir"));
        System.out.println("user.home:" + System.getProperty("user.home"));
        System.out.println("java.io.tmpdir:" + System.getProperty("java.io.tmpdir"));
    }
}
