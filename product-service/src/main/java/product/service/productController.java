package product.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {

    @Autowired
    private productRepository productRepository;
    // // Create hashmap for Product
    // private HashMap<Long, Product> productDB = new HashMap<Long, Product>();

    // Select all Product
    @GetMapping("/products")
    public Collection<product> getallProduct() {
        return productRepository.findAll();
    }

    // Select Products By ID
    @GetMapping("/products/{id}")
    public ResponseEntity getAllProductById(@PathVariable long ID) {
        Optional<product> optProduct = productRepository.findById(ID);

        // check if id exists in db
        if (!optProduct.isPresent()) {
            // return error message 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");

        }
        product emp = optProduct.get();
        return ResponseEntity.ok(emp);
    }

    // Select Products By ID
    @GetMapping("/products/pname/{Name}")
    public ResponseEntity getAllNameStartingWith(@PathVariable String Name) {
        System.out.println(Name);
        List<product> product = productRepository.findByNameStartingWith(Name);

        // check if FirstName have to in list
        if (product.isEmpty()) {
            // return error message 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");

        }

        return ResponseEntity.ok(product);
    }

    // Create new Product
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody product product) {

        // add Product to hashmap
        productRepository.save(product);

        // return created success message Product created
        return ResponseEntity.ok("Product created");
    }

    // update Products
    @PutMapping("/products")
    public ResponseEntity<String> updateProduct( @RequestBody product product) {

        //Can't find id to Update
        if(!productRepository.existsById(product.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("product id already exists");
        }

        // update Products
        productRepository.save(product);

        // return success message
        return ResponseEntity.ok("product updated");
    }
    // Delete Products
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {

        //Can't find id to delete
        if(!productRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product id Deleted");
        }

        // delete Products
        productRepository.deleteById(id);

        // return success message
        return ResponseEntity.ok("Product had Deleted");
    }

}