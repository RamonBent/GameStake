package com..service;

import com..dto.mapper.EventMapper;
import com..dto.request.EventRequestDTO;
import com..dto.response.EventResponseDTO;
import com..model.Event;
import com..repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public EventResponseDTO create(EventRequestDTO dto) {
        Event event = eventMapper.toEntity(dto);
        eventRepository.save(event);
        return eventMapper.toDTO(event);
    }

    public List<EventResponseDTO> listAll() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toDTO)
                .toList();
    }
}
