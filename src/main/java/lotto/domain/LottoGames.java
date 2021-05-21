package lotto.domain;

import lotto.dto.OrderedInfos;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGames {

  private final List<LottoGame> games;

  public LottoGames(List<LottoGame> games) {
    this.games = games;
  }

  public TotalRankings matchRankings(LottoGame winningGame) {
    List<LottoRanking> matchResult = games.stream()
        .map(game -> game.checkWinning(winningGame))
        .collect(Collectors.toList());
    return new TotalRankings(matchResult);
  }

  public OrderedInfos peekGameInfos() {
    return new OrderedInfos(games);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoGames that = (LottoGames) o;
    return games.equals(that.games);
  }

  @Override
  public int hashCode() {
    return Objects.hash(games);
  }
}
