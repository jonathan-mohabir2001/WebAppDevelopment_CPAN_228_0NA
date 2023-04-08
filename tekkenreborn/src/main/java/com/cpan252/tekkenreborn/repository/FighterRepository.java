package com.cpan252.tekkenreborn.repository;

import com.cpan252.tekkenreborn.model.Fighter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {

  // Add a search method using a custom JPQL query
  @Query("SELECT f FROM Fighter f WHERE f.name LIKE %:searchTerm%")
  Page<Fighter> searchByName(String searchTerm, Pageable pageable);
}
