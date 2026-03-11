package com.example.enviroassessment.controller;

import com.example.enviroassessment.dto.PickupScheduleDto;
import com.example.enviroassessment.services.PickupScheduleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PickScheduleController {

    @Autowired
    private PickupScheduleService pickupScheduleService;

    @PostMapping("/create")
    public String createSchedule(@RequestBody PickupScheduleDto pickupScheduleDto, HttpSession session){


        Long userId = (Long) session.getAttribute("userId");


        if (userId  == null) {
            return "User not logged in";
        }


        return pickupScheduleService.createSchedule(pickupScheduleDto,userId);
    }

    @GetMapping("/schedule")
    public List<PickupScheduleDto> getUserPickSchedules(HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        System.out.println("GET PICKUP SCHEDULES");
        System.out.println("Session userId: " + userId);


        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }


        return pickupScheduleService.getUserPickSchedule(userId);

    }
}
