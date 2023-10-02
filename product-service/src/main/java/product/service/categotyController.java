package product.service;

import java.util.Collection;
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
public class categotyController {

    @Autowired
    private categotyRepository categotyRepository;

    // Select all categoty
    @GetMapping("/category")
    public Collection<categoty> getallcategoty() {
        return categotyRepository.findAll();
    }

    // Select categoty By ID
    @GetMapping("/categoty/{id}")
    public ResponseEntity getAllcategotyById(@PathVariable long ID) {
        Optional<categoty> optcategoty = categotyRepository.findById(ID);

        // check if id exists in db
        if (!optcategoty.isPresent()) {
            // return error message 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("category Not Found");

        }
        categoty emp = optcategoty.get();
        return ResponseEntity.ok(emp);
    }
    //Create method for position 
    @PostMapping("/category")
    public ResponseEntity createCategoty(@RequestBody categoty categoty){
        categotyRepository.save(categoty);
        return ResponseEntity.ok(categoty);
    }

    // update categoty
    @PutMapping("/category")
    public ResponseEntity<String> updateCategoty( @RequestBody categoty categoty) {

        //Can't find id to Update
        if(!categotyRepository.existsById(categoty.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("category id already exists");
        }

        // update categoty
        categotyRepository.save(categoty);

        // return success message
        return ResponseEntity.ok("category updated");
    }
    // Delete categoty
    @DeleteMapping("/category/{ID}")
    public ResponseEntity<String> deletecategoty(@PathVariable long ID) {

        //Can't find id to delete
        if(!categotyRepository.existsById(ID)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("category id Deleted");
        }

        // delete Products
        categotyRepository.deleteById(ID);

        // return success message
        return ResponseEntity.ok("categoty had Deleted");
    }
}