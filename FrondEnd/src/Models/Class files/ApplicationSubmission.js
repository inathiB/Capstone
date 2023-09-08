class ApplicationSubmission {
    constructor(studentDetails, dateSubmitted, department) {
        this.id = this.generateRandomId();
        this.studentDetails = studentDetails;
        this.dateSubmitted = dateSubmitted;
        this.department = department;
    }

    // Generate a random alphanumeric ID
    generateRandomId() {
        const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        const idLength = 10;
        let randomId = '';

        for (let i = 0; i < idLength; i++) {
            const randomIndex = Math.floor(Math.random() * characters.length);
            randomId += characters.charAt(randomIndex);
        }

        return randomId;
    }
}

export default ApplicationSubmission;
