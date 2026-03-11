package com.example.enviroassessment.services;

import com.example.enviroassessment.dto.PickupScheduleDto;
import com.example.enviroassessment.entities.PickupSchedule;
import com.example.enviroassessment.entities.User;
import com.example.enviroassessment.repository.PickupScheduleRepository;
import com.example.enviroassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PickupScheduleService  {

    @Autowired
    private PickupScheduleRepository repository;

    @Autowired
    private UserRepository userRepository;

    private PickupScheduleDto convertToDto(PickupSchedule pickupSchedule){

        PickupScheduleDto pickupScheduleDto = new PickupScheduleDto();

        pickupScheduleDto.setId(pickupSchedule.getId());
        pickupScheduleDto.setScheduledPickup(pickupSchedule.getPickupDate());
        pickupScheduleDto.setPickupAddress(pickupSchedule.getAddress());
        pickupScheduleDto.setScheduleStatus(pickupSchedule.getStatus());
        pickupScheduleDto.setUserId(pickupSchedule.getUser().getId());


        return pickupScheduleDto;

    }

    public String createSchedule(PickupScheduleDto pickupScheduleDto,long userId){

        User user =  userRepository.findById(userId).orElseThrow(()->
                new RuntimeException("User not found"));

        PickupSchedule pickupSchedule = new PickupSchedule();

        pickupSchedule.setUser(user);
        pickupSchedule.setPickupDate(pickupScheduleDto.getScheduledPickup());
        pickupSchedule.setAddress(pickupScheduleDto.getPickupAddress());
        pickupSchedule.setStatus(pickupScheduleDto.getScheduleStatus());

        repository.save(pickupSchedule);



        return "Schedule successfully created";

    }

    public List<PickupScheduleDto> getUserPickSchedule(long userId){

        return repository.findByUserId(userId).stream().map(this::convertToDto).collect(Collectors.toList());

    }

    public long countSchedules(long userId){
        return  repository.countByUserId(userId);
    }


}
