package stringadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringadder.domain.CustomDelimiterOperator.makeCustomDelimiterOperatorFromOperatorSelector;

class CustomDelimiterOperatorTest {

  @DisplayName("정적 팩토리 메서드 사용으로 객체 생성 테스트")
  @ValueSource(strings = {"//;\\n1;2;3", "//!\\n4!7!9", "//@\\n11@23@74"})
  @ParameterizedTest
  void makeCustomDelimiterOperatorFromOperatorSelectorTest(String given) {
    assertThat(makeCustomDelimiterOperatorFromOperatorSelector(given)).isEqualTo(makeCustomDelimiterOperatorFromOperatorSelector(given));
  }

  @DisplayName("커스텀 구분자 형태의 문자열이 들어오지 않으면 IllegalArgumentException 던짐")
  @ValueSource(strings = {"1@2@3", "1:2:3", "1,2,3"})
  @ParameterizedTest
  void invalidFormatTest(String given) {
    assertThatThrownBy(() -> makeCustomDelimiterOperatorFromOperatorSelector(given)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력값의 합계를 구하는 테스트")
  @CsvSource(value = {"//;\\n1;2;3$6", "//!\\n4!7!9$20", "//@\\n11@23@74$108"}, delimiter = '$')
  @ParameterizedTest
  void sumTest(String given, String expectation) {
    assertThat(makeCustomDelimiterOperatorFromOperatorSelector(given).sum()).isEqualTo(new Number(expectation));
  }
}
