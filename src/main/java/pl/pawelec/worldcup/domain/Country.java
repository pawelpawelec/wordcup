package pl.pawelec.worldcup.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Country {

  @Id
  private int id;
  private String name;
}
