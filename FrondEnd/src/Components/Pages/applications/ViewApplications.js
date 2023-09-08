import React, { useState, useEffect } from 'react';
import './styling/ViewApplications.css';
import ApplicationController from '../../../Controllers/ApplicationController';

const ViewApplications = () => {
    const [applications, setApplications] = useState([]);
    const [editingApplication, setEditingApplication] = useState(null);

    useEffect(() => {
        const applicationController = new ApplicationController();
        const fetchedApplications = applicationController.getAllApplications();
        setApplications(fetchedApplications);
    }, []);

    const handleEdit = (application) => {
        setEditingApplication(application);
    };

    const handleRemove = (applicationId) => {
        if (window.confirm('Are you sure you want to remove this application?')) {
            const applicationController = new ApplicationController();
            const removed = applicationController.deleteApplication(applicationId);

            if (removed) {
                const updatedApplications = applications.filter((app) => app.applicationId !== applicationId);
                setApplications(updatedApplications);
            }
        }
    };

    const handleSaveEdit = () => {
        if (editingApplication) {
            const applicationController = new ApplicationController();
            const updatedApplication = applicationController.updateApplication(editingApplication);

            if (updatedApplication) {
                const updatedApplications = applications.map((app) =>
                    app.applicationId === editingApplication.applicationId ? editingApplication : app
                );
                setApplications(updatedApplications);
                setEditingApplication(null);
            }
        }
    };

    return (
        <div className="view-applications-container">
            <h2>View Applications</h2>
            <table className="applications-table">
                <thead>
                    <tr>
                        <th>Application ID</th>
                        <th>Description</th>
                        <th>Department</th>
                        <th>Closing Date</th>
                        <th>Access Link</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {applications.map((application) => (
                        <tr key={application.applicationId}>
                            <td>{application.applicationId}</td>
                            <td>{application.details}</td>
                            <td>{application.department}</td>
                            <td>{application.dueDate}</td>
                            <td>
                                <a href={application.accessLink} target="_blank" rel="noopener noreferrer">
                                    Access Link
                                </a>
                            </td>
                            <td>
                                {editingApplication && editingApplication.applicationId === application.applicationId ? (
                                    <>
                                        <button onClick={handleSaveEdit}>Save</button>
                                    </>
                                ) : (
                                    <>
                                        <button onClick={() => handleEdit(application)}>Edit</button>
                                        <button onClick={() => handleRemove(application.applicationId)}>Remove</button>
                                    </>
                                )}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ViewApplications;
