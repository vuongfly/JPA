package vn.techmaster.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import vn.techmaster.exam.model.Student;
import vn.techmaster.exam.model.Course;
import vn.techmaster.exam.model.StudentCourse;
import vn.techmaster.exam.repository.CategoryRepository;
import vn.techmaster.exam.repository.StudentCourseRepository;
import vn.techmaster.exam.repository.StudentRepository;
import vn.techmaster.exam.service.CategoryService;
import vn.techmaster.exam.service.CourseService;
import vn.techmaster.exam.service.StudentCourseService;
import vn.techmaster.exam.service.StudentService;

@DataJpaTest
@Sql({ "classpath:sql/student.sql", "classpath:sql/course.sql", "classpath:sql/student_course.sql"  })
// @Sql("classpath:sql/student.sql")
// @Sql("classpath:sql/course.sql")
// @Sql("classpath:sql/student_course.sql")
public class StudentCourseTest {
    @Autowired private StudentCourseRepository scRepo;
    @Autowired private StudentRepository studentRepo;
    // @Autowired StudentCourseService studentCourseSv;
    

    // @Test
    // public void testFindStudentCoursesByCourses() {

    // }

    @Test
    public void testFindStudentById() {
        Student s = studentRepo.findStudentById((long) 1).get();
        List<Student> studentList = studentRepo.findAll();
        System.out.println(s.toString());
        assertThat(s.getId()).isEqualTo(1);
    }

    @Test
    public void testListAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        System.out.println(studentList.toString());
        assertThat(studentList).hasSizeGreaterThan(3);
    }

    // @Test
    // public void testFindCourseById() {

    // }
}
