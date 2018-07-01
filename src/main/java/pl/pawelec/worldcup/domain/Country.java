package pl.pawelec.worldcup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Country {

  @Id
  private int id;
  private String name;

  @OneToOne
  private CountryScore countryScore;
}
