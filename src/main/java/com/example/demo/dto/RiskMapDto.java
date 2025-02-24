package com.example.demo.dto;

import com.example.demo.entity.Location;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RiskMapDto {

    private Integer id;

    private Integer number;

    private String description;

    private String criticaly;  //критичность риска/эффективность идеи

    private String status;

    private String location;

    private Location locationAll;

    private String dateTimeFix;

    private String photo;

    private String type;

    private double latitude;

    private double longitude;
}
