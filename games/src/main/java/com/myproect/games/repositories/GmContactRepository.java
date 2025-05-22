package com.myproect.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproect.games.entities.GmContact;

public interface GmContactRepository extends JpaRepository<GmContact, Long> {
}
