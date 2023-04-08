package com.cpan252.tekkenreborn.model;

/*
 * LAB 06 COMMITS: 
 * New MODEL CREATED.
 */

import jakarta.validation.constraints.NotBlank;

public class RegistrationForm {

  @NotBlank(message = "Username is required")
  private String username;

  @NotBlank(message = "Password is required")
  private String password;

  // Getters and setters for username and password

  public User toUser() {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password); // You should hash the password before storing it
    return user;
  }
}
