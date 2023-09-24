package com.example.demo.Controllers;
import com.example.demo.Collection.Tutor;
import com.example.demo.Collection.Tutorial;
import com.example.demo.Logic.TutorialService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tutorials")
@CrossOrigin(origins = "http://localhost:3000")

@AllArgsConstructor

public class TutorialController {

        private final TutorialService tutorialService;

       @GetMapping
        public List<Tutorial> fetchAllTutorials(){
            return tutorialService.getAllTutorials();}

        @GetMapping("/{id}")
        public Tutorial getTutorial(@PathVariable String id) {
            return tutorialService.getTutorial(id);}

        @PostMapping
        public void addTutorial(@RequestBody Tutorial tutorial){
            tutorialService.addTutorial(tutorial);}

        @DeleteMapping("/{id}")
        public void deleteCourse(@PathVariable String id){
            tutorialService.deleteTutorial(id);}


        @PutMapping("/addTutor")
        public void addTutorTut(
                @RequestParam ("tutorialID") String tutorialID,
                @RequestBody Tutor tutor) throws MessagingException {
            tutorialService.addTutor(tutorialID,tutor);
        }

        @PutMapping("/removeTutor")
        public void removeTutorFromCourse(
                @RequestParam("courseCode") String tutorialID,
                @RequestBody Tutor tutor){
            tutorialService.removeTutor(tutorialID, tutor);
        }
    @PutMapping("/updateTutorial")
    public void updateTutorial(
            @RequestParam("tutorialID") String tutorialID,
            @RequestBody Tutorial tutorial) throws MessagingException {
        tutorialService.updateTutorial(tutorialID,tutorial);
    }}