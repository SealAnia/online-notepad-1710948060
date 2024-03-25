package com.example.online_notepad.controller;

import com.example.online_notepad.model.entity.Task;
import com.example.online_notepad.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "")
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @GetMapping(value = "/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.findById(taskId);
    }

    @PostMapping(value =  "/")
    public Task addNewTask(@RequestBody Task task) {
        return taskService.createOrUpdate(task);
    }

    @PutMapping(value = "/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        Task taskToUpdate = taskService.findById(taskId);

        if(task.getName() == null) {
            taskToUpdate.setName(taskToUpdate.getName());
        }
        else if(task.getName() != null) {
            taskToUpdate.setName(task.getName());
        }

        if(task.getDescription() == null) {
            taskToUpdate.setDescription(taskToUpdate.getDescription());
        }
        else if(task.getDescription() != null) {
            taskToUpdate.setDescription(task.getDescription());
        }

        if(task.getDeadline() == null) {
            taskToUpdate.setDeadline(taskToUpdate.getDeadline());
        }
        else if(task.getDeadline() != null) {
            taskToUpdate.setDeadline(task.getDeadline());
        }

        taskToUpdate.setDone(false);
        taskService.createOrUpdate(taskToUpdate);
        return ResponseEntity.ok(taskToUpdate);
    }

    @PutMapping(value = "/{taskId}/set_done")
    public Task setDone(@PathVariable Long taskId, Task task) {
        task = taskService.findById(taskId);
        System.out.println("Task ID: " + taskId);
        return taskService.setDone(task);
    }

    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }

}
