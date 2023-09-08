import React, { useState } from 'react';
import './styling/ViewApplicationSubmissions.css'; // Updated CSS file name
import ApplicationSubmissionController from '../../../Controllers/ApplicationSubmissionController';

const ViewApplicationSubmissions = () => {
    const [submissions, setSubmissions] = useState([]);
    const submissionController = new ApplicationSubmissionController();

    // Function to load application submissions
    const loadSubmissions = () => {
        const allSubmissions = submissionController.getAllSubmissions();
        setSubmissions(allSubmissions);
    };

    return (
        <div className="view-application-submissions-container">
            <h2 className="view-application-submissions-title">View Application Submissions</h2>
            <table>
                <thead>
                    <tr>
                        <th>Student Details</th>
                        <th>Date Submitted</th>
                        <th>Department</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {submissions.map((submission, index) => (
                        <tr key={index}>
                            <td>{submission.studentDetails}</td>
                            <td>{submission.dateSubmitted.toLocaleString()}</td>
                            <td>{submission.department}</td>
                            <td>
                                <button className="approve">Approve</button>
                                <button className="decline">Decline</button>
                                <button className="hide">Hide</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <button className="view-submissions-button" onClick={loadSubmissions}>
                Load Submissions
            </button>
        </div>
    );
};

export default ViewApplicationSubmissions;
