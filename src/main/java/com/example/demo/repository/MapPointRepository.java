package com.example.demo.repository;

import com.example.demo.dto.MapPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapPointRepository extends JpaRepository<MapPoint,Integer> {

}
