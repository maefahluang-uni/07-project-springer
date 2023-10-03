package order.service.orderservice;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


     @Autowired
    private UserProxy userProxy;
    private ProductProxy productProxy;

      // add service to greet user by id
    @RequestMapping("/purches/{id}")
    public ResponseEntity<String> purchesById(@PathVariable Long id) {
        // call user-service to get user by id
        UserDTO userDTO = userProxy.getUser(id);
        ProductDTO productDTO = productProxy.getProduct(id);

        // return hello with username
        return new ResponseEntity<String>("Username :" + userDTO.getUsername() + "Purches : "+productDTO.getNameProduct(), HttpStatus.CREATED);

    }


    

    
}
