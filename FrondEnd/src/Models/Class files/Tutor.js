import User from './User'

export default class Tutor extends User{
    constructor(username, password, studentId, name, email, phone, marks) {
      super(username, password, 'tutor');
      this.studentId = studentId;
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.marks = marks;
    }
}
  
  