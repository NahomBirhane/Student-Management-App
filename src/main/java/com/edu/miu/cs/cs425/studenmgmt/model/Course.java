package com.edu.miu.cs.cs425.studenmgmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseCode;
    private String courseName;

    @ManyToMany(mappedBy ="courses" )
    private List<Student> students;


    public  Course (Long courseId, String courseCode, String courseName){
        this.courseId=courseId;
        this.courseCode=courseCode;
        this.courseName=courseName;
    }
}
