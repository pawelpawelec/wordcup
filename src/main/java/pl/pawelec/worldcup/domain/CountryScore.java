package pl.pawelec.worldcup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryScore {

  @Id
  private int idCountry;
  private int looseGoal;
  private int gainGoal;
  private int score;
}
