package com.example.studentapp.controller;

// TaskController:
///tasks --> na plik tasks
//nazwa metody: getTaskList
///addTask --> na plik addTask
//nazwa metody: getAddTask

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.model.TaskModel;
import com.example.studentapp.service.StudentService;
import com.example.studentapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final StudentService studentService;

    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        List<TaskModel> taskList = taskService.getTaskList();
        model.addAttribute("taskModel", taskList);
        return "tasks/tasks";
    }

    @GetMapping("/addTask")
    public String getAddTask(Model model) {
        List<StudentModel> studentList = studentService.getStudentList();
        model.addAttribute("studentModel", studentList);
        return "tasks/addTask";
    }

    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task) {
        //task.setCreationDate(LocalDate.now());
        taskService.addTask(task);
        return new RedirectView("/tasks");
    }

    @GetMapping("/editTask/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        TaskModel task = taskService.getTaskById(id);
        model.addAttribute("taskModel", task);
        return "tasks/editTask";
    }

}
