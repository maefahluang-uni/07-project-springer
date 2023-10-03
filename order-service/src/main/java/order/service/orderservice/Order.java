package order.service.orderservice;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Order {


    Long id;

    ///relationship between CustId and Order
    Long cusId;
    LocalDate orderDate;
    double  totalPrice;
    Long quantity;
    
    public Order() {
    
    }

    public Order(Long id, Long cusId, LocalDate orderDate, double totalPrice, Long quantity) {
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

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
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
