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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudentsList(Model model) {
        List<StudentModel> studentList = studentService.getStudentList();
        model.addAttribute("studentModel", studentList);
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

    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model) {
        log.info("odpaliliśmy edit path: {}",id);
        StudentModel student = studentService.getStudentById(id);
        model.addAttribute("studentModel", student);
        return "persons/editPerson";
    }

    @PostMapping("/editStudent/{id}")
    public RedirectView postEditStudent(@PathVariable("id") Long id, StudentModel student) {
        studentService.saveEditStudent(student);
        return new RedirectView("/editStudent/{id}");
    }

    @PostMapping("/delete/{id}")
    public RedirectView postAddStudent(@PathVariable("id") Long id) {
        studentService.delStudent(id);
        return new RedirectView("/students");
    }
}
