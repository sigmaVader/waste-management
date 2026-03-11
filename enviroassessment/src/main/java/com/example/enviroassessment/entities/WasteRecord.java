package com.example.enviroassessment.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="waste_records")
public class WasteRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private Boolean isRecyclable;

    private LocalDate disposedDate;

    @ManyToOne
    private  User user;

}
