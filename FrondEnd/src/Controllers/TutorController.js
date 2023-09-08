import Tutor from "../Models/Class files/Tutor";

export default class TutorController {
    constructor() {
        this.tutors = [];
    }

    // Create a new tutor and add it to the list
    createTutor(studentId, name, email, phone, marks) {
        const newTutor = new Tutor(studentId, name, email, phone, marks);
        this.tutors.push(newTutor);
        return newTutor;
    }

    // Get a specific tutor by student ID
    getTutorByStudentId(studentId) {
        return this.tutors.find((tutor) => tutor.studentId === studentId);
    }

    // Update tutor information
    updateTutor(studentId, updatedTutor) {
        const tutorIndex = this.tutors.findIndex((tutor) => tutor.studentId === studentId);
        if (tutorIndex !== -1) {
            this.tutors[tutorIndex] = updatedTutor;
            return updatedTutor;
        }
        return null; // Tutor not found
    }

    // Delete a tutor by student ID
    deleteTutor(studentId) {
        const tutorIndex = this.tutors.findIndex((tutor) => tutor.studentId === studentId);
        if (tutorIndex !== -1) {
            this.tutors.splice(tutorIndex, 1);
            return true; // Tutor deleted
        }
        return false; // Tutor not found
    }

    // Get all tutors
    getAllTutors() {
        return this.tutors;
    }
}


