package vn.techmaster.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.exam.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
