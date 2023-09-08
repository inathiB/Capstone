import ApplicationSubmission from '../Models/Class files/ApplicationSubmission';

class ApplicationSubmissionController {
    constructor() {
        this.submissions = [new ApplicationSubmission(
            "Kwame Nkrumah - KKN001",
            new Date("2023-09-15"),
            "Computer Science"
        ),
        new ApplicationSubmission(
            "Nelson Mandela - MAN001",
            new Date("2023-09-20"),
            "Chemistry"
        ),
        new ApplicationSubmission(
            "Wangari Maathai MAW002",
            new Date("2023-09-25"),
            "Physics"
        ),
        new ApplicationSubmission(
            "Chinua Achebe  ACC002",
            new Date("2023-09-30"),
            "Mathematics"
        ),];
    }

    // Create a new application submission
    createSubmission(studentDetails, department) {
        const dateSubmitted = new Date();
        const submission = new ApplicationSubmission(studentDetails, dateSubmitted, department);
        this.submissions.push(submission);
        return submission;
    }

    // Get all application submissions
    getAllSubmissions() {
        return this.submissions;
    }
}

export default ApplicationSubmissionController;
