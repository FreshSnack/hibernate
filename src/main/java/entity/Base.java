package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Bases")
public class Base {
    @Id
    /*@GenericGenerator(strategy="uuid",name="uuid")
    @GeneratedValue(generator = "uuid")*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String baseName;

    //@JsonManagedReference
    @OneToMany(mappedBy = "base",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<Item>();


    public Base(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}