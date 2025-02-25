package com.example.demo.entity;

import com.example.demo.dto.Criticaly;
import com.example.demo.dto.MapPoint;
import com.example.demo.dto.Status;
import com.example.demo.dto.Type;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "risk")
@ToString
public class Risk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    private String description;

    @Enumerated(EnumType.STRING)
    private Criticaly criticaly;  //критичность риска/эффективность идеи

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Location location;

    private boolean anonymity;

    @ManyToOne
    private User user;

    private LocalDateTime dateTimeFix;

    private LocalDateTime dateTimeClose;

    @ElementCollection
    private List<String> photosList;

    @ElementCollection
    private List<String> filesList;

    private String category;  //категория опасности/оптимизации

    private Type type;

    @ManyToOne(cascade = CascadeType.ALL)
    private MapPoint mapPoint;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Автосохранение и удаление комментариев
    private List<Comment> commentsList;


    public Risk(Integer number, String description, Criticaly criticaly, Status status, Location location, boolean anonymity, User user, LocalDateTime dateTimeFix, LocalDateTime dateTimeClose, List<String> photosList, List<String> filesList, String category, Type type, MapPoint mapPoint, List<Comment> commentsList) {
        this.number = number;
        this.description = description;
        this.criticaly = criticaly;
        this.status = status;
        this.location = location;
        this.anonymity = anonymity;
        this.user = user;
        this.dateTimeFix = dateTimeFix;
        this.dateTimeClose = dateTimeClose;
        this.photosList = photosList;
        this.filesList = filesList;
        this.category = category;
        this.type = type;
        this.mapPoint = mapPoint;
        this.commentsList = commentsList;
    }
}
