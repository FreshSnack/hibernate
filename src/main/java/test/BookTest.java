package test;

import entity.Book;
import entity.BookType;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * @Author: mxding
 * @Date: 2018-11-28 15:21
 */
public class BookTest {


    @Test
    public void addBook() {
        Session session = HibernateUtil.getSession();

        Book book = new Book();
        book.setName("精通Java");
        book.setLicense("N83209");
        book.setBookType(BookType.CHINA);
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
    }

    @Test
    public void getBook() {
        Session session = HibernateUtil.getSession();
        Book book = session.byNaturalId(Book.class).using("license", "N83206").getReference();
        System.out.println(book.getName());
    }

    @Test
    public void getBookByName() {
        Session session = HibernateUtil.getSession();
        Book book = session.byNaturalId(Book.class).using("name", "精通Java").getReference();
        System.out.println(book.getLicense());
    }
}
