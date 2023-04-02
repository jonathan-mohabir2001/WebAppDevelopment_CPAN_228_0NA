package com.cpan252.tekkenreborn.controller;

import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;
import com.cpan252.tekkenreborn.repository.FighterRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequestMapping("/add")
public class AddFighterController {

  @Autowired
  private FighterRepository fighterRepository;

  @GetMapping
  public String add() {
    return "addFighter";
  }

  @ModelAttribute
  public void animes(Model model) {
    var animes = EnumSet.allOf(Anime.class);
    model.addAttribute("animes", animes);
    log.info("animes converted to string:  {}", animes);
  }

  @ModelAttribute(name = "fighters")
  public List<Fighter> fighters() {
    return fighterRepository.findAll();
  }

  @ModelAttribute
  public Fighter fighter() {
    return Fighter.builder().build();
  }

  @PostMapping
  public String processFighterAddition(@Valid Fighter fighter, Errors errors) {

    log.info("Processing fighter addition");

    if (errors.hasErrors()) {
      return "addFighter";
    }
    fighterRepository.save(fighter);
    log.info("Fighter added to the pool: {}", fighter);
    return "redirect:/add";
  }
}
