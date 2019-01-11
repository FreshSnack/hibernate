package entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2019-01-11 15:08
 */

@Entity
@Table(name="MY_ORGAN")
public class MyOrgan {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="ORGAN_ID")
    private List<MyUser> userList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="ORGAN_ID")
    private List<MyRole> roleList;

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

    public List<MyUser> getUserList() {
        return userList;
    }

    public void setUserList(List<MyUser> userList) {
        this.userList = userList;
    }

    public List<MyRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<MyRole> roleList) {
        this.roleList = roleList;
    }
}
