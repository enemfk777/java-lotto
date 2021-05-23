package lotto.dto;

import lotto.domain.LottoRanking;
import lotto.domain.TotalRankings;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnalysisSheetTest {

  private TotalRankings givenTotalRankings;
  private long givenPurchasingAmount = 1000;

  @BeforeEach
  void setUp() {
    List<LottoRanking> givenRankings = Lists.newArrayList(LottoRanking.FOURTH);
    givenTotalRankings = new TotalRankings(givenRankings);
  }

  @DisplayName("당첨결과를 정해진 포맷으로 출력한다.")
  @Test
  void toStringPrizeInfosTest() {
    //given
    String expectation = "3개 일치 (5000원)- 1개";
    //when & then
    assertThat(new AnalysisSheet(givenTotalRankings, givenPurchasingAmount).toStringPrizeInfos()).hasToString(expectation);
  }

  @DisplayName("손익률을 정해진 포맷으로 출력한다.")
  @Test
  void toStringYieldAnalysis() {
    //given
    String expectation = "총 수익률은 5.00입니다. (이득임)";
    //when & then
    assertThat(new AnalysisSheet(givenTotalRankings, givenPurchasingAmount).toStringYieldAnalysis()).hasToString(expectation);
  }

}
