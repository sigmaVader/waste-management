package com.example.enviroassessment.repository;

import com.example.enviroassessment.entities.WasteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteRecordRepository  extends JpaRepository <WasteRecord,Long> {

    List<WasteRecord> findByUserId(Long userId);

    long countByUserId(Long userId);

    long countByUserIdAndIsRecyclableTrue(Long userId);
}
