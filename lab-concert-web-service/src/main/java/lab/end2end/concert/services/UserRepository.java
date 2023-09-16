package lab.end2end.concert.services;

import lab.end2end.concert.domain.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

}
