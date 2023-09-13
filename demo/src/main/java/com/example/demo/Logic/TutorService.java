package com.example.demo.Logic;

import com.example.demo.Collection.Tutor;
import com.example.demo.Repository.TutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TutorService {
    private final TutorRepository tutorRepository;
    public Tutor getTutor(String studentID){
        Optional<Tutor> optionalTutor = tutorRepository.findTutorByStudentID(studentID);
        return optionalTutor.orElse(null);
    }
    public List<Tutor>getAllTutors()
    {
        return tutorRepository.findAll();

    }
    public void addTutor (Tutor tutor){

        tutorRepository.insert(tutor);
    }
    public void deleteTutor(String id) {
        tutorRepository.deleteById(id);
    }
}




