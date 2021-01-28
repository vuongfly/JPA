package vn.techmaster.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.exam.api.StudentCourseAPI;
import vn.techmaster.exam.model.Course;
import vn.techmaster.exam.model.Student;
import vn.techmaster.exam.model.StudentCourse;
import vn.techmaster.exam.repository.StudentCourseRepository;

@Service
public class StudentCourseService implements StudentCourseAPI {
    @Autowired
    private StudentCourseRepository scRepo;

    @Override
    public Map<String, List<Student>> findStudentByCourse(Course course) {
        // TODO Auto-generated method stub
        List<StudentCourse> lStudentCourses = scRepo.findStudentCoursesByCourses(course);
        System.out.println(lStudentCourses); 
        return null;
    }
}
