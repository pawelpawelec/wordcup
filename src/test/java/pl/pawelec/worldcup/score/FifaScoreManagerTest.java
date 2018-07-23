package pl.pawelec.worldcup.score;

import org.junit.Test;
import org.mockito.Mockito;
import pl.pawelec.worldcup.domain.Country;

public class FifaScoreManagerTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIllegalArgumentExcepcion() throws Exception {

    CountryScoreRepository repository = Mockito.mock(CountryScoreRepository.class);
    FifaScoreManager manager = new FifaScoreManager(repository);
    manager.addScore(null, null, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkScoreParameters() throws Exception {

    CountryScoreRepository repository = Mockito.mock(CountryScoreRepository.class);
    FifaScoreManager manager = new FifaScoreManager(repository);
    Country poland = new Country(1, "Poland");
    Country germany = new Country(2, "Germany");
    manager.addScore(poland, germany, -1, 0);
  }
}