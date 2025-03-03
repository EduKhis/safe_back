package com.example.demo.mapper;

import com.example.demo.dto.RiskContentDto;
import com.example.demo.dto.RiskMapDto;
import com.example.demo.entity.Risk;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class RiskMapper {

    @Value("${photo.url}")
    private String url;

    public List<RiskMapDto> riskToRiskMap(List<Risk> risksR) {
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
                    .dateTimeFix(dateFormat(risk.getDateTimeFix()))
                    .photo("milk1.jpg")
                    .type(risk.getType().getDisplayName())
                    .latitude(risk.getMapPoint().getLatitude())
                    .longitude(risk.getMapPoint().getLongitude())
                    .build());
        }
        return risks;
    }

    public List<RiskContentDto> riskToRiskContent(List<Risk> risksR) {

        List<RiskContentDto> risks = new ArrayList<>();
        for (Risk risk : risksR) {
            System.out.println(risk.getPhotosList().isEmpty() ? null : risk.getPhotosList().get(0));
            risks.add(RiskContentDto.builder()
                    .photo(risk.getPhotosList().isEmpty() ? null : url + "\\" + risk.getPhotosList().get(0))
                    .id(risk.getId())
                    .criticaly(risk.getCriticaly().name())
                    .dateTimeFix(dateFormat(risk.getDateTimeFix()))
                    .number(risk.getNumber())
                    .type(risk.getType().getDisplayName())
                    .category(risk.getCategory())
                    .sector(risk.getLocation().getSector())
                    .section(risk.getLocation().getSection())
                    .description(risk.getDescription())


                    .build());
        }
        return risks;
    }

    private String dateFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dateTime.format(formatter);
    }
}
