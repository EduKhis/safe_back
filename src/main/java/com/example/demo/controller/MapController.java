package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class MapController {

private final MapService mapService;

    @GetMapping("/points")
    public List<RiskMapDto> getMapPoints() {
        return mapService.getMapPoints();
    }
}
