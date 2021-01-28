package vn.techmaster.exam.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.exam.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student> findStudentById(Long id);
    void addStudent(Student student);
    
}
