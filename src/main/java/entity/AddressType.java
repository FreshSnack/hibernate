package entity;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class AddressType implements UserType, Serializable {
    private String homeAddr;
    private String workAddr;

    /* 有几个字段就有几个值，这里easy出错。要多注意 */
    private static final int[] SQL_TYPES = { Types.VARCHAR, Types.VARCHAR };

    /* 这种方法告诉Hibernate在成生DDL时对列採用什么样的SQL语法 */
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    /*
     * Hibernate返回什么样的映射类型。与 <property name="address" type="model.AddressType">
     * 指定的类一致。其实也能够把AddressType拆分为两个类，一个类是仅仅携带信息的JavaBean，它里面
     * 没有逻辑操作也没有实现UserType（比方AddressBean）。而还有一个类实现了UserType。它所面对的就不是如今这个
     * AddressType类的homeAddr和homeAddr属性，它面对的是AddressBean。在本例中为了简洁方便。仅仅用了一个类。

     */
    public Class returnedClass() {
        return AddressType.class;
    }

    /*
     * 表明这个类的实例在创建以后就不能够改变属性。Hibernate能为不可改变的类作一些性能优化。
     */
    public boolean isMutable() {
        return false;
    }

    /*
     * 因为AddressType是不可变的，所以深拷贝能够直接返回对象引用。

拷贝的对象由应用程序使用。 而原版对象由Hibernate维护以做脏数据检查
     */
    public Object deepCopy(Object value) {
        return value; // Address is immutable
    }

    /* 两个对象是否相等，使用了apache的common工具包来进行属性比对 */
    public boolean equals(Object x, Object y) {
        if (x == y)
            return true;
        if (x == null || y == null)
            return false;
        AddressType add1 = (AddressType) x;
        AddressType add2 = (AddressType) y;
        return new EqualsBuilder() //使用EqualsBuilder类来方便地进行比对
                .append(add1.getHomeAddr(), add2.getHomeAddr()).append(
                        add2.getWorkAddr(), add2.getWorkAddr()).isEquals();
    }

    /* 得到hash码 */

    public int hashCode(Object x) throws HibernateException {
        AddressType address = (AddressType) x;
        return new HashCodeBuilder()//使用HashCodeBuilder类来方便地进行比对
                .append(address.getHomeAddr()).append(address.getWorkAddr())
                .toHashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        if (rs.wasNull())
            return null;
        String homeAddr = rs.getString(names[0]);
        String schoolAddr = rs.getString(names[1]);
        AddressType address = new AddressType(homeAddr, schoolAddr);
        return address;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        AddressType address = (AddressType) value;
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index+1, Types.VARCHAR);
        } else {
            st.setString(index, address.getHomeAddr());
            st.setString(index + 1, address.getWorkAddr());
        }
        System.out.println("Data has been saved! ");
    }

    /* 读取数据并组装成一个AddressType对象。



names[]中的參数顺序按照映射文件里定义的顺序 *//*
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
            throws HibernateException, SQLException {
        if (rs.wasNull())
            return null;
        String homeAddr = rs.getString(names[0]);
        String schoolAddr = rs.getString(names[1]);
        AddressType address = new AddressType(homeAddr, schoolAddr);
        return address;
    }

    *//* 保存数据。index的顺序依照映射文件定义的顺序。从0開始。 *//*
    public void nullSafeSet(PreparedStatement st, Object value, int index)
            throws HibernateException, SQLException {
        AddressType address = (AddressType) value;
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index+1, Types.VARCHAR);
        } else {
            st.setString(index, address.getHomeAddr());
            st.setString(index + 1, address.getWorkAddr());
        }
        System.out.println("Data has been saved! ");
    }*/

    /* 当把AddressType类型数据写入二级缓存时，此方法被调用 */
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    /* 当从二级缓存中读取AddressType类型数据时。此方法被调用 */
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        // TODO 自己主动生成方法存根
        return null;
    }

    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        // TODO 自己主动生成方法存根
        return null;
    }

    public AddressType() {
        super();
    }

    public AddressType(String homeAddr, String workAddr) {
        super();
        this.homeAddr = homeAddr;
        this.workAddr = workAddr;
    }

    /**
     * @return 返回 sQL_TYPES。
     */
    public static int[] getSQL_TYPES() {
        return SQL_TYPES;
    }

    /**
     * @return 返回 homeAddr。




     */
    public String getHomeAddr() {
        return homeAddr;
    }

    /**
     * @param homeAddr
     *            要设置的 homeAddr。
     */
    private void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    private String getWorkAddr() {
        return workAddr;
    }

    private void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }





}