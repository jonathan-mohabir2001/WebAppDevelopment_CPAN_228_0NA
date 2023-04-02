package com.cpan252.tekkenreborn;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class TekkenrebornApplication {

  public static void main(String[] args) {
    SpringApplication.run(TekkenrebornApplication.class, args);
  }

  @Bean
  public CommandLineRunner initFighters(FighterRepository fighterRepository) {
    return args -> {
      fighterRepository.save(Fighter.builder().name("Fighter1").damagePerHit(50).health(1000)
          .resistence(new BigDecimal("1.5")).animeFrom(Fighter.Anime.NARUTO).build());
      fighterRepository.save(Fighter.builder().name("Fighter2").damagePerHit(60).health(1200)
          .resistence(new BigDecimal("2.0")).animeFrom(Fighter.Anime.BLEACH).build());
      // Add more Fighters as needed
    };
  }
}
