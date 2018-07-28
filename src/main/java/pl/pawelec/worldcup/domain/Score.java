package pl.pawelec.worldcup.domain;

import com.google.common.base.Preconditions;

class Score {

  private Score() {
  }

  static int calculateScore(int gainGoal, int looseGoal) {

    Preconditions.checkArgument(gainGoal >= 0);
    Preconditions.checkArgument(looseGoal >= 0);

    if (gainGoal > looseGoal)
      return 3;
    else if (gainGoal == looseGoal)
      return 1;
    else
      return 0;
  }
}
