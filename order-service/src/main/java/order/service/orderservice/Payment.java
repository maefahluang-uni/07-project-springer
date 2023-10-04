// package order.service.orderservice;

// import javax.persistence.CascadeType;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;

// @Entity ///must be entity cause critiria
// public class Payment {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(cascade = CascadeType.MERGE)
//     @JoinColumn(name = "order_id", referencedColumnName = "id")
//     private Order order; // Corrected variable name

//     private double amount;

//     public Payment() {
//         // Default constructor
//     }

//     // Getters and setters (or Lombok annotations) for id, order, and amount
//     // You need to generate getters and setters for the private fields.
    
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Order getOrder() {
//         return order;
//     }

//     public void setOrder(Order order) {
//         this.order = order;
//     }

//     public double getAmount() {
//         return amount;
//     }

//     public void setAmount(double amount) {
//         this.amount = amount;
//     }


// }
