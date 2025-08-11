package com.gamestake.backend.dto.request;

import java.time.LocalDateTime;

public record EventRequestDTO(
        String sport,
        String teamA,
        String teamB,
        LocalDateTime eventDate,
        Double oddTeamA,
        Double oddTeamB
) {}
