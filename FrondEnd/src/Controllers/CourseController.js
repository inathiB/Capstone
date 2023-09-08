import Course from "../Models/Class files/Course";
export default class CourseController{
    constructor(){
        this.courses = [];
    }

    loadCourses(){
        this.courses = [
            new Course("Computer Science 3","CSC3003S","July - November","2023","Jenete Amahle"),
            new Course("Machine Learning", "ML101", "September - December","2023","Maria Rodriguez"),
            new Course("Information Systems 2","INF2011S","June - October", "2023","John Smith")
          ];

        return this.courses;
    }

    updateCourses(courses){
        this.courses = courses;
    }

    addCourse(course){
        this.courses.push(course);
    }
    getCourse(courseCode){
        return this.courses.find((course)=> course.courseCode === courseCode);
    }
    removeCourse(courseCode){
        //Method to remove course
    }
}