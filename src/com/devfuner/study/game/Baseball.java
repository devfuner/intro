package com.devfuner.study.game;

import java.util.Scanner;

public class Baseball {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 > ");
        int guessNumber = scanner.nextInt();

        System.out.println("입력한 숫자 : " + guessNumber);
    }
}
