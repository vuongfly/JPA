package vn.techmaster.exam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.exam.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    Optional<Course> findCourseById(Long id);
    void addCourse(Course course);
}
