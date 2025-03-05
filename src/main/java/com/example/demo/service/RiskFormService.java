package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Location;
import com.example.demo.entity.Risk;
import com.example.demo.mapper.RiskMapper;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.RiskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RiskFormService {

    @Value("${category.risk}")
    private List<String> categoryRisk;

    @Value("${category.ef}")
    private List<String> categoryEf;

    @Value("${photo.url.load}")
    private String url;

    private final LocationRepository locationRepository;
    private final RiskRepository riskRepository;
    private final RiskMapper riskMapper;


    public List<String> getCategories(String type) {
        if (type.equals("risk"))
            return categoryRisk;
        return categoryEf;
    }

    public Risk getRiskById(Integer id) {
        Risk risk  = riskRepository.findById(id).get();
        return risk;
    }

    public List<RiskContentDto> getRisks() {
        List<Risk> risks = riskRepository.findAll();
        return riskMapper.riskToRiskContent(risks);
    }

    public List<String> getDivisions() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(Location::getFactory).distinct().toList();
    }

    public List<String> getSector(String division) {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().filter(x -> x.getFactory().equals(division)).map(Location::getSector).distinct().toList();
    }

    public List<String> getSection(String sector) {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().filter(x -> x.getSector().equals(sector)).map(Location::getSection).distinct().toList();
    }


    public void createRisk(String type, String description, String division, String sector, String category, String importance, Boolean isAnonymous, String section, String point, MultipartFile[] files) throws IOException {
        List<Location> location = locationRepository.findByFactoryAndSectorAndSection(division, sector, section);

        Risk risk = new Risk();
        risk.setType(Type.valueOf(type.toUpperCase()));
        risk.setDescription(description);
        risk.setLocation(location.get(0));
        risk.setCategory(category);
        risk.setCriticaly(Criticaly.valueOf(importance));
        risk.setAnonymity(isAnonymous);
        risk.setPhotosList(getFilesList(files));
        risk.setMapPoint(getMapPoint(point));
        risk.setStatus(Status.POSTED);
        risk.setDateTimeFix(LocalDateTime.now());

        System.out.println(risk.toString());

        riskRepository.save(risk);
    }

    private List<String> getFilesList(MultipartFile[] files) throws IOException {
        List<String> fileList = new ArrayList<>();

        if (files != null) {
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                fileList.add(fileName);

                String filePath = url + fileName;
                System.out.println(filePath);
                File dest = new File(filePath);
                file.transferTo(dest);
            }
        }
        return fileList;
    }

    private MapPoint getMapPoint(String point) {
        try {
            String[] split = point.split(", ");
            return new MapPoint(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        } catch (Exception e) {
            System.out.println("неполучилось распарсить " + point);
            return new MapPoint();
        }

    }
}
