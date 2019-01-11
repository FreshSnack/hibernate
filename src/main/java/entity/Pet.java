package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: mxding
 * @Date: 2019-01-03 10:05
 */
@Entity
@Table(name="PET")
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="PERSON_ID")
    private Integer personId;

    /*@OneToOne(mappedBy = "pet")
    private Person person;*/

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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /*public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/
}
