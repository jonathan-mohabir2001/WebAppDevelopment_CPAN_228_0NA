package com.cpan252.tekkenreborn.controller;
/*
 * LAB 06 COMMITS: 
 * A NEW CONTROLLER BELOW TO ALLOW FOR THE REGISTRATION OF USERS 
 */

import com.cpan252.tekkenreborn.model.RegistrationForm;
import com.cpan252.tekkenreborn.model.User;
import com.cpan252.tekkenreborn.repository.UserRepository;

// Moudles 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
// route defiend at register
public class RegistrationController {

  @Autowired
  private UserRepository userRepository;

  // Returnign the Registration Thymeleaf HTML
  @GetMapping
  public String showRegistrationForm(Model model) {
    model.addAttribute("registrationForm", new RegistrationForm());
    return "registration";
  }

  // Posting users
  @PostMapping
  public String processRegistration(RegistrationForm registrationForm) {
    User user = registrationForm.toUser();
    userRepository.save(user);
    return "redirect:/";
  }
}
