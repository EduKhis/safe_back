package com.example.demo.controller;

import com.example.demo.dto.Criticaly;
import com.example.demo.dto.MapPoint;
import com.example.demo.dto.Status;
import com.example.demo.dto.Type;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.util.FileAggregator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InitController {

    private final LocationRepository locationRepository;
    private final DepartmentRepository departmentRepository;
    private final CommentRepository commentRepository;
    private final RoleRepository roleRepository;
    private final RiskRepository riskRepository;
    private final UserRepository userRepository;
    private final MapPointRepository mapPointRepository;

    @GetMapping("/txt")
    public String txt() {
        FileAggregator.text();
        return "OK";

    }
//INSERT INTO safety.roles(name) VALUES('ROLE_USER');
//INSERT INTO safety.roles(name) VALUES('ROLE_MODERATOR');
//INSERT INTO safety.roles(name) VALUES('ROLE_ADMIN');

//    {
//        "username":"user",
//        "email":"user@user.ru",
//        "password":"user",
//        "role":["ROLE_USER"]
//    }

//    {
//        "username":"admin",
//        "email":"admin@admin.ru",
//        "password":"admin",
//        "role":["admin"]
//    }

//    {
//        "username":"eduard",
//        "email":"eduard@eduard.ru",
//        "password":"1q2w3e4r5t",
//        "role":["ROLE_MODERATOR","ROLE_USER"]
//    }












    @GetMapping("/init")
    public String init() {

        roleRepository.save(new Role(ERole.ROLE_USER));
        roleRepository.save(new Role(ERole.ROLE_ADMIN));
        roleRepository.save(new Role(ERole.ROLE_MODERATOR));

        Location location = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Литейный участок"));
        Location location1 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Кузнечный участок"));
        Location location2 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Сварочный участок"));
        Location location3 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Механообрабатывающий участок"));
        Location location4 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Участок металлопокрытий"));
        Location location5 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Окрасочный участок"));
        Location location6 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 1", "Сборочный участок"));
        Location location7 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 2", "Испытательный участок"));
        Location location8 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 2", "Упаковочный участок"));
        Location location9 = locationRepository.save(new Location("ТУГРЭС", "ТУГРЭС - 3", "Участок термообработки"));
        Location location10 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 1", "Инструментальный участок"));
        Location location11 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 1", "Ремонтно-механический участок"));
        Location location12 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 2", "Энергетический участок"));
        Location location13 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 2", "Транспортный участок"));
        Location location14 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 3", "Складской участок"));
        Location location15 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 3", "Участок утилизации отходов"));
        Location location16 = locationRepository.save(new Location("БГРЭС", "БГРЭС - 3", "Административно-бытовой участок"));
        Location location17 = locationRepository.save(new Location("Комбинат", "Участок заготовки", "Станок шлифовальный"));

      // User user = userRepository.save(new User("danilenko.q@gmail.com", "danilenko.q@gmail.com", "List.of(ERole.USER)"));
      // User user1 = userRepository.save(new User("hisA.q@gmail.com", "hisA@gmail.com", "List.of(ERole.USER, ERole.ADMIN)"));
      // User user2 = userRepository.save(new User("hisE.q@gmail.com", "hisE@gmail.com", "List.of(ERole.USER, ERole.ADMIN)"));

        MapPoint mapPoint = mapPointRepository.save(new MapPoint(41.315467, 69.240471));
        MapPoint mapPoint2 = mapPointRepository.save(new MapPoint(42.315467, 69.240471));
        MapPoint mapPoint3 = mapPointRepository.save(new MapPoint(43.315467, 68.240471));
        MapPoint mapPoint4 = mapPointRepository.save(new MapPoint(41.315467, 67.240471));

//        riskRepository.save(new Risk(
//                1,
//                "Риск получения тяжелой травмы при спуске с лестницы из-за несоответствия угла наклона лестницы (более 75 градусов).",
//                Criticaly.GREEN,
//                Status.IN_WORK,
//                locationRepository.findById(1).get(),
//                false,
//                userRepository.findById(1L).get(),
//                LocalDateTime.of(2023, 12, 11, 15, 11, 12),
//                null,
//                new ArrayList<>(),
//                new ArrayList<>(),
//                "Падение с высоты",
//                Type.RISK,
//                mapPointRepository.findById(1).get(),
//                new ArrayList<>()
//        ));
//
//        riskRepository.save(new Risk(
//                2,
//                "Риск получения тяжелой травмы при спуске с лестницы из-за несоответствия угла наклона лестницы (более 75 градусов).",
//                Criticaly.ORANGE,
//                Status.IN_WORK,
//                locationRepository.findById(2).get(),
//                false,
//                userRepository.findById(2L).get(),
//                LocalDateTime.of(2024, 12, 10, 15, 11, 12),
//                null,
//                new ArrayList<>(),
//                new ArrayList<>(),
//                "Падение с высоты",
//                Type.RISK,
//                mapPointRepository.findById(2).get(),
//                new ArrayList<>()
//        ));
//
//        riskRepository.save(new Risk(
//                3,
//                "Риск получения травмы при переносе тяжелых грузов вручную, из-за недостатка механических средств для транспортировки и неправильной осанки при поднятии грузов.",
//                Criticaly.GREEN,
//                Status.IN_WORK,
//                locationRepository.findById(3).get(),
//                false,
//                userRepository.findById(3L).get(),
//                LocalDateTime.of(2023, 12, 11, 15, 11, 12),
//                null,
//                new ArrayList<>(),
//                new ArrayList<>(),
//                "Мышечные повреждения",
//                Type.RISK,
//                mapPointRepository.findById(3).get(),
//                new ArrayList<>()
//        ));
//
//
//        riskRepository.save(new Risk(
//                4,
//                "Риск возникновения пожара из-за неисправной электропроводки и перегрузки электрических линий в производственном цехе.",
//                Criticaly.RED,
//                Status.IN_WORK,
//                locationRepository.findById(4).get(),
//                false,
//                userRepository.findById(3L).get(),
//                LocalDateTime.of(2025, 12, 11, 15, 11, 12),
//                null,
//                new ArrayList<>(),
//                new ArrayList<>(),
//                "Пожар",
//                Type.RISK,
//                mapPointRepository.findById(4).get(),
//                new ArrayList<>()
//        ));
//
        return "ok";
    }
}
