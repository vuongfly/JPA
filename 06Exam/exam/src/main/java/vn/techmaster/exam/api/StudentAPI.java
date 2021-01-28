package vn.techmaster.exam.api;

import java.util.List;

import vn.techmaster.exam.model.Student;
import vn.techmaster.exam.repository.StudentRepository;

public interface StudentAPI {
    public Student findStudentById(Long id);
}
