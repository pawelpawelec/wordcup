package pl.pawelec.worldcup.score;

import org.springframework.stereotype.Service;
import pl.pawelec.worldcup.domain.Country;
import pl.pawelec.worldcup.domain.CountryScore;

@Service
public class ScoreManagerImpl implements ScoreManager {

  private CountryScoreRepository countryScoreRepository;

  public ScoreManagerImpl(CountryScoreRepository countryScore) {
    this.countryScoreRepository = countryScore;
  }

  @Override
  public void addScore(Country firstCountry, Country secondCountry, int firstScore, int secondScore) {
    CountryScore firstCountryScore = CountryScore.builder()
            .score(calculateScore(firstScore, secondScore))
            .idCountry(firstCountry.getId())
            .gainGoal(firstScore)
            .looseGoal(secondScore)
            .build();

    CountryScore secondCountryScore = CountryScore.builder()
            .score(calculateScore(secondScore, firstScore))
            .idCountry(secondCountry.getId())
            .gainGoal(secondScore)
            .looseGoal(firstScore)
            .build();
    countryScoreRepository.save(firstCountryScore);
    countryScoreRepository.save(secondCountryScore);
  }

  private int calculateScore(int firstScore, int secondScore) {

    if (firstScore > secondScore)
      return 3;
    else if (firstScore == secondScore)
      return 1;
    else
      return 0;
  }
}
