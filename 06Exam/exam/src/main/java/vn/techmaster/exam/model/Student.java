package vn.techmaster.exam.model;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Entity(name="student")
@Table(name="student")
@Data
public class Student {
  @Id
  private long id;

  private String name;

  @OneToMany(mappedBy = "students")
  Set<StudentCourse> studentCourses;
  
}
