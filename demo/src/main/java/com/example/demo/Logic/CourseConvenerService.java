package com.example.demo.Logic;

import com.example.demo.Collection.CourseConvener;
import com.example.demo.Repository.CourseConvenerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseConvenerService {
 private final CourseConvenerRepository courseConvenerRepository;

    public CourseConvenerService(CourseConvenerRepository courseConvenerRepository) {
        this.courseConvenerRepository = courseConvenerRepository;
    }

    public List<CourseConvener> getAllCourseConveners() {
        return  courseConvenerRepository.findAll();
    }

    public CourseConvener getCourseConvener(String employeeID) {
       Optional<CourseConvener> optionalCourseConvener = courseConvenerRepository.findCourseConvenerByEmployeeID(employeeID);
       return optionalCourseConvener.orElse(null);
    }

    public void addCourseConvener(CourseConvener courseConvener) {
       courseConvenerRepository.insert(courseConvener);
    }

    public void deleteCourseConvener(String employeeID) {
       Optional<CourseConvener> optionalCourseConvener = courseConvenerRepository.findCourseConvenerByEmployeeID(employeeID);
       if(optionalCourseConvener.isPresent()){
          courseConvenerRepository.deleteById(employeeID);
       }
       }


    public void updateCourseConvener(String courseCode, CourseConvener course) {
    }

    public void updateCourseConvened(String courseCode, CourseConvener courseConvener) {

    }
}
