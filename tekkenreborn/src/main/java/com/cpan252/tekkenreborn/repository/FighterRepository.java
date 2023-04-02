package com.cpan252.tekkenreborn.repository;

import com.cpan252.tekkenreborn.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
