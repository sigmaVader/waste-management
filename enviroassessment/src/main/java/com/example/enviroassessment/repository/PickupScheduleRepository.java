package com.example.enviroassessment.repository;

import com.example.enviroassessment.entities.PickupSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickupScheduleRepository extends JpaRepository<PickupSchedule,Long> {

    List<PickupSchedule> findByUserId(Long userId);

    long countByUserId(Long userId);




}
