package com.devfuner.study.game;

import java.util.*;

public class Baseball {

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("          숫자 야구 게임          ");
        System.out.println("==================================");
        System.out.println();

        Random random = new Random();
        Set<Integer> setNumbers = new HashSet<>();
        while (setNumbers.size() < 3) {
            setNumbers.add(random.nextInt((9 - 1) + 1) + 1);  // 1 ~ 9
        }

        List<Integer> numbers = new ArrayList<>(setNumbers);
        Collections.shuffle(numbers);
        System.out.println("정답 > " + numbers);

        List<Integer> guessNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print("숫자를 입력하세요 > ");
                guessNumbers.add(scanner.nextInt());
            }
            System.out.println("입력한 숫자 : " + guessNumbers);

            Set<Integer> setGuessNumbers = new HashSet<>(guessNumbers);
            if (setGuessNumbers.size() < 3) {
                System.out.println("같은 숫자를 입력하면 안되요~");
                guessNumbers.clear();

                continue;
            }

            int strikeCount = 0;
            int ballCount = 0;

            for (int i = 0; i < guessNumbers.size(); i++) {
                if (numbers.get(i) == guessNumbers.get(i)) {
                    strikeCount += 1;
                } else if (numbers.contains(guessNumbers.get(i))) {
                    ballCount += 1;
                }
            }

            if (strikeCount == 3) {
                System.out.println("정답입니다~");
                break;
            }

            int outCount = 3 - strikeCount - ballCount;
            System.out.println(strikeCount + "스트라이크");
            System.out.println(ballCount + "볼");
            System.out.println(outCount + "아웃");

            guessNumbers.clear();
        }
    }
}
