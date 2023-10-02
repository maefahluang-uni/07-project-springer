package product.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface categotyRepository extends CrudRepository<categoty, Long>{
    public List<categoty> findAll();
}