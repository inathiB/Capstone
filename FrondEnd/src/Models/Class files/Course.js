export default class Course {
  constructor(courseName, courseCode,duration,year,creator) {
      this._courseCode = courseCode;
      this._courseName = courseName;
      this._duration = duration || "";
      this._year = year || "";
      this._creator = creator || "";
      this.lecturers = [];
      this.tas = [];
      this.tutors = ['JNAMAM001 - Amahle Jenete', 'BBBIII001 - Bulwana Inathi'];
  }

  // Getters
  get courseCode() {
      return this._courseCode;
  }

  get courseName() {
      return this._courseName;
  }

  get duration() {
      return this._duration;
  }

  get year() {
      return this._year;
  }

  get creator() {
      return this._creator;
  }

  // Setters
  set courseCode(courseCode) {
      this._courseCode = courseCode;
  }

  set courseName(courseName) {
      this._courseName = courseName;
  }

  set duration(duration) {
      this._duration = duration;
  }

  set year(year) {
      this._year = year;
  }

  set creator(creator) {
      this._creator = creator;
  }

  addLecturer(lecturer) {
      this.lecturers.push(lecturer);
  }

  addTA(ta) {
      this.tas.push(ta);
  }

  addTutor(tutor) {
      this.tutors.push(tutor);
  }

  removeLecturer(lecturer) {
      const index = this.lecturers.indexOf(lecturer);
      if (index !== -1) {
          this.lecturers.splice(index, 1);
      }
  }

  removeTA(ta) {
      const index = this.tas.indexOf(ta);
      if (index !== -1) {
          this.tas.splice(index, 1);
      }
  }

  removeTutor(tutor) {
      const index = this.tutors.indexOf(tutor);
      if (index !== -1) {
          this.tutors.splice(index, 1);
      }
  }
}
