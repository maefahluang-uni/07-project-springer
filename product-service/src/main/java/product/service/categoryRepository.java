package product.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<category, Long>{
    // public List<categoty> findAll();
}