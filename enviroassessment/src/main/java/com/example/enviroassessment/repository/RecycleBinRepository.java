package com.example.enviroassessment.repository;

import com.example.enviroassessment.entities.RecycleBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleBinRepository  extends JpaRepository<RecycleBin,Long> {
}
