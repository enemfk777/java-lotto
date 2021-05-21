package lotto.ui;

import lotto.dto.OrderSheet;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

  private static final String PLEASE_INPUT_INTEGER = "자연수로 입력 해 주세요.";
  private static final String PLEASE_INPUT_PURCHASING_PRICE = "구입금액을 입력해 주세요.";
  private static final String PLEASE_INPUT_LAST_WEEK_PRIZE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final Pattern SPACE = Pattern.compile("\\s");
  private static final Pattern COMMA = Pattern.compile(",");

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {}

  public static OrderSheet orderNewGames() {
    return new OrderSheet(sayQuestionAndGetLong(PLEASE_INPUT_PURCHASING_PRICE));
  }

  public static List<Integer> inputWinningNumbers() {
    return sayQuestionAndGetStringArray(PLEASE_INPUT_LAST_WEEK_PRIZE);
  }

  private static long sayQuestionAndGetLong(String question) {
    System.out.println(question);
    return getLongValue();
  }

  private static List<Integer> sayQuestionAndGetStringArray(String question) {
    System.out.println(question);
    String input = getStringValue();
    return parsInts(splitByDelimiter(input));
  }

  private static List<Integer> parsInts(String[] numberStrings) {
    return Arrays.stream(numberStrings)
            .map(InputView::parseInt)
            .collect(Collectors.toList());

  }

  private static int parseInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      throw new IllegalArgumentException(PLEASE_INPUT_INTEGER);
    }
  }

  private static String[] splitByDelimiter(String input) {
    String replaced = SPACE.matcher(input).replaceAll("");
    return COMMA.split(replaced);
  }

  private static long getLongValue() {
    try {
      return SCANNER.nextLong();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(PLEASE_INPUT_INTEGER, e);
    } finally {
      SCANNER.nextLine();
    }
  }

  private static String getStringValue() {
    try {
      return SCANNER.next();
    } finally {
      SCANNER.nextLine();
    }
  }
}
