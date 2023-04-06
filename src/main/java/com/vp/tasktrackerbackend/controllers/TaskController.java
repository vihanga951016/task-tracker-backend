package com.vp.tasktrackerbackend.controllers;

import com.vp.tasktrackerbackend.bean.TasksBean;
import com.vp.tasktrackerbackend.services.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TasksService tasksService;

    @PostMapping("/add")
    public ResponseEntity addTask(@RequestBody TasksBean tasksBean) {
        return tasksService.addTask(tasksBean);
    }

    @PostMapping("/update")
    public ResponseEntity updateTask(@RequestBody TasksBean tasksBean) {
        return tasksService.updateTask(tasksBean);
    }

    @GetMapping("/get/task/{id}")
    public ResponseEntity getTaskById(@PathVariable Integer id) {
        return tasksService.getTaskById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity getAllTasks() {
        return tasksService.getAllTasks();
    }

    @DeleteMapping("/delete/task/{id}")
    public ResponseEntity deleteTask(@PathVariable Integer id) {
        return tasksService.deleteTasks(id);
    }

    @PostMapping("/enable-disable/task/{id}")
    public ResponseEntity enableDisableTask(@PathVariable Integer id) {
        return tasksService.enableDisableTask(id);
    }

    @PostMapping("/done-task/task/{id}")
    public ResponseEntity doneTask(@PathVariable Integer id) {
        return tasksService.doneTask(id);
    }

    @PostMapping("/compulsory-task/task/{id}")
    public ResponseEntity compulsoryTask(@PathVariable Integer id) {
        return tasksService.compulsoryTask(id);
    }

}
