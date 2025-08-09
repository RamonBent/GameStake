package com.gamestake.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String chosenTeam;
}