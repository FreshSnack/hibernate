package entity;

import java.io.Serializable;

/**
 * @Author: mxding
 * @Date: 2018-11-28 13:51
 */
public class Type implements Serializable {

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
