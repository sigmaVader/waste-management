package com.example.enviroassessment.dto;

import lombok.Data;

@Data
public class DashBoardDto {

    private long totalWasteRecords;
    private long recyclableWaste;
    private long scheduledPickups;
}
