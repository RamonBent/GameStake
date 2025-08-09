package com.gamestake.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sport;
    private String teamA;
    private String teamB;
    private LocalDateTime eventDate;
    private Double oddTeamA;
    private Double oddTeamB;
}
