package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGames {

	private final List<LottoGame> lottoGames;

	public LottoGames(List<LottoGame> lottoGames) {
		this.lottoGames = lottoGames;
	}

	public List<LottoGame> getLottoGames() {
		return lottoGames;
	}

	public int getGameSize() {
		return lottoGames.size();
	}

	public ConfirmResults confirmPrize(GameWinningCondition lastWeekPrize) {
		return new ConfirmResults(getConfirmResults(lastWeekPrize));
	}

	private List<PrizeGrade> getConfirmResults(GameWinningCondition lastWeekPrize) {
		return lottoGames.stream()
				.map(lottoGame -> lottoGame.confirmPrize(lastWeekPrize))
				.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoGames that = (LottoGames) o;
		return lottoGames.equals(that.lottoGames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoGames);
	}
}
