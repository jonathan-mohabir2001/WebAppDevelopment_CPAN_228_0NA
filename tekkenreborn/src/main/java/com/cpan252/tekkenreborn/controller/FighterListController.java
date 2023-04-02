
package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fighters")
public class FighterListController {

  @Autowired
  private FighterRepository fighterRepository;

  @GetMapping
  public String listFighters(Model model) {
    List<Fighter> fighters = fighterRepository.findAll();
    model.addAttribute("fighters", fighters);
    return "fightersList"; // <-- use the correct view name here
  }

}