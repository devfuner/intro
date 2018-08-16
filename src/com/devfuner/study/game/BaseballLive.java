package com.devfuner.study.game;

import java.util.*;

public class BaseballLive {

    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("     숫자 야구 게임      ");
        System.out.println("=========================");
        System.out.println();

        // 컴퓨터가 정한 숫자
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(6);

        System.out.print("컴퓨터가 정한 숫자 > ");
        System.out.println(numbers);

        Scanner scanner = new Scanner(System.in);

        List<Integer> guessNumbers = new ArrayList<>();

        while (true) {

            for (int i = 0; i < numbers.size(); i++) {
                System.out.print("숫자를 입력하세요 > ");
                guessNumbers.add(scanner.nextInt());
            }

            System.out.print("입력한 숫자 > ");
            System.out.println(guessNumbers);

            // 같은 숫자 입력 확인
            Set<Integer> setGuessNumbers = new HashSet<>(guessNumbers);
            if (setGuessNumbers.size() < 3) {
                System.out.println("같은 숫자를 입력하지 마세요.");
                guessNumbers.clear();
                continue;
            }

            int strikeCount = 0;
            int ballCount = 0;

            // 스트라이크, 볼 확인

            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < guessNumbers.size(); j++) {
                    if (i == j) {
                        if (numbers.get(i) == guessNumbers.get(i)) {
                            strikeCount += 1;
                        }
                    } else {
                        if (numbers.get(i) == guessNumbers.get(i)) {
                            ballCount += 1;
                        }
                    }
                }
            }

            int outCount = 3 - strikeCount - ballCount;
            System.out.println("strike > " + strikeCount);
            System.out.println("ball > " + ballCount);
            System.out.println("out > " + outCount);

            if (strikeCount == 3) {
                System.out.println("정답입니다. 축하합니다.");
                break;
            }
        }
    }
}
