package com.roy.algorithm.inflearn.array;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 피보나치 수열
//
// 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
// - 입력설명
// 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
// - 출력설명
// 첫 줄에 피보나치 수열을 출력합니다.
// - 입력예제 1
// 10
// - 출력예제 1
// 1 1 2 3 5 8 13 21 34 55
@SuppressWarnings("NewClassNamingConvention")
public class FibonacciNumbers {

    public int[] solution1(int input) {
        int[] answer = new int[input];
        for (int i = 0; i < input; i++) {
            if (i <= 1) {
                answer[i] = 1;
            } else {
                answer[i] = (answer[i - 2] + answer[i - 1]);
            }
        }
        return answer;
    }

    @Test
    @DisplayName("피보나치 수열")
    public void main() {
        int[] expectedAnswer = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        int[] answer = solution1(10);
        assertArrayEquals(answer, expectedAnswer);
    }

}
