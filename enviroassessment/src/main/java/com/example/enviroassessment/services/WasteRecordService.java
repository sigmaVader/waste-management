package com.example.enviroassessment.services;

import com.example.enviroassessment.dto.WasteRecordDto;
import com.example.enviroassessment.entities.User;
import com.example.enviroassessment.entities.WasteRecord;
import com.example.enviroassessment.repository.UserRepository;
import com.example.enviroassessment.repository.WasteRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WasteRecordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WasteRecordRepository wasteRecordRepository;

    //converts waste entity to dto
    private WasteRecordDto convertToDto(WasteRecord waste){

        WasteRecordDto dto = new WasteRecordDto();
        dto.setId(waste.getId());
        dto.setWasteDescription(waste.getDescription());
        dto.setDisposedDate(waste.getDisposedDate());
        dto.setName(waste.getName());
        dto.setCanBeRecycled(waste.getIsRecyclable());
        dto.setUserId(waste.getUser().getId());

        return dto;
    }

    public String createWasteRecord(WasteRecordDto wasteRecordDto,Long userId){

        User user =  userRepository.findById(userId).orElseThrow(()->
                new RuntimeException("User not found"));

        WasteRecord  wasteRecord = new WasteRecord();
        wasteRecord.setUser(user);
        wasteRecord.setName(wasteRecordDto.getName());
        wasteRecord.setDisposedDate(wasteRecordDto.getDisposedDate());
        wasteRecord.setDescription(wasteRecordDto.getWasteDescription());
        wasteRecord.setIsRecyclable(wasteRecordDto.getCanBeRecycled());

        wasteRecordRepository.save(wasteRecord);

        return "Record successfully created";
    }

    public List<WasteRecordDto> getWasteRecordByUser(Long userId){

        return wasteRecordRepository.findByUserId(userId).stream().map(this::convertToDto).collect(Collectors.toList());

    }

    public long countWasteByUser(long userId){
        return  wasteRecordRepository.countByUserId(userId);
    }

    public long countWasteRecord(long userId){
        // counts user and recyclable waste
        return wasteRecordRepository.countByUserIdAndIsRecyclableTrue(userId);
    }


}
