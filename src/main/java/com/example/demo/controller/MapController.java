package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Risk;
import com.example.demo.repository.RiskRepository;
import com.example.demo.mapper.RiskMapper;
import com.example.demo.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

private final MapService mapService;

    @GetMapping("/points")
    public List<RiskMapDto> getMapPoints() {
        return mapService.getMapPoints();
    }
}
