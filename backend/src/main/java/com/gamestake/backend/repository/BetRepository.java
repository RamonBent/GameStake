package com.gamestake.backend.repository;

import com.gamestake.backend.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
