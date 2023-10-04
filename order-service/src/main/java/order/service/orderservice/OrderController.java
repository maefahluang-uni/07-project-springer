package order.service.orderservice;


import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private ProductProxy productProxy;
 
  // add service to greet user by id
  @GetMapping("/order")
  public ResponseEntity<String> orderId() {
      // call user-service to get user by id
      ProductDTO productDTO= productProxy.getallProduct();
      // return hello with username
      return new ResponseEntity<String>("product"+productDTO, HttpStatus.OK);

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

    }


    

    

