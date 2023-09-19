package lab.end2end.concert.services;

import java.util.List;
import java.util.Optional;

import lab.end2end.concert.domain.Customer; // Assuming User is your domain class

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer") // Change the base URL mapping to /users
public class CustomerController { // Change the class name to UserController

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository userRepository; // Assuming UserRepository is your repository for User

    @GetMapping("/{id}")
    public ResponseEntity<Customer> retrieveUser(@PathVariable long id) { // Change method name to retrieveUser
        Optional<Customer> userOptional = userRepository.findById(id); // Change repository method to findById
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> retrieveAllUsers() { // Change method name to retrieveAllUsers
        List<Customer> users = userRepository.findAll(); // Change repository method to findAll
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Customer user) { // Change method name to createUser
        userRepository.save(user); // Change repository method to save
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody Customer user) { // Change method name to updateUser
        if (userRepository.existsById(user.getId())) { // Change repository method to existsById
            userRepository.save(user); // Change repository method to save
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) { // Change method name to deleteUser
        if (userRepository.existsById(id)) { // Change repository method to existsById
            userRepository.deleteById(id); // Change repository method to deleteById
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() { // Change method name to deleteAllUsers
        userRepository.deleteAll(); // Change repository method to deleteAll
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}") // เพิ่มรูปแบบการกำหนดพารามิเตอร์ไอดีใน URL
    public ResponseEntity<String> partialUpdateUser(@PathVariable long id, @RequestBody Customer user) {
        Optional<Customer> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            Customer existingUser = userOptional.get();

            if (user.getFirstName() != null) {
                existingUser.setFirstName(user.getFirstName());
            }
            userRepository.save(existingUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
