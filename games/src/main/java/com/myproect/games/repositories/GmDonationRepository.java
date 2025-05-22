package com.myproect.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myproect.games.entities.GmDonation;

public interface GmDonationRepository extends JpaRepository<GmDonation, Long> {
}
