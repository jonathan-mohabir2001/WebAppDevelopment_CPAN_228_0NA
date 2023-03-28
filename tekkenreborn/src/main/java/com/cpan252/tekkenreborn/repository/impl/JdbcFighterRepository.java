package com.cpan252.tekkenreborn.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;

@Repository
public class JdbcFighterRepository implements FighterRepository {

  public JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcFighterRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Iterable<Fighter> findAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public Optional<Fighter> findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public void save(Fighter fighter) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

}
