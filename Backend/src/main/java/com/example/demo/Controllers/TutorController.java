package com.example.demo.Controllers;
import com.example.demo.Collection.Tutor;
import com.example.demo.Logic.TutorService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*API*/
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/tutors")
@AllArgsConstructor
public class TutorController {
    private final TutorService tutorService;

    @GetMapping
    public List<Tutor> fetchAllTutors(){
        return tutorService.getAllTutors();}

    @GetMapping("/{id}")
    public Tutor getTutor(@ PathVariable String id) {
        return tutorService.getTutor(id);}

    @PostMapping("/addtutor")
    public void addTutor(@RequestBody Tutor tutor) throws MessagingException {
        tutorService.addTutor(tutor);}

    @DeleteMapping("/{id}")
    public String deleteTutor(@PathVariable String id){
        tutorService.deleteTutor(id);
        return "success";}








}

