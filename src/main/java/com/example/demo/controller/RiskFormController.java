package com.example.demo.controller;

import com.example.demo.dto.RiskContentDto;
import com.example.demo.entity.Risk;
import com.example.demo.service.RiskFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${cors.origins}")
@RequiredArgsConstructor
public class RiskFormController {

    private final RiskFormService riskFormService;


    @GetMapping("/risks")
    public List<RiskContentDto> getRisks() {
        return riskFormService.getRisks();
    }

    @GetMapping("/getCategories")
    public List<String> getCategories(@RequestParam(name = "type") String type) {
        return riskFormService.getCategories(type);
    }

    @GetMapping("/getDivisions")
    public List<String> getDivisions() {
        return riskFormService.getDivisions();
    }

    @GetMapping("/getSector")
    public List<String> getSector(@RequestParam(name = "division") String division) {
        return riskFormService.getSector(division);
    }

    @GetMapping("/getSection")
    public List<String> getSection(@RequestParam(name = "sector") String sector) {
        return riskFormService.getSection(sector);
    }

    @PostMapping(value = "/submitForm")
    public String submitForm(
            @RequestParam("type") String type, @RequestParam("description") String description,
            @RequestParam("division") String division, @RequestParam("sector") String sector,
            @RequestParam("category") String category, @RequestParam("importance") String importance,
            @RequestParam("isAnonymous") Boolean isAnonymous, @RequestParam("section") String section,
            @RequestParam("point") String point,
            @RequestPart(value = "files", required = false) MultipartFile[] files) throws IOException {

        riskFormService.createRisk(type, description, division, sector, category, importance, isAnonymous, section, point, files);
        return "ok";
    }


}
