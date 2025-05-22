package com.myproect.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myproect.games.entities.GmUsers;

public interface GmUsersRepository extends JpaRepository<GmUsers, Long> {
}
