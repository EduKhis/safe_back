package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "map_point")
public class MapPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double latitude;
    private double longitude;


    public MapPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
