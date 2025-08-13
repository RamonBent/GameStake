package com.gamestake.backend.dto.mapper;


import com.gamestake.backend.dto.request.BetRequestDTO;
import com.gamestake.backend.dto.response.BetResponseDTO;
import com.gamestake.backend.model.Bet;
import com.gamestake.backend.model.Event;
import org.springframework.stereotype.Component;

@Component
public class BetMapper {

    public Bet toEntity(BetRequestDTO dto, Event event) {
        Bet bet = new Bet();
        bet.setUserName(dto.userName());
        bet.setAmount(dto.amount());
        bet.setChosenTeam(dto.chosenTeam());
        bet.setEvent(event);
        return bet;
    }

    public BetResponseDTO toDTO(Bet bet) {
        Double odd = bet.getChosenTeam().equalsIgnoreCase(bet.getEvent().getTeamA())
                ? bet.getEvent().getOddTeamA()
                : bet.getEvent().getOddTeamB();

        return new BetResponseDTO(
                bet.getId(),
                bet.getUserName(),
                bet.getAmount(),
                bet.getChosenTeam(),
                bet.getEvent().getSport(),
                bet.getEvent().getTeamA() + " vs " + bet.getEvent().getTeamB(),
                odd
        );
    }
}
