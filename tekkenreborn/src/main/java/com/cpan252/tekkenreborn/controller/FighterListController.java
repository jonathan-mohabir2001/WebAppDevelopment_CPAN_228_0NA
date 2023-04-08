
package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fighters")
public class FighterListController {

  @Autowired
  private FighterRepository fighterRepository;

  @GetMapping
  public String listFighters(
      Model model,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "10") int size,
      @RequestParam(name = "sort", defaultValue = "name") String sortBy,
      @RequestParam(name = "direction", defaultValue = "ASC") String direction,
      // Add a 'search' request parameter for search queries
      @RequestParam(name = "search", defaultValue = "") String search) {

    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), sortBy);

    // Use the searchByName method if a search query is provided, otherwise use
    // findAll
    Page<Fighter> fightersPage = search.isEmpty()
        ? fighterRepository.findAll(pageRequest)
        : fighterRepository.searchByName(search, pageRequest);

    model.addAttribute("fightersPage", fightersPage);

    return "fightersList";
  }

}