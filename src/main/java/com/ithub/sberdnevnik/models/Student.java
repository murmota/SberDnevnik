package com.ithub.sberdnevnik.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @Column(name = "studentName")
    private String studentName;
    @ManyToOne
    @JoinColumn(name = "student_class_id")
    private StudentClass studentClass;
}
