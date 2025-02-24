package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String factory;

    private String sector;

    private String section;

    @OneToMany
    private List<Department>departments;

    public Location(String factory, String sector, String section) {
        this.factory = factory;
        this.sector = sector;
        this.section = section;
    }
}
