package com.ithub.sberdnevnik.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentClassId;
    @Column(name = "studentClassNumber")
    private String studentClassNumber;
}
