package lab.end2end.concert.services;

import java.util.List;
import java.util.Optional;

import lab.end2end.concert.domain.Concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concerts") // Base URL mapping for all endpoints
public class ConcertController {

    private static Logger LOGGER = LoggerFactory.getLogger(ConcertController.class);

    @Autowired
    private ConcertRepository concertRepository; // Autowire the repository

    @GetMapping("/{id}")
    public ResponseEntity<Concert> retrieveConcert(@PathVariable long id) {
        Optional<Concert> concertOptional = concertRepository.findById(id);
        if (concertOptional.isPresent()) {
            return new ResponseEntity<>(concertOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Concert>> retrieveAllConcert() {
        List<Concert> concerts = concertRepository.findAll();
        return new ResponseEntity<>(concerts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createConcert(@RequestBody Concert concert) {
        concertRepository.save(concert);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateConcert(@RequestBody Concert concert) {
        if (concertRepository.existsById(concert.getId())) {
            concertRepository.save(concert);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConcert(@PathVariable long id) {
        if (concertRepository.existsById(id)) {
            concertRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllConcerts() {
        concertRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
