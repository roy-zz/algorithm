package com.roy.algorithm.inflearn.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 피보나치 재귀 (메모이제이션)
//
// 1) 피보나키 수열을 출력한다.
// 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 2) 입력은 피보나치 수열의 총 항의 수이다.
// 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
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

    private int[] fibonacci;
    private int[] fibonacciMemo;

    public int solution1(int loop) {
        switch (loop) {
            case 1:
            case 2:
                return 1;
            default :
                return (solution1(loop - 2) + solution1(loop - 1));
        }
    }

    public int solution2(int loop) {
        switch (loop) {
            case 1:
            case 2:
                return fibonacci[loop - 1] = 1;
            default:
                return fibonacci[loop - 1] = solution2(loop - 2) + solution2(loop - 1);
        }
    }

    // 메모이제이션을 활용한 방법
    public int solution3(int loop) {
        if (fibonacciMemo[loop  - 1] != 0) {
            return fibonacciMemo[loop - 1];
        }
        switch (loop) {
            case 1:
            case 2:
                return fibonacciMemo[loop - 1] = 1;
            default:
                return fibonacciMemo[loop - 1] = solution3(loop - 2) + solution3(loop - 1);
        }
    }

    @Test
    @DisplayName("피보나치 재귀 (메모이제이션")
    public void main() {
        int loop = 10;
        int expectedAnswer1 = 55;
        int answer1 = solution1(loop);
        assertEquals(expectedAnswer1, answer1);

        fibonacci = new int[loop];
        int[] expectedAnswer2 = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        solution2(loop);
        assertArrayEquals(expectedAnswer2, fibonacci);

        fibonacciMemo = new int[loop];
        int[] expectedAnswer3 = expectedAnswer2.clone();
        solution3(loop);
        assertArrayEquals(expectedAnswer3, fibonacciMemo);
    }

}
