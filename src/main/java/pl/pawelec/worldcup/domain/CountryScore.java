package pl.pawelec.worldcup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class CountryScore {

  public CountryScore(int countryId, int looseGoal, int gainGoal) {
    this.countryId = countryId;
    this.looseGoal = looseGoal;
    this.gainGoal = gainGoal;
    this.score = calculateScore(gainGoal, looseGoal);
  }

  @Id
  private int countryId;
  private int looseGoal;
  private int gainGoal;
  private int score;

  @ManyToOne
  @JoinColumn(name = "countryId", insertable = false, updatable = false)
  private Country country;

  private int calculateScore(int gainGoal, int looseGoal) {
    if (gainGoal > looseGoal)
      return 3;
    else if (gainGoal == looseGoal)
      return 1;
    else
      return 0;
  }
}
