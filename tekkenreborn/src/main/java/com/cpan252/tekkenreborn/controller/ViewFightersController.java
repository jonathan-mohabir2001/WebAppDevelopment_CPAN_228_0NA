package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewFighters")
public class ViewFightersController {

  @Autowired
  private FighterRepository fighterRepository;

  @GetMapping
  public String viewFighters(Model model) {
    model.addAttribute("fighters", fighterRepository.findAll());
    return "viewFighters";
  }
}
