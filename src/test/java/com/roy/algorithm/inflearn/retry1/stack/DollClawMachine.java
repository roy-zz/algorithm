package com.roy.algorithm.inflearn.retry1.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
public class DollClawMachine {

    public int solution1(int[][] board, int gameCount, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < gameCount; i++) {
            int temp = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    temp = board[j][moves[i] - 1];
                    // 하나를 꺼냈으니 원래 있던 숫자의 자리를 0으로 바꾸어준다.
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
            if (temp != 0) {
                if (!basket.isEmpty() && basket.peek() == temp) {
                    basket.pop();
                    // 한번에 두 개가 터지기 때문에 += 2
                    answer += 2;
                } else {
                    basket.push(temp);
                }
            }
        }
        return answer;
    }

    @Test
    @DisplayName("크레인 인형뽑기")
    public void main() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int gameCount = 8;
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int expectedAnswer = 4;
        int answer1 = solution1(board, gameCount, moves);
        assertEquals(expectedAnswer, answer1);
    }

}
