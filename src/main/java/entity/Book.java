package entity;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * @Author: mxding
 * @Date: 2018-11-28 15:19
 */
@Entity
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @NaturalId
    @Column(name="LICENSE")
    private String license;

    @Column(name="BOOK_TYPE")
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
