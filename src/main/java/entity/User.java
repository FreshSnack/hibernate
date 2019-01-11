package entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: mxding
 * @Date: 2018-11-26 08:43
 */
@Entity
@Table(name = "USER")
/*@Cache(region = "entity.User", usage = CacheConcurrencyStrategy.READ_WRITE)*/
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_user")
    @SequenceGenerator(name="seq_user", sequenceName="SEQ_USER")*/
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOGIN_NAME")
    private String loginName;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_INFO_ID")
    //@Where(clause = "AGE > 10")
    @WhereJoinTable(clause = "AGE > 10")
    private UserInfo userInfo;

    @Basic(fetch = FetchType.LAZY)
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
