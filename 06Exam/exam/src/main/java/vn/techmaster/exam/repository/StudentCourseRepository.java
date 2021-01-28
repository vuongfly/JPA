package vn.techmaster.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.exam.model.Course;
import vn.techmaster.exam.model.Student;
import vn.techmaster.exam.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    List<StudentCourse> findStudentCoursesByCourses(Course course);
    List<StudentCourse> findStudentCoursesByStudents(Student student);
    void addStudentCourse(Student student, Course course);
}
