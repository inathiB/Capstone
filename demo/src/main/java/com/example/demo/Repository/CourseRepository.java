package com.example.demo.Repository;
import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
/*Talks to DB*/
public interface CourseRepository extends MongoRepository<Course,String> {
Optional<Course> findCourseByCourseCode(String courseCode);
    @Query("{'courseCode': ?0}")
    List<CourseConvener> findCourseConvenerByCourseCode(String courseCode);




}
