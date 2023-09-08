import Application from "../Models/Class files/Application";
export default class ApplicationController {
    constructor() {
        this.applications = [new Application(
            "1",
            "Application 1 details...",
            "Department of Computer Science",
            "2023-09-30",
            "http://localhost:3000/applications/accessapplications?id=1"
        ),
        new Application(
            "2",
            "Application 2 details...",
            "Department of Information Systems",
            "2023-10-15",
            "http://localhost:3000/applications/accessapplications?id=2"
        ),
        new Application(
            "3",
            "Application 3 details...",
            "Department of Computer Science",
            "2023-10-10",
            "http://localhost:3000/applications/accessapplications?id=3"
        ),
        new Application(
            "4",
            "Application 4 details...",
            "Department of Computer Science",
            "2023-09-25",
            "http://localhost:3000/applications/accessapplications?id=4"
        ),];
    }

    // Create a new application and add it to the list
    createApplication(applicationId, details, department, dueDate, accessLink) {
        const newApplication = new Application(applicationId,details, department, dueDate, accessLink);
        this.applications.push(newApplication);
        return newApplication;
    }

    // Get a specific application by ID
    getApplicationById(applicationId) {
        return this.applications.find((app) => app.applicationId === applicationId);
    }

    // Delete an application by ID
    deleteApplication(applicationId) {
        const index = this.applications.findIndex((app) => app.applicationId === applicationId);
        if (index !== -1) {
            this.applications.splice(index, 1);
            return true; // Application deleted
        }

        return false; // Application not found
    }

    // Get all applications
    getAllApplications() {
        return this.applications;
    }
}
