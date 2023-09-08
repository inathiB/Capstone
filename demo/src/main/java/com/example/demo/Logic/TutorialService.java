package com.example.demo.Logic;

import com.example.demo.Collection.Course;
import com.example.demo.Collection.CourseConvener;
import com.example.demo.Collection.Tutor;
import com.example.demo.Collection.Tutorial;
import com.example.demo.Repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TutorialService {
    private final TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;}

    public Tutorial getTutorial(String id){
        Optional<Tutorial> optionalTutorial = tutorialRepository.findTutorialByTutorialID(id);

        return optionalTutorial.orElse(null);
    }
    public List<Tutorial> getAllTutorials(){
        return tutorialRepository.findAll();
    }
    public void addTutorial (Tutorial tutorial){
        tutorialRepository.insert(tutorial);
    }
    public void deleteTutorial(String tutorialID){
        tutorialRepository.deleteById(tutorialID);
    }

   public void addTutor(String tutorialID, Tutor tutor){
        Optional<Tutorial> tutorial =  tutorialRepository.findTutorialByTutorialID(tutorialID);
        if(tutorial.isPresent()){
            Tutorial actual_tutorial = tutorial.get();
            actual_tutorial.getTutTutors().add(tutor);
        }else{
            System.out.println("Tutorial not Found");
        }}
    public void removeTutor(String tutorialID, Tutor tutor){
        Optional<Tutorial> tutorial =  tutorialRepository.findTutorialByTutorialID(tutorialID);
        if(tutorial.isPresent()){
            Tutorial actual_tutorial = tutorial.get();
            actual_tutorial.getTutTutors().remove(tutor);
        }else{
            System.out.println("Tutorial not Found");
        }}
}
