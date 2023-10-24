package com.example.studentapp.service;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public void addStudent(StudentModel student) {
        studentRepository.save(student);
    }
}
