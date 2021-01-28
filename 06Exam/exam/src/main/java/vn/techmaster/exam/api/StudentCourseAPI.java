package vn.techmaster.exam.api;

import java.util.List;
import java.util.Map;

import vn.techmaster.exam.model.Course;
import vn.techmaster.exam.model.Student;
import vn.techmaster.exam.model.StudentCourse;

public interface StudentCourseAPI {
    Map<String, List<Student>> findStudentByCourse(Course course);
}
