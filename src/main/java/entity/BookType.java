package entity;

/**
 * @Author: mxding
 * @Date: 2018-11-29 18:09
 */
public enum BookType {

    CHINA(2,"中文"),ENGLISH(3,"英文");

    public final int id;

    public final String name;

    BookType(int id, String name) {
        this.id = id;
        /*this.name = name;*/
        this.name = name;
    }
}
