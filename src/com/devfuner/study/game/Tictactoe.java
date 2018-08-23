package com.devfuner.study.game;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe {


    public static void main(String[] args) {

        System.out.println("Tic Tac Toe!");
        System.out.println("게이머는 O 컴퓨터는 X");

        String[] board = {"", " ", " ", " ", " ", " ", " ", " ", " ", " "};

        while (true) {
            showBoard(board);

            if (selectedOfPlayer(board)) {

                continue;
            }

            if (checkWinner(board, "OOO", "게이머가 이겼습니다.")) {

                break;
            }

            // 컴퓨터가 선택하는 부분
            selectedOfComputer(board);

            if (checkWinner(board, "XXX", "컴퓨터가 이겼습니다.")) {

                break;
            }

            if (isGameOver(board)) {

                break;
            }
        }
    }

    private static boolean isGameOver(String[] board) {
        boolean endGame = true;

        for (int i = 1; i < board.length; i++) {
            if (board[i] == " ") {
                endGame = false;

                break;
            }
        }

        if (endGame) {
            showBoard(board);
            System.out.println("비겼습니다.");

            return true;
        }
        return false;
    }

    private static boolean selectedOfPlayer(String[] board) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("> ");
        int userInput = scanner.nextInt();

        if (userInput < 1 || userInput > 9) {
            System.out.println("1 ~ 9까지만 입력하세요.");

            return true;
        }

        if (board[userInput] != " ") {
            System.out.println("이미 입력한 칸입니다.");

            return true;
        }

        board[userInput] = "O";
        return false;
    }

    private static void selectedOfComputer(String[] board) {
        Random random = new Random();
        int max = 9;
        int min = 1;

        while (true) {
            int randomIndex = random.nextInt((max - min) + min) + 1;

            if (board[randomIndex] == " ") {
                board[randomIndex] = "X";

                break;
            }
        }
    }

    private static boolean checkWinner(String[] board, String playerOrComputer, String s) {
        if (playerOrComputer.equals(board[7] + board[8] + board[9])
                || playerOrComputer.equals(board[4] + board[5] + board[6])
                || playerOrComputer.equals(board[1] + board[2] + board[3])
                || playerOrComputer.equals(board[3] + board[6] + board[9])
                || playerOrComputer.equals(board[2] + board[5] + board[8])
                || playerOrComputer.equals(board[1] + board[4] + board[7])
                || playerOrComputer.equals(board[3] + board[5] + board[7])
                || playerOrComputer.equals(board[1] + board[5] + board[9])) {

            showBoard(board);

            System.out.println(s);

            return true;
        }
        return false;
    }

    private static void showBoard(String[] board) {
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
        System.out.println("-+-+-");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("-+-+-");
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
    }
}
