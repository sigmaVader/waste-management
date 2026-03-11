package com.example.enviroassessment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WasteRecordDto {

    private  long id;

    private String name;

    private String  wasteDescription;

    private  Boolean canBeRecycled;

    private LocalDate disposedDate;


    private long userId;
}
