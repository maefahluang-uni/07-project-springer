package product.service.productservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface productRepository extends JpaRepository<product, Long>{
    // public List<product> findAll();
    // // public List<product> findByName(String name);
    // List<product> findByNameStartingWith(String prefix);

}