package com.gamestake.backend.dto.request;

public record BetRequestDTO(
        String userName,
        Double amount,
        Long eventId,
        String chosenTeam
) {}
