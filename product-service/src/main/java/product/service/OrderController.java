package product.service;


import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {



  @Autowired
  private OrderRepository orderRepository;


  @GetMapping("/orders")
  public Collection<Order> getOrders(){
    return orderRepository.findAll();
  }



   @PostMapping("/orders")
   public ResponseEntity createOrder(@RequestBody Order order){
        orderRepository.save(order);
        return ResponseEntity.ok("Order updated");
    }


@GetMapping("orders/{id}")
public ResponseEntity getOrderId(@PathVariable long id){
Optional<Order> optOrder = orderRepository.findById(id);
 
if(!optOrder.isPresent()){
  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found");
}
Order order = optOrder.get();
return ResponseEntity.ok(order);
}


    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable long id) {

        //Can't find id to delete
        if(!orderRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found");
        }

        // delete Products
        orderRepository.deleteById(id);

        // return success message
        return ResponseEntity.ok("Order had Deleted");
    }




  }







    // @Autowired
    // private UserProxy userProxy;


//     @Autowired
//     private ProductProxy productProxy;


    


//    @GetMapping("/purches/price/{price}/quantity/{quamtity}")
//    public Order getOrder(@PathVariable double price ,@PathVariable Long quantity){

//     ResponseEntity<Order> responseEntity = productProxy.calculateProduct(price, quantity);
    
//     Order order = responseEntity.getBody();



//     double  totalPrice =price * quantity;

//     Order response = new Order(quantity, null, totalPrice, quantity, null, null);

// return response;


//    }
      // add service to greet user by id
    // @RequestMapping("/purches/{id}/products/{pid}")
    // public ResponseEntity<String> purchesById(@PathVariable Long uid,@PathVariable  Long pid) {
        // call user-service to get user by id
        // UserDTO userDTO = userProxy.getUser(uid);
        
        // return hello with username
        // return new ResponseEntity<String>("Username :" + userDTO.getUsername() + "Purches : "+productDTO.getNameProduct(), HttpStatus.CREATED);

                // return new ResponseEntity<String>("Purches : "+productDTO.getNameProduct(), HttpStatus.CREATED);

    // }


    

    

