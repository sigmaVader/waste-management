package com.example.enviroassessment.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="recycle_bins")
@Data   //LOMBOK
public class RecycleBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String location;

    private  String type;

    private double capacity;

}
