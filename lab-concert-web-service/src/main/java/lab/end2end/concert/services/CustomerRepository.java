package lab.end2end.concert.services;

import lab.end2end.concert.domain.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();

}
