package com.onlineclass.onlineclass.entity;





import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "classes")
public class Classdemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "schedule")
    private String schedule; // Consider using TIMESTAMP for schedule
}
