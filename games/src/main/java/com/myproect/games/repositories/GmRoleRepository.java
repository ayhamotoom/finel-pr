package com.myproect.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myproect.games.entities.GmRole;

public interface GmRoleRepository extends JpaRepository<GmRole, Long> {
}
