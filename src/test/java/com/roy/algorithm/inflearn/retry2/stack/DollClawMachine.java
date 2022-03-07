package com.roy.algorithm.inflearn.retry2.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

// - 풀이
// 꺼내고나서 0으로 바꾸는거 까먹지말자!
@SuppressWarnings("NewClassNamingConvention")
public class DollClawMachine {

    public int solution1(int[][] dolls, int[] works) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int work : works) {
            int tempDoll = 0;
            for (int i = 0; i < dolls.length; i++) {
                if (dolls[i][work - 1] != 0) {
                    tempDoll = dolls[i][work - 1];
                    dolls[i][work - 1] = 0;
                    break;
                }
            }
            if (tempDoll != 0) {
                if (!basket.isEmpty() && basket.peek() == tempDoll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(tempDoll);
                }
            }
        }
        return answer;
    }

    @Test
    @DisplayName("크레인 인형뽑기(카카오)")
    public void main() {
        int[][] dolls = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] works = {1, 5, 3, 5, 1, 2, 1, 4};
        int expectedAnswer = 4;
        int answer = solution1(dolls, works);
        assertEquals(expectedAnswer, answer);
    }

}
