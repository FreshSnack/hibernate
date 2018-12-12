package test;

import com.mchange.v1.util.SetUtils;
import entity.Base;
import entity.Item;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import util.HibernateUtil;
import util.JacksonUtils;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: mxding
 * @Date: 2018-12-12 15:37
 */
public class JacksonTest {

    static Item item;

    static Base base;

    @BeforeClass
    public static void setUp() {
        item = new Item();
        item.setItemName("item1");
        item.setItemNum(2);

        base = new Base();
        base.setBaseName("base1");
        base.setItems(new HashSet(Arrays.asList(item)));

        item.setBase(base);
    }

    @Test
    public void save() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

    @Test
    public void testBackRef() {
        Session session = HibernateUtil.getSession();
        Item item1 = session.get(Item.class,1);
        String jsonStr = JacksonUtils.toJSon(item1);
        System.out.println(jsonStr);
    }

    @Test
    public void testManagedRef() {
        Session session = HibernateUtil.getSession();
        Base base1 = session.get(Base.class,1);
        String jsonStr = JacksonUtils.toJSon(base1);
        System.out.println(jsonStr);
    }

    @Test
    public void testDeserialize() {
        String jsonStr = "{\"baseName\":\"base1\",\"items\":[{\"itemName\":\"item1\",\"itemNum\":2}]}";
        Base base1 = JacksonUtils.readValue(jsonStr, Base.class);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(base1);
        session.getTransaction().commit();
    }
}
