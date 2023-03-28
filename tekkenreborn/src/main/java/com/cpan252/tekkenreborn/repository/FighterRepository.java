package com.cpan252.tekkenreborn.repository;

//Interface for the repository  that will be used to store the fighters

import java.util.Optional;

import com.cpan252.tekkenreborn.model.Fighter;

public interface FighterRepository {

  Iterable<Fighter> findAll();
  // find all of the fighters in the repository

  Optional<Fighter> findById(Long id);
  // find the fighters by their ids.

  void save(Fighter fighter);
  // save the fighter to the repository

}
