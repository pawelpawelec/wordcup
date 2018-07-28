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
  public void addScore(@NonNull Country firstCountry,
                       @NonNull Country secondCountry,
                       int firstScore,
                       int secondScore) {
    CountryScore firstCountryScore = CountryScore.of(firstCountry.getId(),
            firstScore,
            secondScore);
    CountryScore secondCountryScore = CountryScore.of(firstCountry.getId(),
            secondScore,
            firstScore);

    countryScoreRepository.save(firstCountryScore);
    countryScoreRepository.save(secondCountryScore);
  }
}
