package order.service.orderservice;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

// import org.apache.tomcat.jni.User;

@Entity
public class Order {


    Long id;

    ///relationship between CustId and Order

    @OneToMany
    private UserDTO cusId; //FK


    LocalDate orderDate;
    double  totalPrice;
    Long quantity;
    
    public Order() {
    
    }

    public Order(Long id, UserDTO cusId, LocalDate orderDate, double totalPrice, Long quantity) {
        this.id = id;
        this.cusId = cusId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getCusId() {
        return cusId;
    }

    public void setCusId(UserDTO cusId) {
        this.cusId = cusId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    

    

    
}
