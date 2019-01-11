package entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: mxding
 * @Date: 2019-01-03 10:04
 */
@Entity
@Table(name="PERSON")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="ID", referencedColumnName = "PERSON_ID")
    @Where(clause = "ID > 5")
    private Pet pet;

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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
