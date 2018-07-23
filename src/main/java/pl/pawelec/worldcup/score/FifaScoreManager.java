package pl.pawelec.worldcup.score;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import pl.pawelec.worldcup.domain.Country;
import pl.pawelec.worldcup.domain.CountryScore;

import javax.transaction.Transactional;

@Service
public class FifaScoreManager implements ScoreManager {

  private CountryScoreRepository countryScoreRepository;

  public FifaScoreManager(CountryScoreRepository countryScore) {
    this.countryScoreRepository = countryScore;
  }

  @Override
  @Transactional
  public void addScore(@NonNull Country firstCountry, @NonNull Country secondCountry, int firstScore, int secondScore) {
    CountryScore firstCountryScore = new CountryScore(firstCountry.getId(),
            firstScore,
            secondScore);
    if (firstScore < 0 || secondScore < 0) {
      throw new IllegalArgumentException("Score cannot be less than 0");
    }
    CountryScore secondCountryScore = new CountryScore(firstCountry.getId(),
            secondScore,
            firstScore);

    countryScoreRepository.save(firstCountryScore);
    countryScoreRepository.save(secondCountryScore);
  }
}
