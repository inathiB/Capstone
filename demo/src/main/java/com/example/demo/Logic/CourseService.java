package com.example.demo.Logic;
import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Collection.Tutor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
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

            if(actualCourse.getCourseConveners()==null ){
                actualCourse.setCourseConveners(new ArrayList<>());}

            if(!actualCourse.getCourseConveners().contains(courseConvener)){
            actualCourse.getCourseConveners().add(courseConvener);}
            else{
                System.out.println("Course Convener already added");
            }

       }else{System.out.println("Course not found");}
    }
    public void removeCourseConvener(String courseCode, CourseConvener courseConvener){
        Optional <Course> course = courseRepository.findCourseByCourseCode(courseCode);
        if(course.isPresent()){
            Course actualCourse = course.get();
            if(actualCourse.getCourseConveners()==null){
                actualCourse.setCourseConveners(new ArrayList<>());

            System.out.println("Course hase no Course convener");
            }
            actualCourse.getCourseConveners().remove(courseConvener);
        }else{
            System.out.println("Course not found");
        }
    }
    public List<CourseConvener> getCourseConvener(String courseCode){
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
}




