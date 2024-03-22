package com.example.online_notepad.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
    private Date deadline;
    @Column(name = "is_done")
    private boolean isDone;

}
