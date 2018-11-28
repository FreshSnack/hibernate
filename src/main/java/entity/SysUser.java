package entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2018-11-26 08:43
 */
@Entity
@Table(name = "SYS_USER")
public class SysUser {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOGIN_NAME")
    private String loginName;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USER_GL_ORGAN", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns = {@JoinColumn(name="ORGAN_ID")})
    private List<SysOrgan> organList;


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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysOrgan> getOrganList() {
        return organList;
    }

    public void setOrganList(List<SysOrgan> organList) {
        this.organList = organList;
    }
}
