package vn.techmaster.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.exam.api.StudentAPI;
import vn.techmaster.exam.model.Student;
import vn.techmaster.exam.repository.StudentRepository;

@Service
public class StudentService implements StudentAPI {
    
    @Autowired
    StudentRepository studentRepo;

    @Override
    public Student findStudentById(Long id) {
        // TODO Auto-generated method stub
        // studentRepo.findStudentById(id).get();
        return studentRepo.findStudentById(id).get();
    }
    
}
