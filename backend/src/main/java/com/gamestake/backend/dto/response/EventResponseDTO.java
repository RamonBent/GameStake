package com.gamestake.backend.dto.response;

import java.time.LocalDateTime;

public record EventResponseDTO(
        Long id,
        String sport,
        String teamA,
        String teamB,
        LocalDateTime eventDate,
        Double oddTeamA,
        Double oddTeamB
) {}
