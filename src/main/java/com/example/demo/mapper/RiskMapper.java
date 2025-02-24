package com.example.demo.mapper;

import com.example.demo.dto.RiskMapDto;
import com.example.demo.entity.Risk;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class RiskMapper {

    public List<RiskMapDto> riskToRiskMap(List<Risk> risksR) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        List<RiskMapDto> risks = new ArrayList<>();
        for (Risk risk : risksR) {
            risks.add(RiskMapDto.builder()
                    .id(risk.getId())
                    .number(risk.getNumber())
                    .description(risk.getDescription())
                    .criticaly(risk.getCriticaly().name())
                    .status(risk.getStatus().getDisplayName())
                    .location(risk.getLocation().getSector())
                    .locationAll(risk.getLocation())
                    .dateTimeFix(risk.getDateTimeFix().format(formatter))
                    .photo("milk1.jpg")
                    .type(risk.getType().getDisplayName())
                    .latitude(risk.getMapPoint().getLatitude())
                    .longitude(risk.getMapPoint().getLongitude())
                    .build());
        }
        return risks;
    }
}
