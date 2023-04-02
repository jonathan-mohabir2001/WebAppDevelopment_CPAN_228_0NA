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

  // NEW route to show the fighters in the database 
  @GetMapping("/fighters")
  public String showFighters(Model model) {
    List<Fighter> fighters = fighterRepository.findAll();
    model.addAttribute("fighters", fighters);
    return "fightersList";
  }

  @ModelAttribute
  public void animes(Model model) {
    var animes = EnumSet.allOf(Anime.class);
    model.addAttribute("animes", animes);
    log.info("animes converted to string:  {}", animes);
  }

  @ModelAttribute
  public Fighter fighter() {
    return Fighter.builder().build();
  }
// build the fighter object 



  // NEW CHANGES - The postmapping method is now using the FighterRepo inorder to save it to the h2 database 
  @PostMapping
  public String processFighterAddition(@Valid Fighter fighter, Errors errors) {

    log.info("Processing fighter addition");

    if (errors.hasErrors()) {
      return "addFighter";
    }
    fighterRepository.save(fighter);
    log.info("Fighter added to the pool: {}", fighter);
    return "redirect:/add/fighters";
  }
}