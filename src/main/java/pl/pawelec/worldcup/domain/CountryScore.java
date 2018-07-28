package pl.pawelec.worldcup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class CountryScore {

  @Id
  private int countryId;
  private int looseGoal;
  private int gainGoal;
  private int score;

  private CountryScore(int countryId, int looseGoal, int gainGoal, int score) {
    this.countryId = countryId;
    this.looseGoal = looseGoal;
    this.gainGoal = gainGoal;
    this.score = score;
  }

  @ManyToOne
  @JoinColumn(name = "countryId", insertable = false, updatable = false)
  private Country country;

  public static CountryScore of(int countryId, int looseGoal, int gainGoal) {
    return new CountryScore(countryId, looseGoal, gainGoal, Score.calculateScore(gainGoal, looseGoal));
  }
}
