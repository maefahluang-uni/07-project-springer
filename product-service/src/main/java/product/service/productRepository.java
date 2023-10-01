package product.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface productRepository extends CrudRepository<product, Long>{
    public List<product> findAll();
    public List<product> findByName(String Name);
    List<product> findByNameStartingWith(String prefix);
}