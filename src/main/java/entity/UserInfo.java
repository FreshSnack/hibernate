package entity;

import javax.persistence.*;

/**
 * @Author: mxding
 * @Date: 2018-11-26 08:43
 */
@Entity
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_user_info")
    @SequenceGenerator(name="seq_user_info", sequenceName="SEQ_USER_INFO")
    private Integer id;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "AGE")
    private Integer age;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "USER_ID")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "userInfo")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
