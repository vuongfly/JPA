package vn.techmaster.exam.model;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Entity(name="course")
@Table(name="course")
@Data
public class Course {
  @Id
  private long id;

  private String name;

  @OneToMany(mappedBy = "courses")
  Set<StudentCourse> studentCourses;
}
