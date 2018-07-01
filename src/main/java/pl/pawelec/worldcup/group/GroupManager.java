package pl.pawelec.worldcup.group;

import pl.pawelec.worldcup.domain.Country;

public interface GroupManager {

  void addCountry(Country country);

  void deleteCountry(Country country);
}
