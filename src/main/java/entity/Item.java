package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Item {
    @Id
    /*@GenericGenerator(strategy="uuid",name="uuid")
    @GeneratedValue(generator = "uuid")*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String itemName;


    private Integer itemNum;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="b_id")
    private Base base;


    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Item(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }
}
