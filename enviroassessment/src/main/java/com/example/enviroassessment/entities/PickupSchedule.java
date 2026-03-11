package com.example.enviroassessment.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
@Table(name="pickup_schedules")
public class PickupSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate pickupDate;

    private String status;

    private String address;

    @ManyToOne
    private User user;

}
