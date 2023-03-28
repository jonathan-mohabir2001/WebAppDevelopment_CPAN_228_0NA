package com.cpan252.tekkenreborn.controller;

import java.util.EnumSet;

// Spring annotations required for the controller to be able to post from the form
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

// Model attributes imported from the model package 
import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.FighterPool;
import com.cpan252.tekkenreborn.model.Fighter.Anime;

// Lombok annotations
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequestMapping("/add") // the route for the controller post will be /add
@SessionAttributes("fighterPool")
public class AddFighterController {

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

  @ModelAttribute(name = "fighterPool")
  public FighterPool fighterPool() {
    return new FighterPool();
  }

  @ModelAttribute
  // This model attribute has a lifetime of a request
  public Fighter fighter() {
    return Fighter
        .builder()
        .build();
  }

  @PostMapping
  public String processFighterAddition(@Valid Fighter fighter,
      @ModelAttribute FighterPool pool, Errors errors) {
    if (errors.hasErrors()) {
      return "design";
    }
    pool.add(fighter);
    return "redirect:/design";
  }

}
