import Lecturer from "../Models/Class files/Lecturer";
import UserController from "./UserController";

class LecturerController extends UserController{
    constructor(){
        this.users = [];
    }

    loadUsers(){
        //Load lecturers from database
        this.users= [new Lecturer("JNT12334","","12334","David Smith")]
    }

}