package lotto.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int askOfAmount() {
        System.out.println("구입할 금액을 입력하세요.");
        int inputOfAmount = scanner.nextInt();
        nextLine();
        return inputOfAmount;
    }

    public static String askOfWinningNumbers() {
        System.out.println("당첨번호를 입력하세요.");
        return scanner.nextLine();
    }

    public static int askOfWinningBonusNumber() {
        System.out.println("보너스 번호를 입력하세요.");
        int inputOfBonus = scanner.nextInt();
        nextLine();
        return inputOfBonus;
    }

    private static void nextLine() {
        scanner.nextLine();
    }
}
