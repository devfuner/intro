package com.devfuner.study.game;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe {
    public static void main(String[] args) {

        System.out.println("Tic Tac Toe!");
        System.out.println("게이머는 O 컴퓨터는 X");

        String[] board = {"", " ", " ", " ", " ", " ", " ", " ", " ", " "};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
            System.out.println("-+-+-");
            System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
            System.out.println("-+-+-");
            System.out.println(board[1] + "|" + board[2] + "|" + board[3]);

            System.out.println("> ");
            int userInput = scanner.nextInt();

            if (userInput < 1 || userInput > 9) {
                System.out.println("1 ~ 9까지만 입력하세요.");

                continue;
            }

            if (board[userInput] != " ") {
                System.out.println("이미 입력한 칸입니다.");

                continue;
            }

            board[userInput] = "O";

            if ("OOO".equals(board[7] + board[8] + board[9])
                    || "OOO".equals(board[4] + board[5] + board[6])
                    || "OOO".equals(board[1] + board[2] + board[3])
                    || "OOO".equals(board[3] + board[6] + board[9])
                    || "OOO".equals(board[2] + board[5] + board[8])
                    || "OOO".equals(board[1] + board[4] + board[7])
                    || "OOO".equals(board[3] + board[5] + board[7])
                    || "OOO".equals(board[1] + board[5] + board[9])) {

                System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
                System.out.println("-+-+-");
                System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
                System.out.println("-+-+-");
                System.out.println(board[1] + "|" + board[2] + "|" + board[3]);

                System.out.println("게이머가 이겼습니다.");

                break;
            }

            // 컴퓨터가 선택하는 부분
            while (true) {
                int randomIndex = random.nextInt((9 - 1) + 1) + 1;

                if (board[randomIndex] == " ") {
                    board[randomIndex] = "X";

                    break;
                }
            }

            if ("XXX".equals(board[7] + board[8] + board[9])
                    || "XXX".equals(board[4] + board[5] + board[6])
                    || "XXX".equals(board[1] + board[2] + board[3])
                    || "XXX".equals(board[3] + board[6] + board[9])
                    || "XXX".equals(board[2] + board[5] + board[8])
                    || "XXX".equals(board[1] + board[4] + board[7])
                    || "XXX".equals(board[3] + board[5] + board[7])
                    || "XXX".equals(board[1] + board[5] + board[9])) {

                System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
                System.out.println("-+-+-");
                System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
                System.out.println("-+-+-");
                System.out.println(board[1] + "|" + board[2] + "|" + board[3]);

                System.out.println("컴퓨터가 이겼습니다.");

                break;
            }

            boolean endGame = true;

            for (int i = 1; i < board.length; i++) {
                if (board[i] == " ") {
                    endGame = false;

                    break;
                }
            }

            if (endGame) {
                System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
                System.out.println("-+-+-");
                System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
                System.out.println("-+-+-");
                System.out.println(board[1] + "|" + board[2] + "|" + board[3]);

                System.out.println("비겼습니다.");

                break;
            }
        }
    }
}
