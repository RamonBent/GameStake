package com.gamestake.backend.service;

import com.gamestake.backend.dto.mapper.BetMapper;
import com.gamestake.backend.dto.request.BetRequestDTO;
import com.gamestake.backend.dto.response.BetResponseDTO;
import com.gamestake.backend.model.Bet;
import com.gamestake.backend.model.Event;
import com.gamestake.backend.repository.BetRepository;
import com.gamestake.backend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {

    private final BetRepository betRepository;
    private final EventRepository eventRepository;
    private final BetMapper betMapper;

    public BetService(BetRepository betRepository, EventRepository eventRepository, BetMapper betMapper) {
        this.betRepository = betRepository;
        this.eventRepository = eventRepository;
        this.betMapper = betMapper;
    }

    public BetResponseDTO placeBet(BetRequestDTO dto) {
        Event event = eventRepository.findById(dto.eventId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Bet bet = betMapper.toEntity(dto, event);
        betRepository.save(bet);
        return betMapper.toDTO(bet);
    }

    public List<BetResponseDTO> listBets() {
        return betRepository.findAll()
                .stream()
                .map(betMapper::toDTO)
                .toList();
    }
}
