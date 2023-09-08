import React, { useState, useEffect } from 'react'; // Import useEffect
import Course from './Course'; 
import './styling/courses.css';
import AddCourse from "./AddCourse";
import { Link } from 'react-router-dom';
import CourseController from '../../../Controllers/CourseController';

const CourseTabs = () => {
  

  // Use useState to store the courses
  const [courses, setCourses] = useState([]);

  // Use useEffect to load courses when the component mounts
  useEffect(() => {
    const courseController = new CourseController();
    const loadedCourses = courseController.loadCourses();
    setCourses(loadedCourses);
  }, []);

  const [showForm, setShowForm] = useState(false);
  const role = sessionStorage.getItem("userRole");

  return (
    <div className="course-section">
      <div className="course-header">
        <h1>Your Courses</h1>
        {role === 'tutor'? "": <button className="manage-button" style={{ display: showForm ? 'none' : '' }} onClick={() => setShowForm(true)}>+ Add course</button>}
      </div>
      <div className="course-tabs">
        {courses.map(course => (
          <Link key={course.courseCode} to={`/coursePage?courseName=${course.courseName}&courseCode=${course.courseCode}`}>
            <Course courseinfo={course} />
          </Link>
        ))}
      </div>
      <div>
        {showForm ?  <AddCourse setCourses={setCourses} courses={courses} setShowForm={setShowForm}/> : ""}
      </div>
    </div>
  );
};

export default CourseTabs;



