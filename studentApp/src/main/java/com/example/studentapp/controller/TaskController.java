package com.example.studentapp.controller;

// TaskController:
///tasks --> na plik tasks
//nazwa metody: getTaskList
///addTask --> na plik addTask
//nazwa metody: getAddTask

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String getTaskList() {
        return "tasks/tasks";
    }

    @GetMapping("/addTask")
    public String getAddTask() {
        return "tasks/addTask";
    }
}
