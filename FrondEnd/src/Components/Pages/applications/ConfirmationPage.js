import React from 'react';
import './styling/ConfirmationPage.css'
import ApplicationSubmissionController from '../../../Controllers/ApplicationSubmissionController';

const ConfirmationPage = ({ formData }) => {
    const applicationSubmissionController = new ApplicationSubmissionController();

    // Extract relevant student details from formData
    const studentDetails = `
        Student Number: ${formData.studNo}
        Name: ${formData.name}
        Surname: ${formData.surname}
        Email: ${formData.email}
        Year of Study: ${formData.yearOfStudy}
        Course History:
        ${formData.courses.map((course, index) => `
            Course ${index + 1}:
            Course Name: ${course.course}
            Mark: ${course.mark}%
        `).join('')}
    `;

    // Department is equivalent to the course in this context
    const department = formData.course;

    // Create an application submission
    const submission = applicationSubmissionController.createSubmission(
        studentDetails,
        department
    );

    console.log(submission);
    return (
        <div className="confirmation-container">
            <h2 className="confirmation-title">Thank you, your form was submitted!</h2>
            <div className="confirmation-details">
                <p><strong>Student Number:</strong> {formData.studNo}</p>
                <p><strong>Name:</strong> {formData.name}</p>
                <p><strong>Surname:</strong> {formData.surname}</p>
                <p><strong>Email:</strong> {formData.email}</p>
                <p><strong>Course:</strong> {formData.course}</p>
                <p><strong>Year of Study:</strong> {formData.yearOfStudy}</p>
            </div>
            <p className="course-history-title">Course history:</p>
            <ul className="course-list">
                {formData.courses.map((course, index) => (
                    <li key={index} className="course-item">
                        <strong>Course Name:</strong> {course.course}, <strong>Mark:</strong> {course.mark}%
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ConfirmationPage;

