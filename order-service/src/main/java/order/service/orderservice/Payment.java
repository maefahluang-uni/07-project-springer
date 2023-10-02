package order.service.orderservice;

import javax.persistence.Entity;

@Entity
public class Payment {
    
Long id;
Long orderId;
double amount;
public Payment() {


}
public Payment(Long id, Long orderId, double amount) {
    this.id = id;
    this.orderId = orderId;
    this.amount = amount;
}


public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Long getOrderId() {
    return orderId;
}
public void setOrderId(Long orderId) {
    this.orderId = orderId;
}
public double getAmount() {
    return amount;
}
public void setAmount(double amount) {
    this.amount = amount;
}





}
