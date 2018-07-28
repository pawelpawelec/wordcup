package pl.pawelec.worldcup.domain;

import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {

  @Test
  public void shouldCountryWwin() {

    int score = Score.calculateScore(4, 1);
    Assert.assertEquals(3, score);
  }

  @Test
  public void shouldCountryLoose() {

    int score = Score.calculateScore(1, 2);
    Assert.assertEquals(0, score);
  }

  @Test
  public void shouldEqualResult() {

    int score = Score.calculateScore(1, 1);
    Assert.assertEquals(1, score);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIllegalArgumentException() {
    int score = Score.calculateScore(-1, -2);
  }

}