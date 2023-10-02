package product.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import product.service.domain.product;

public interface productRepository extends CrudRepository<product, Long>{
    List<product> findAll();
    List<product> findByName(String Name);
    List<product> findByNameStartingWith(String prefix);
}