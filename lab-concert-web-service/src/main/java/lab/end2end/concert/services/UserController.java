package lab.end2end.concert.services;

import java.util.List;
import java.util.Optional;

import lab.end2end.concert.domain.User; // Assuming User is your domain class

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Change the base URL mapping to /users
public class UserController { // Change the class name to UserController

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository; // Assuming UserRepository is your repository for User

    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable long id) { // Change method name to retrieveUser
        Optional<User> userOptional = userRepository.findById(id); // Change repository method to findById
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> retrieveAllUsers() { // Change method name to retrieveAllUsers
        List<User> users = userRepository.findAll(); // Change repository method to findAll
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) { // Change method name to createUser
        userRepository.save(user); // Change repository method to save
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user) { // Change method name to updateUser
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
    public ResponseEntity<String> partialUpdateUser(@PathVariable long id, @RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            userRepository.save(existingUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
