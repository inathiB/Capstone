package com.example.demo.Controllers;

import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Collection.Tutor;
import com.example.demo.Logic.CourseService;
import com.example.demo.Logic.UserService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*API*/
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;

    @GetMapping
    public List<Course> fetchAllCourses(){
        return courseService.getAllCourses();}

    @GetMapping("/{id}")
    public Course getCourse(@ PathVariable String id) {
        return courseService.getCourse(id);}

    @PostMapping
    public void addCourse(@RequestBody Course course) throws MessagingException {
        courseService.addCourse(course);}

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);return "success";}

    /*Add a Course Convener to a course*/
    @PutMapping("/addCourseConvener")
    public void addCourseConvener(
            @RequestParam("courseCode") String courseCode,
            @RequestBody String courseConvener ) throws MessagingException {
            courseService.addCourseConvener(courseCode, courseConvener);}

    @PutMapping("/updateCourseConvener")
    public void updateCourseConvener(
            @RequestParam ("courseCode") String courseCode,
            @RequestBody String courseConvener){
            courseService.updateCourseConvener(courseCode,courseConvener);}

    @PutMapping("/addTutor")
    public void addTutor(
            @RequestParam ("courseCode") String courseCode,
            @RequestBody Tutor tutor) throws MessagingException {
             userService.makeRoleTutor(tutor.getEmail());
             courseService.addTutor(courseCode,tutor);
    }

    @PutMapping("/removeTutor")
    public void removeTutor(
            @RequestParam("courseCode") String courseCode,
            @RequestBody Tutor tutor){
            courseService.removeTutor(courseCode, tutor);}

    @PutMapping("/updateCourse")
    public Optional<Course> updateCourse(
            @RequestParam("courseCode") String courseCode,
            @RequestBody Course course ){
        return courseService.updateCourse(courseCode, course);}


}
