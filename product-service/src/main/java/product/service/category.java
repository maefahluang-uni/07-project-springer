package product.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "catagory")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    
    @Column(name="name")
    private String Name;

    public category() {
        
    }


    public category(long iD, String name) {
        ID = iD;
        Name = name;
    }
    public long getId() {
        return ID;
    }
    public void setId(long ID) {
        this.ID = ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
}