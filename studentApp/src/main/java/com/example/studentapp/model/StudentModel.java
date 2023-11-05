package com.example.studentapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="git_hub")
    private String gitHub;

    private String start;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<TaskModel> tasks = new HashSet<>();
}
