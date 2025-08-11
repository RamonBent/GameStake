package com.gamestake.backend.dto.mapper;

import com.gamestake.backend.dto.request.EventRequestDTO;
import com.gamestake.backend.dto.response.EventResponseDTO;
import com.gamestake.backend.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event toEntity(EventRequestDTO dto) {
        Event event = new Event();
        event.setSport(dto.sport());
        event.setTeamA(dto.teamA());
        event.setTeamB(dto.teamB());
        event.setEventDate(dto.eventDate());
        event.setOddTeamA(dto.oddTeamA());
        event.setOddTeamB(dto.oddTeamB());
        return event;
    }

    public EventResponseDTO toDTO(Event event) {
        return new EventResponseDTO(
                event.getId(),
                event.getSport(),
                event.getTeamA(),
                event.getTeamB(),
                event.getEventDate(),
                event.getOddTeamA(),
                event.getOddTeamB()
        );
    }
}
