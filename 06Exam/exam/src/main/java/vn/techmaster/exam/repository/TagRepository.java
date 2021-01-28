package vn.techmaster.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.exam.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    
}
