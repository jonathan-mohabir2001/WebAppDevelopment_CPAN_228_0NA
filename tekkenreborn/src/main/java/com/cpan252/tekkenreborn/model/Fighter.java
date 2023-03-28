/*
 * LAB 03 REVIEW SOURCE CODE - Jonathan M (big review)
 * 
 * Lombok for the builder and data annotations 
 * Jakarta will help with the backend validations for the form. 
 */

package com.cpan252.tekkenreborn.model;

import java.math.BigDecimal;
// math class for the resistence matching the required type of Double
import java.util.Date;

import jakarta.persistence.Id;

//Jakarta validation annotations

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

//lombok annotations
import lombok.Builder;
import lombok.Data;

@Data
@Builder
// Annotate the class with the builder annotation and data annotation for the
// getters and setters
public class Fighter {

  @Id
  // annotate the id with the id annotation from the jakarta persistence package
  // to enforce the id as a primary key
  private Long id;
  // new field added for lab 03

  @NotBlank(message = "Name is required")
  private String name;

  @Max(value = 100, message = "Damage Per Hit must max out at 100")
  private int damagePerHit;

  @Min(value = 1000, message = "Health must be at least 1000")
  private int health;

  @DecimalMin(value = "0.1", inclusive = true)
  @DecimalMax(value = "10.0", inclusive = true)
  private BigDecimal resistence;

  private Anime animeFrom;

  private final Date createdAt = new Date();
  // new field for lab 03 - date of creation of the fighter

  public enum Anime {
    NARUTO("Naruto"), BLEACH("Bleach"), ONE_PIECE("One Piece"), TEKKEN("Tekken");

    private String title;

    private Anime(String title) {
      this.title = title;
    }

    // method for the enum to return the title
    public String getTitle() {
      return title;
    }
  }
}
