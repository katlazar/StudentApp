package com.example.studentapp.controller;

// /students --> na plik personList
//nazwa metody: getStudentList
///addStudent --> na plik addNewPerson
//nazwa metody: getAddStudent
///editStudent --> na plik editPerson
//nazwa metody: getEditStudent

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudentsList() {
        return "persons/personList";
    }

    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }

    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel student) {
        studentService.addStudent(student);
        return new RedirectView("/students");
    }

    @GetMapping("/editStudent")
    public String getEditStudent() {
        log.info("odpaliliśmy edit");
        return "persons/editPerson";
    }
}
