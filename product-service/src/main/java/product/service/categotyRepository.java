package product.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface categotyRepository extends JpaRepository<categoty, Long>{
    // public List<categoty> findAll();
}