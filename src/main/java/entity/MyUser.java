package entity;

import javax.persistence.*;

/**
 * @Author: mxding
 * @Date: 2019-01-11 15:08
 */

@Entity
@Table(name="MY_USER")
public class MyUser {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

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
}
