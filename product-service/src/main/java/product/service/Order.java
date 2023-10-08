package product.service;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// import org.apache.tomcat.jni.User;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;



    @Column(name="total_price")
    private double totalPrice;
    

    @Column(name="quantity")
    private Long quantity;

    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", referencedColumnName = "ID")
    private product product;
    
    public Order() {

    }

    public Order(Long id, Double totalPrice, Long quantity, product product) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }


   




  


    

    

    
}
