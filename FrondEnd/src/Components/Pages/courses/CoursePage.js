// CoursePage.js
import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import './styling/coursePage.css';

const CoursePage = () => {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const courseName = searchParams.get('courseName');
    const courseCode = searchParams.get('courseCode');
    const role = sessionStorage.getItem("userRole");
  return (
    <div className="course-page">
        <h3 id='header'>{courseName} - {courseCode}</h3>
      <div id="content" >
          {role === 'tutor'? "": <><Link to={`/applications?courseName=${courseName}&courseCode=${courseCode}`} className="tile">
          <div className="tile-icon">📟</div>
          Applications
        </Link>
        <Link to={`/manageCourse?courseName=${courseName}&courseCode=${courseCode}`} className="tile">
          <div className="tile-icon">👨‍💼</div>
          Course & Tutors
        </Link></>}
        <Link to={`/tutorials?courseName=${courseName}&courseCode=${courseCode}`} className="tile">
          <div className="tile-icon">〽️</div>
          Tutorials
        </Link>
        {role === 'tutor'? "":<><Link to="https://lukhaya.github.io/mytutorapp/LiveSessions.html" className="tile">
          <div className="tile-icon">📹</div>
          Record Session
        </Link>
        <Link to="https://lukhaya.github.io/mytutorapp/stream.html" className="tile">
          <div className="tile-icon">✅</div>
          Check-In Tutors
        </Link></>}

        <Link to="/tutorials" className="tile">
          <div className="tile-icon">📜</div>
          Attendance
        </Link>
      </div>
    </div>
  );
};

export default CoursePage;

