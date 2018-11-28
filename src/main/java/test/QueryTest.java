package test;

import entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.procedure.ProcedureCall;
import org.junit.Test;
import util.HibernateUtil;

import javax.persistence.ParameterMode;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2018-11-27 16:27
 */
public class QueryTest {


    @Test
    public void queryStudent() {
        Session session = HibernateUtil.getSession();
        String hql = "from Student";
        List<Student> list = session.createQuery(hql).list();
        list.stream().forEach(student ->System.out.println(student.getName()));

        List<Student> list2 = session.createQuery(hql).list();
        list2.stream().forEach(student ->System.out.println(student.getName()));
    }

    @Test
    public void queryStuName() {
        String hql = "select name from Student";
        List<String> list = HibernateUtil.getSession().createQuery(hql).list();
        list.stream().forEach(name ->System.out.println(name));
    }

    @Test
    public void sqlQueryStudent() {
        String sql = "select id,name,teacher_id from student";
        List<Student> stuList = HibernateUtil.getSession().createSQLQuery(sql).addEntity(Student.class).list();
        stuList.stream().forEach(student ->System.out.println(student.getName()));
    }

    @Test
    public void sqlQueryStudent1() {
        String sql = "select id,name from student";
        List stuList = HibernateUtil.getSession().createSQLQuery(sql).list();
        System.out.println(stuList.get(0));
    }


    @Test
    public void queryByCriteria() {
        List<Student> stuList = HibernateUtil.getSession().createCriteria(Student.class).addOrder(Order.desc("name"))
                .add(Restrictions.gt("id", 1)).list();
        stuList.stream().forEach(student ->System.out.println(student.getName()));
    }

    @Test
    public void iteratorStudent() {
        Session session = HibernateUtil.getSession();
        Iterator it = session.createQuery("from Student").iterate();
        while(it.hasNext()) {
            System.out.println(((Student)it.next()).getName());
        }

        Iterator it2 = session.createQuery("from Student").iterate();
        while(it2.hasNext()) {
            System.out.println(((Student)it2.next()).getName());
        }
    }

    @Test
    public void iteratorList() {
        Session session = HibernateUtil.getSession();

        List<Student> list = session.createQuery("from Student").list();
        list.stream().forEach(student ->System.out.println(student.getName()));

        Iterator it2 = session.createQuery("from Student").iterate();
        while(it2.hasNext()) {
            System.out.println(((Student)it2.next()).getName());
        }


    }


    @Test
    public void procedureCall() {
        ProcedureCall call =  HibernateUtil.getSession().createStoredProcedureCall("pro_add");
        call.registerParameter("num1", Integer.class, ParameterMode.IN).bindValue(10);
        call.registerParameter("num2", Integer.class, ParameterMode.IN).bindValue(20);
        call.registerParameter("num", Integer.class, ParameterMode.OUT);
        Object oo = call.getOutputs().getOutputParameterValue("num");
        System.out.println(oo);
    }

    @Test
    public void functionCall() {
        Object  o = HibernateUtil.getSession().doReturningWork(connection -> {
            CallableStatement call = connection.prepareCall("{?=call fun_add(?,?)}");
            call.registerOutParameter(1, Types.INTEGER);
            call.setInt(2, 10);
            call.setInt(3, 10);
            call.execute();
            return call.getInt(1);
        });
        System.out.println(o);
    }


    @Test
    public void functionCall2() {
        /*Query query = HibernateUtil.getSession().createQuery("{call fun_add(?,?)}");
        query.setInteger(0, 10);
        query.setInteger(1,15);
        System.out.println(query.uniqueResult());*/

        ProcedureCall call =  HibernateUtil.getSession().createStoredProcedureCall("fun_add", Student.class);
        call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(10);
        call.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(15);
        Object oo = call.getOutputs();
        System.out.println(oo);
    }

}
