package product.service;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class productDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(name="name")
    private String Name ;
    
    @Column(name="price")
    private long Price;

    @Column(name="stock")
    private long Stock;

    productDTO(){

    }

    public productDTO(long iD, String name, long price, long stock) {
        ID = iD;
        Name = name;
        Price = price;
        Stock = stock;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public long getStock() {
        return Stock;
    }

    public void setStock(long stock) {
        Stock = stock;
    }

    
}