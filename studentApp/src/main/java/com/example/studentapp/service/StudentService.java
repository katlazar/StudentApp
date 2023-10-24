package com.example.studentapp.service;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void addStudent(StudentModel student) {
        studentRepository.save(student);
    }

    public List<StudentModel> getStudentList() {
        return studentRepository.findAll();
    }

    public StudentModel getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void saveEditStudent(StudentModel student) {
        studentRepository.save(student);
    }

    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
