package com.devfuner.study.game;

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("          숫자 야구 게임          ");
        System.out.println("==================================");
        System.out.println();

        int[] numbers = {2, 3, 6};
        System.out.println("정답 > " + Arrays.toString(numbers));

        int[] guessNumbers = new int[3];

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < guessNumbers.length; i++) {
                System.out.print("숫자를 입력하세요 > ");
                guessNumbers[i] = scanner.nextInt();
            }
            System.out.println("입력한 숫자 : " + Arrays.toString(numbers));

            if (guessNumbers[0] == guessNumbers[1]
                    || guessNumbers[1] == guessNumbers[2]
                    || guessNumbers[0] == guessNumbers[2]) {
                System.out.println("같은 숫자를 입력하면 안되요~");
                System.exit(0);
            }

            int strikeCount = 0;
            int ballCount = 0;

            if (numbers[0] == guessNumbers[0]) {
                strikeCount = strikeCount + 1;
            } else if (numbers[1] == guessNumbers[0] || numbers[2] == guessNumbers[0]) {
                ballCount = ballCount + 1;
            }

            if (numbers[1] == guessNumbers[1]) {
                strikeCount = strikeCount + 1;
            } else if (numbers[0] == guessNumbers[1] || numbers[2] == guessNumbers[1]) {
                ballCount = ballCount + 1;
            }

            if (numbers[2] == guessNumbers[2]) {
                strikeCount = strikeCount + 1;
            } else if (numbers[0] == guessNumbers[2] || numbers[1] == guessNumbers[2]) {
                ballCount = ballCount + 1;
            }

            if (strikeCount == 3) {
                System.out.println("정답입니다~");
                break;
            }

            int outCount = 3 - strikeCount - ballCount;
            System.out.println(strikeCount + "스트라이크");
            System.out.println(ballCount + "볼");
            System.out.println(outCount + "아웃");
        }
    }
}
