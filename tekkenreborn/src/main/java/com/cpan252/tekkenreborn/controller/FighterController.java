
package com.cpan252.tekkenreborn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

// Other imports

@Controller
public class FighterController {

  @GetMapping("/fightersList")
  public String listFighters(Model model, @AuthenticationPrincipal OAuth2User principal) {
    // Access user information with principal.getAttribute("name") or other
    // attributes
    model.addAttribute("fighters" /* Get list of fighters */);
    return "fightersList";
  }

  // Other methods
}
