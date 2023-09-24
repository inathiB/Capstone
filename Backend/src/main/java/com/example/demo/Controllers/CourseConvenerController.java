package com.example.demo.Controllers;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Logic.CourseConvenerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*API*/
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/courseConvener")
@AllArgsConstructor

public class CourseConvenerController {
    private final CourseConvenerService courseConvenerService;
    @GetMapping
    public List<CourseConvener> fetchAllCourseConveners(){
        return courseConvenerService.getAllCourseConveners();}

    @GetMapping("/{id}")
    public CourseConvener getCourseConvener(@PathVariable String id) {
        return courseConvenerService.getCourseConvener(id);}

    @PostMapping
    public void addCourseConvener(@RequestBody CourseConvener course){
        courseConvenerService.addCourseConvener(course);}

    @DeleteMapping("/{id}")
    public String deleteCourseConvener(@PathVariable String id){
        courseConvenerService.deleteCourseConvener(id);return "success";}

    /*Add a CourseConvener Convener to a course*/
    @PutMapping("/updateCourseConvened")
    public void changeCourse(
            @RequestParam("courseCode") String courseCode,
            @RequestBody CourseConvener courseConvener ){
        courseConvenerService.updateCourseConvened(courseCode, courseConvener);}




    @PutMapping("/updateCourseConvener")
    public void updateCourseConvener(
            @RequestParam("courseCode") String courseCode,
            @RequestBody CourseConvener course ){
            courseConvenerService.updateCourseConvener(courseCode, course);}



}


