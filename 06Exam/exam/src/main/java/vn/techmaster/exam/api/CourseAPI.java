package vn.techmaster.exam.api;

import vn.techmaster.exam.model.Course;

public interface CourseAPI {
    public Course findCourseById(Long id);
}
