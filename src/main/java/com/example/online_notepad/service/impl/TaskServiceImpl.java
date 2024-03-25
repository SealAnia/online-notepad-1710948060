package com.example.online_notepad.service.impl;

import com.example.online_notepad.model.entity.Task;
import com.example.online_notepad.model.repository.TaskRepository;
import com.example.online_notepad.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public Task createOrUpdate(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public Task setDone(Task task) {
        task.setDone(true);
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

}
