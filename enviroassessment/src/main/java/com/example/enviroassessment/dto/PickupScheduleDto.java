package com.example.enviroassessment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PickupScheduleDto {

    private long id;

    private LocalDate scheduledPickup;

    private String scheduleStatus;

    private String pickupAddress;

    private long userId;
}
