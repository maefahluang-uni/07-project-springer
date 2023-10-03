package product.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Long>{
    // List<product> findByNameStartingWith(String prefix);

    // @Query("SELECT p FROM product p WHERE p.name LIKE :namePrefix")
    
    // CriteriaQuery<product> findAllNameStartingWith(@Param("namePrefix") String namePrefix);


}