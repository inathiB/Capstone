import React, { useState } from 'react';
import './styling/manageCourse.css'
import CourseController from '../../../Controllers/CourseController';
import { useLocation } from 'react-router-dom';

const ManageCourse = () => {
  //Get course from url
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const courseNameParam = searchParams.get('courseName');
  const courseCodeParam = searchParams.get('courseCode');

  //Search course from backend
  const courseController = new CourseController();
  courseController.loadCourses();
  let courseinfo = courseController.getCourse(courseCodeParam);
 
  const [courseName, setCourseName] = useState(courseinfo.courseName);
  const [courseCode, setCourseCode] = useState(courseinfo.courseCode);
  const [duration, setDuration] = useState(courseinfo.duration);
  const [year, setYear] = useState(courseinfo.year);
  const [creator, setCreator] = useState(courseinfo.creator);
  const [tutors, setTutors] = useState(courseinfo.tutors);

  const handleTutorChange = (e, index) => {
    const updatedTutors = [...tutors];
    updatedTutors[index] = e.target.value;
    setTutors(updatedTutors);
  };

  const handleAddTutor = () => {
    setTutors([...tutors, '']);
  };

  const handleRemoveTutor = (index) => {
    const updatedTutors = [...tutors];
    updatedTutors.splice(index, 1);
    setTutors(updatedTutors);
  };

  const handleUpdateCourse = () => {
    // Perform the update action here, using the updated state values
  };

  return (
    <div className="manage-course">
      <h2>Manage Course - {courseNameParam}</h2>
      <label>
        Course Name:
        <input
          type="text"
          value={courseName}
          onChange={(e) => setCourseName(e.target.value)}
        />
      </label>
      <label>
        Course Code:
        <input
          type="text"
          value={courseCode}
          onChange={(e) => setCourseCode(e.target.value)}
        />
      </label>
      <label>
        Duration:
        <input
          type="text"
          value={duration}
          onChange={(e) => setDuration(e.target.value)}
        />
      </label>
      <label>
        Year:
        <input
          type="text"
          value={year}
          onChange={(e) => setYear(e.target.value)}
        />
      </label>
      <label>
        Creator:
        <input
          type="text"
          value={creator}
          onChange={(e) => setCreator(e.target.value)}
        />
      </label>
      <h3>Tutors/Participants:</h3>
      {tutors.map((tutor, index) => (
        <div key={index}>
          <input
            type="text"
            value={tutor}
            onChange={(e) => handleTutorChange(e, index)}
          />
          <button onClick={() => handleRemoveTutor(index)}>Remove</button>
        </div>
      ))}
      <button onClick={handleAddTutor} className='tutor-button'>Add Tutor</button>
      <button onClick={handleUpdateCourse} className='tutor-button'>Update Course</button>
    </div>
  );
};

export default ManageCourse;

