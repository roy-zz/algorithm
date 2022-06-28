package com.roy.algorithm.kakaostyle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem1 {

    @Test
    void problem() {
        int[] input1_1 = {5, 3, 9, 13};
        int input1_2 = 8;
        boolean expectedAnswer1 = true;
        boolean answer1 = solution(input1_1, input1_2);
        assertEquals(expectedAnswer1, answer1);

        int[] input2_1 = {5, 3, 9, 13};
        int input2_2 = 7;
        boolean expectedAnswer2 = false;
        boolean answer2 = solution(input2_1, input2_2);
        assertEquals(expectedAnswer2, answer2);
    }

    public boolean solution(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < n) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
