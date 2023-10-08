package product.service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class productDTO {

    private long ID;

   


    @JsonProperty("product_name")
    private String Name ;

    @JsonProperty("product_descript")
    private String Discription;

    @JsonProperty("product_price")
    private long Price;

    @JsonProperty("product_stock")
    private long Stock;

    @JsonProperty("product_brand")
    private String Brand;

    public productDTO() {

    }

    public productDTO(long iD, String name, String discription, long price, long stock, String brand) {
        ID = iD;
        Name = name;
        Discription = discription;
        Price = price;
        Stock = stock;
        Brand = brand;
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

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
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

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    
    
    



    
}