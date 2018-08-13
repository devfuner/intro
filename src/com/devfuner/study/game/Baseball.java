package com.devfuner.study.game;

import java.util.Scanner;

public class Baseball {

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("          숫자 야구 게임          ");
        System.out.println("==================================");
        System.out.println();

        int number1 = 3;
        int number2 = 2;
        int number3 = 6;
        System.out.print("정답 > " + number1);
        System.out.print(number2);
        System.out.println(number3);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를 입력하세요 > ");
            int guessNumber1 = scanner.nextInt();
            System.out.print("숫자를 입력하세요 > ");
            int guessNumber2 = scanner.nextInt();
            System.out.print("숫자를 입력하세요 > ");
            int guessNumber3 = scanner.nextInt();

            System.out.println("입력한 숫자 : " + guessNumber1);
            System.out.println("입력한 숫자 : " + guessNumber2);
            System.out.println("입력한 숫자 : " + guessNumber3);

            if (guessNumber1 == guessNumber2
                    || guessNumber2 == guessNumber3
                    || guessNumber1 == guessNumber3) {
                System.out.println("같은 숫자를 입력하면 안되요~");
            }

            int strikeCount = 0;
            int ballCount = 0;

            if (number1 == guessNumber1) {
                strikeCount = strikeCount + 1;
            } else if (number2 == guessNumber1 || number3 == guessNumber1) {
                ballCount = ballCount + 1;
            }

            if (number2 == guessNumber2) {
                strikeCount = strikeCount + 1;
            } else if (number1 == guessNumber2 || number3 == guessNumber2) {
                ballCount = ballCount + 1;
            }

            if (number3 == guessNumber3) {
                strikeCount = strikeCount + 1;
            } else if (number1 == guessNumber3 || number2 == guessNumber3) {
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
