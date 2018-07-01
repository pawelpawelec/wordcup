package pl.pawelec.worldcup.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GroupWorldCup {

  @Id
  private int id;
  private String name;

  @Column(insertable = false, updatable = false)
  private int countryId;

  @ManyToOne
  @JoinColumn(name = "countryId")
  private Country country;
}
