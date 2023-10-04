package order.service.orderservice;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

// import org.apache.tomcat.jni.User;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    ///relationship between CustId and Order

    // @OneToMany(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "user_id", referencedColumnName = "id")
    // private UserDTO cusId; //FK


    LocalDate orderDate;
    Double totalPrice;
    
    Long quantity;

    String user ;
    String product;
    
    public Order() {
    
    }


   public Order(Long id, LocalDate orderDate, double totalPrice, Long quantity, String user, String product) {
    super();
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.user = user;
        this.product = product;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public UserDTO getCusId() {
    //     return cusId;
    // }

    // public void setCusId(UserDTO cusId) {
    //     this.cusId = cusId;
    // }

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



    public String getUser() {
        return user;
    }



    public void setUser(String user) {
        this.user = user;
    }



    public String getProduct() {
        return product;
    }



    public void setProduct(String product) {
        this.product = product;
    }



  


    

    

    
}
