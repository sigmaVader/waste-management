package com.example.enviroassessment.controller;

import com.example.enviroassessment.dto.DashBoardDto;
import com.example.enviroassessment.services.PickupScheduleService;
import com.example.enviroassessment.services.WasteRecordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("api/dashboard")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class DashboardController {


    @Autowired
    private PickupScheduleService pickupScheduleService;


    @Autowired
    private WasteRecordService wasteRecordService;

    @GetMapping("/counts")
    public DashBoardDto getCounts(HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        if(userId == null){
            throw new RuntimeException("User not logged in");
        }

        DashBoardDto dto = new DashBoardDto();

        dto.setTotalWasteRecords(wasteRecordService.countWasteRecord(userId));
        dto.setRecyclableWaste(wasteRecordService.countWasteRecord(userId));
        dto.setScheduledPickups(pickupScheduleService.countSchedules(userId));


        return  dto;



    }









}
