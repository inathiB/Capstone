package com.example.demo.Logic;

import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Collection.Tutor;
import com.example.demo.Email.EmailService;
import com.example.demo.Repository.CourseRepository;
import jakarta.mail.MessagingException;
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
    private final EmailService emailService;
    public Course getCourse(String id){
        Optional<Course> optionalCourse = courseRepository.findCourseByCourseCode(id);

        return optionalCourse.orElse(null);
    }
    public List<Course>getAllCourses(){
        return courseRepository.findAll();
    }
    public void addCourse (Course course) throws MessagingException {
        courseRepository.insert(course);
    }
    public void deleteCourse(String courseID){
        courseRepository.deleteById(courseID);
    }
    public void addCourseConvener(String courseCode, String courseConvener) throws MessagingException {
       Optional <Course>  course = courseRepository.findCourseByCourseCode(courseCode);
       if(course.isPresent()){
           Course actualCourse = course.get();
           actualCourse.setCourseConvener(String.valueOf(courseConvener));
           courseRepository.save(actualCourse);
           emailService.sendAdditionCourseconvener(course,courseConvener);


       }else{System.out.println("Course not found");}
    }
    /*public List<CourseConvener> getCourseConvener(String courseCode){
        return courseRepository.findCourseConvenerByCourseCode(courseCode);
    } /*Not sure if this will be necessary*/
    public void addTutor(String courseCode, Tutor tutor) throws MessagingException {
       Optional<Course> course =  courseRepository.findCourseByCourseCode(courseCode);
       if(course.isPresent()){
           Course course1 = course.get();

           if(course1.getTutors()==null){
               course1.setTutors(new ArrayList<>());
           }
           if(!course1.getTutors().contains(tutor)){
               course1.getTutors().add(tutor);
               courseRepository.save(course1);
               System.out.println("added tutor");
           }

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

    public Optional<Course> updateCourse(String courseCode, Course updatedCourse) {
        Optional<Course> existingCourse = courseRepository.findCourseByCourseCode(courseCode);

        if (existingCourse.isPresent()) {
            Course courseToUpdate = existingCourse.get();
            courseToUpdate.setCourseName(updatedCourse.getCourseName());
            courseToUpdate.setTutors(updatedCourse.getTutors());
            courseToUpdate.setDuration(updatedCourse.getDuration());
            courseToUpdate.setYear(updatedCourse.getYear());
            courseToUpdate.setCreator(updatedCourse.getCreator());
            courseToUpdate.setTA(updatedCourse.getTA());

            courseRepository.save(courseToUpdate);
        }

        return existingCourse;
    }


    public void updateCourseConvener(String courseCode, String courseConvener) {
        Optional<Course> course = courseRepository.findCourseByCourseCode(courseCode);
        if(course.isPresent()){
            Course course1 = course.get();
            course1.setCourseConvener(String.valueOf(courseConvener));

        }
    }
}




