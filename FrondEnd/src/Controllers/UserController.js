import User from "../Models/Class files/User";

export default class UserController {
    constructor() {
        this.users = [];
    }

    loadUsers() {
        // Load users from the database
        this.users = [
            new User("JNTAMA001", "123", 'tutor'),
            new User("Admin", "123", 'admin'),
            new User("1234", "123", 'admin')
        ];
    }

    getUsersInorder(order) {
        switch (order) {
            case 'ascending':
                return this.users.slice().sort((a, b) => a.username.localeCompare(b.username));
            case 'descending':
                return this.users.slice().sort((a, b) => b.username.localeCompare(a.username));
            default:
                return [...this.users];
        }
    }

    userExists(username) {
        return this.users.some(user => user.username === username);
    }

    findUser(username) {
        return this.users.find(user => user.username === username);
    }
}
