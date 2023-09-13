package com.example.demo.Logic;

import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Collection.Tutor;
import com.example.demo.Repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
/*Service Layer Business Logic*/
public class CourseService {
    private final CourseRepository courseRepository;
    public Course getCourse(String id){
        Optional<Course> optionalCourse = courseRepository.findCourseByCourseCode(id);

        return optionalCourse.orElse(null);
    }
    public List<Course>getAllCourses(){
        return courseRepository.findAll();
    }
    public void addCourse (Course course){
        courseRepository.insert(course);
    }
    public void deleteCourse(String courseID){
        courseRepository.deleteById(courseID);
    }
    public void addCourseConvener(String courseCode, CourseConvener courseConvener) {
       Optional <Course>  course = courseRepository.findCourseByCourseCode(courseCode);
       if(course.isPresent()){
           Course actualCourse = course.get();
           actualCourse.setCourseConvener(courseConvener);


       }else{System.out.println("Course not found");}
    }
    /*public List<CourseConvener> getCourseConvener(String courseCode){
        return courseRepository.findCourseConvenerByCourseCode(courseCode);
    } /*Not sure if this will be necessary*/
    public void addTutor(String courseCode, Tutor tutor){
       Optional<Course> course =  courseRepository.findCourseByCourseCode(courseCode);
       if(course.isPresent()){
           Course course1 = course.get();

           if(course1.getTutors()==null){
               course1.setTutors(new ArrayList<>());
           }
           course1.getTutors().add(tutor);
       }else{
           System.out.println("Course not Found");
       }


    }
    public void removeTutor(String courseCode, Tutor tutor){
        Optional <Course> course = courseRepository.findCourseByCourseCode(courseCode);
        if(course.isPresent()){
            Course actualCourse = course.get();
            if(actualCourse.getTutors()==null){
               actualCourse.setTutors(new ArrayList<>());
                System.out.println("Course Has no Tutors");
            }
            actualCourse.getTutors().remove(tutor);
        }else{
            System.out.println("Course not found");
        }
    }

    public Optional<Course> updateCourse(String courseCode, Course course) {
        Optional<Course> course1 = courseRepository.findCourseByCourseCode(courseCode);
       if(course1.isPresent()){
           courseRepository.deleteById(courseCode);
           courseRepository.insert(course);
       }
       return courseRepository.findCourseByCourseCode(courseCode);
    }

    public void updateCourseConvener(String courseCode, CourseConvener courseConvener) {
        Optional<Course> course = courseRepository.findCourseByCourseCode(courseCode);
        if(course.isPresent()){
            Course course1 = course.get();
            course1.setCourseConvener(courseConvener);

        }
    }
}




