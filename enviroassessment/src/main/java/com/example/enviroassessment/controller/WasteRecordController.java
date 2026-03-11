package com.example.enviroassessment.controller;

import com.example.enviroassessment.dto.WasteRecordDto;
import com.example.enviroassessment.entities.WasteRecord;
import com.example.enviroassessment.services.WasteRecordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class WasteRecordController {

    @Autowired
    private WasteRecordService wasteRecordService;

    @PostMapping("/create")
    public String createWasteRecord(@RequestBody WasteRecordDto wasteRecordDto, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");


        if (userId  == null) {
            return "User not logged in";
        }

        return wasteRecordService.createWasteRecord(wasteRecordDto,userId);
    }

    @GetMapping("/records")
    public List<WasteRecordDto> getUserWasteRecords(HttpSession session){

        Long userId = (Long) session.getAttribute("userId");


        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        return wasteRecordService.getWasteRecordByUser(userId);

    }






}
