package product.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "categoty")
public class categoty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    
    private String Name;


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