package product.service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(name="name")
    private String Name ;

    @Column(name="description")
    private String Discription;

    @Column(name="price")
    private long Price;

    @Column(name="stock")
    private long Stock;


    // @Column(name ="catagoty")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categ_id", referencedColumnName = "ID")
    private category Category;

    @Column(name = "brand")
    private String Brand;
    //constructors 
    product(){

    }
    //constructors 
    public product(long ID, String Name, String Discription, long Price, long Stock, category Category, String Brand) {
        this.ID = ID;
        this.Name = Name;
        this.Discription = Discription;
        this.Price = Price;
        this.Stock = Stock;
        this.Category = Category;
        this.Brand = Brand;
    }
    public long getId() {
        return ID;
    }
    public void setId(long ID) {
        this.ID = ID;
    }
    public String getNameProduct() {
        return Name;
    }
    public void setNameProduct(String Name) {
        this.Name = Name;
    }
    public String getDiscription() {
        return Discription;
    }
    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }
    public long getPrice() {
        return Price;
    }
    public void setPrice(long Price) {
        this.Price = Price;
    }
    public long getStock() {
        return Stock;
    }
    public void setStock(long Stock) {
        this.Stock = Stock;
    }
    public category getCategory() {
        return Category;
    }
    public void setCategory(category category) {
        this.Category = category;
    }
    public String getBrand() {
        return Brand;
    }
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
}