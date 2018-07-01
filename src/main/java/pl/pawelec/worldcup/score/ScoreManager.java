package pl.pawelec.worldcup.score;

import pl.pawelec.worldcup.domain.Country;

interface ScoreManager {

  void addScore(Country firstCountry, Country secondCountry, int firstScore, int secondScore);
}
