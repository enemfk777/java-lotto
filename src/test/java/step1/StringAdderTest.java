package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class StringAdderTest {

	@DisplayName("null or empty string이 오면 0 반환")
	@ParameterizedTest
	@ValueSource(strings = {"null",""})
	void testNullOrEmpty(String string) {
		if("null".equals(string)) string = null;
		assertThat(StringAdder.calculate(string))
				.isEqualTo(0);
	}

	@DisplayName("숫자 하나를 입력 했을 때 해당 숫자를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3"})
	void testSingleInt(String string) {
		assertThat(StringAdder.calculate(string))
				.isEqualTo(Integer
							.parseInt(string));
	}

	@DisplayName("쉼표혹은 콜론으로 구분된 문자열을 구분자로 분리 후 합을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3*6", "4:5:8*17", "1:4,2*7", "1 , 2*3"}, delimiter = '*')
	void testDelimitedStringSum(String input, int result) {
		assertThat(StringAdder.calculate(input))
				.isEqualTo(result);
	}

	@DisplayName("커스텀 구분자를 포함한 문자열을 커스텀 구분자로 분리 후 합을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"//;\\n1;2;3*6", "//@\\n4@5@8*17"}, delimiter = '*')
	void testCustomDelimitedStringSum(String input, int result) {
		assertThat(StringAdder.calculate(input))
				.isEqualTo(result);
	}
}
