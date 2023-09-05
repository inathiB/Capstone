import {revertDatetimeFormat} from '../../Service/TimeandDate'
export default class Tutorial {
  constructor(title, courseCode, datetime, venue) {
      this._title = title;
      this._courseCode = courseCode;
      this._datetime = datetime;
      this._venue = venue;
  }

  get title() {
      return this._title;
  }

  set title(title) {
      this._title = title;
  }

  get courseCode() {
      return this._courseCode;
  }

  set courseCode(courseCode) {
      this._courseCode = courseCode;
  }

  get datetime() {
      return this._datetime;
  }

  set datetime(datetime) {
      this._datetime = datetime;
  }

  get venue() {
      return this._venue;
  }

  set venue(venue) {
      this._venue = venue;
  }

  // Method to check if the tutorial is in the past
  isPast() {
      const tutorialDate = new Date(revertDatetimeFormat(this._datetime));
      return tutorialDate < new Date();
  }
}

  
  
  