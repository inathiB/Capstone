package com.example.demo.Controllers;
import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Logic.CourseService;
import com.example.demo.Collection.Tutor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*API*/
@RestController
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> fetchAllCourses(){
        return courseService.getAllCourses();}

    @GetMapping("/course{id}")
    public Course getCourse(@ PathVariable String id) {
        return courseService.getCourse(id);}

    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);}

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);}

    /*Add a Course Convener to a course*/
    @PutMapping("/addCourseConvener")
    public void addCourseConvener(
            @RequestParam("courseCode") String courseCode,
            @RequestBody CourseConvener courseConvener ){
            courseService.addCourseConvener(courseCode, courseConvener);}

    @PutMapping("/removeCourseConvener")
    public void removeCourseConvener(
            @RequestParam ("courseCode") String courseCode,
            @RequestBody CourseConvener courseConvener){
            courseService.removeCourseConvener(courseCode,courseConvener);}

    @PutMapping("/addTutor")
    public void addTutor(
            @RequestParam ("courseCode") String courseCode,
            @RequestBody Tutor tutor){
                courseService.addTutor(courseCode,tutor);}

    @PutMapping("/removeTutor")
    public void removeTutor(
            @RequestParam("courseCode") String courseCode,
            @RequestBody Tutor tutor){
            courseService.removeTutor(courseCode, tutor);}
}
