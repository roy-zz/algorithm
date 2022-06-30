package com.roy.algorithm.programmers.retry2.stackqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StockPriceSolution {

    @Test
    void problem() {
        int[] prices1 = {1, 2, 3, 2, 3};
        int[] expectedAnswer1 = {4, 3, 1, 1, 0};
        int[] answer1 = solution(prices1);
        assertArrayEquals(expectedAnswer1, answer1);
    }

    private int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}
