package com.myproect.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myproect.games.entities.GmGame;

public interface GmGameRepository extends JpaRepository<GmGame, Long> {
}
