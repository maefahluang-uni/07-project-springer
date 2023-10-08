package user.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Collection;


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
public class UserController {

@Autowired
private UserRepository userRepository;




    @GetMapping("/users")
    public Collection<User> getallUsers() {
return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUserByUsername(@PathVariable long id) {
       Optional <User> optuser = userRepository.findById(id);
        if (!optuser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        } 

        User user = optuser.get();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
       userRepository.save(user);
          return ResponseEntity.ok("User Created");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteIser(@PathVariable long id) {

        //Can't find id to delete
        if(!userRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User id Deleted");
        }

        // delete Products
       userRepository.deleteById(id);

        // return success message
        return ResponseEntity.ok("User had Deleted");
    }
    @PutMapping("/users")
    public ResponseEntity<String> updateUser( @RequestBody User user) {
        //Can't find id to Update
        if(!userRepository.existsById(user.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User id already exists");
        }
        // update Products
        userRepository.save(user);

        // return success message
        return ResponseEntity.ok("USer updated");
    }
    // Delete Products*****
    
    

}