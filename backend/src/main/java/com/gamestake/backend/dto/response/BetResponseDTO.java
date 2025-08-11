package com.gamestake.backend.dto.response;

public record BetResponseDTO(
        Long id,
        String userName,
        Double amount,
        String chosenTeam,
        String sport,
        String match,
        Double odd
) {}
