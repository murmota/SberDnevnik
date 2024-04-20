package com.ithub.sberdnevnik.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.error.Mark;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long diaryId;
    @Column(name = "date")
    private String date;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "mark")
    private int mark;
}
