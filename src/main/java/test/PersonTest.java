package test;

import entity.Person;
import entity.Pet;
import entity.Student;
import entity.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * @Author: mxding
 * @Date: 2019-01-03 10:10
 */
public class PersonTest {

    @Test
    public void addPerson() {
        Session session = HibernateUtil.getSession();
        Person person = new Person();
        person.setName("zhangsan");

        Pet pet = new Pet();
        pet.setName("cat");

        person.setPet(pet);
        session.beginTransaction();
        session.persist(person);
        pet.setPersonId(person.getId());
        session.save(pet);
        session.getTransaction().commit();
        session.clear();

        Pet pet1 = session.get(Pet.class, 1);
        //System.out.println(pet1.getPerson().getId());
        session.close();
    }

    @Test
    public void addPet() {
        Session session = HibernateUtil.getSession();
        Pet pet = new Pet();
        pet.setName("cat");
        pet.setPersonId(1);
        session.beginTransaction();
        session.save(pet);
        session.getTransaction().commit();

    }

    @Test
    public void getPerson() {
        Session session = HibernateUtil.getSession();
        Person p = session.get(Person.class, 4);
        //p.getPet();
    }


    @Test
    public void getStu() {
        Session session = HibernateUtil.getSession();
        User ss = session.get(User.class, 1);
        ss.getUserInfo().getId();
    }


}
