package com.example.online_notepad.service;

import com.example.online_notepad.model.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();
    Task findById(Long taskId);
    Task createOrUpdate(Task task);
    Task setDone(Task task);
    void delete(Long taskId);

}
