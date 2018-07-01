package pl.pawelec.worldcup.score;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawelec.worldcup.domain.CountryScore;

interface CountryScoreRepository extends JpaRepository<CountryScore, Integer> {

}
