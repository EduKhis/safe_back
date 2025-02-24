package com.example.demo.service;

import com.example.demo.dto.RiskMapDto;
import com.example.demo.entity.Risk;
import com.example.demo.mapper.RiskMapper;
import com.example.demo.repository.RiskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapService {
    private final RiskRepository riskRepository;

    private final RiskMapper riskMapper;

    public List<RiskMapDto> getMapPoints() {
        List<Risk> risks = riskRepository.findAll();
        return riskMapper.riskToRiskMap(risks);
    }

}
