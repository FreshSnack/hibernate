package entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: mxding
 * @Date: 2018-11-26 14:28
 */
@Entity
@Table(name = "SYS_ORGAN")
public class SysOrgan {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinTable(name="USER_GL_ORGAN", joinColumns={@JoinColumn(name="ORGAN_ID")}, inverseJoinColumns = {@JoinColumn(name="USER_ID")})
    private List<SysUser> sysUserList;

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

    public List<SysUser> getSysUserList() {
        return sysUserList;
    }

    public void setSysUserList(List<SysUser> sysUserList) {
        this.sysUserList = sysUserList;
    }
}
