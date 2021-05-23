package lotto.domain.strategy;

import lotto.domain.LottoNumbers;

public interface RandomNumberGenerateStrategy {

  LottoNumbers generateNewNumbers();
}
