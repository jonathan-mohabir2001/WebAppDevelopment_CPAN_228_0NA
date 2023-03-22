/*
 * Class represents A controller that will 
 * render the about HTML page when necessary 
 */

package com.cpan252.tekkenreborn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// annotate the class over with the controller
@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String home() {
    return "home";
  }
}
