package entity;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: mxding
 * @Date: 2018-11-23 17:22
 */
@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer sage;

    //@Formula("(select sum(s.age) from student s limit 1)")
    @Formula("(select sum(s.age) from Student s)")
    private Integer totalAge;

    /*@Columns(columns = {
            @Column(name="NAME"), @Column(name="AGE")
    })*/
    @Column(name = "information")
    @ColumnTransformer(forColumn = "information", read = "upper(information)", write = "lower(?)")
    private String information1;

    /*@org.hibernate.annotations.Type(type="entity.AddressType")
    @Columns(columns = {
            @Column(name = "homeAddr"),
            @Column(name = "workAddr")
    })
    @ColumnTransformer(forColumn = "workAddr", read = "upper(workAddr)", write = "lower(?)")
   private AddressType addressType;*/

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getSage() {
        return sage;
    }

    public Integer getTotalAge() {
        return totalAge;
    }

    public void setTotalAge(Integer totalAge) {
        this.totalAge = totalAge;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getInformation1() {
        return information1;
    }

    public void setInformation1(String information1) {
        this.information1 = information1;
    }

}
