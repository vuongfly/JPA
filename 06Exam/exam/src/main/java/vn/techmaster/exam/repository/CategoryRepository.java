package vn.techmaster.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.exam.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
