package product.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class productController {

    @Autowired
    private  productRepository productRepository;
    // Create hashmap for Product
    

    @Autowired
    private productMapper producstMapper;



    

    // Select all Product
    @GetMapping("/products")
    public Collection<product> getallProduct() {
        return productRepository.findAll();
    }

    // Select Products By ID****
    @GetMapping("/products/{ID}")
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

    // Create new Product*****
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
    // Delete Products*****
    @DeleteMapping("/products/{ID}")
    public ResponseEntity<String> deleteProduct(@PathVariable long ID) {

        //Can't find id to delete
        if(!productRepository.existsById(ID)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product id Deleted");
        }

        // delete Products
        productRepository.deleteById(ID);

        // return success message
        return ResponseEntity.ok("Product had Deleted");
    }


    @PatchMapping("/products/{id}")
    public ResponseEntity<String> patchProduct(@PathVariable long id,
    @RequestBody productDTO product){
Optional<product> optProduct = productRepository.findById(id);

if(!optProduct.isPresent()){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
}

  //get employee from db
product products = optProduct.get();


  // update employee by using mapper from dto
producstMapper.updateProductFromDTO(product, products);

//save to db
productRepository.save(products);

return ResponseEntity.ok("Product updated");

    }
  


}