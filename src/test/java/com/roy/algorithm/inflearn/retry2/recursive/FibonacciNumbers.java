package com.roy.algorithm.inflearn.retry2.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 피보나치 재귀 (메모이제이션)
//
// 1) 피보나치 수열을 출력한다.
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
// - 풀이
// 메모이제이션을 통한 시간복잡도 감소 기억할 것!
@SuppressWarnings("NewClassNamingConvention")
public class FibonacciNumbers {

    private int[] fibonacciArray1;
    private int[] fibonacciArray2;

    public int solution1(int input) {
        if (input == 1 || input == 2) {
            return fibonacciArray1[input - 1] = 1;
        } else {
            return fibonacciArray1[input - 1] = solution1(input - 2) + solution1(input - 1);
        }
    }

    public int solution2(int input) {
        if (fibonacciArray2[input - 1] != 0) {
            return fibonacciArray2[input - 1];
        } else if (input == 1 || input == 2){
            return fibonacciArray2[input - 1] = 1;
        } else {
            return fibonacciArray2[input - 1] = solution2(input - 2) + solution2(input - 1);
        }
    }

    @Test
    @DisplayName("피보나치 재귀 (메모이제이션")
    public void main() {
        int input = 10;
        int[] expectedAnswer = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        fibonacciArray1 = new int[input];
        solution1(input);
        assertArrayEquals(expectedAnswer, fibonacciArray1);

        fibonacciArray2 = new int[input];
        solution2(input);
        assertArrayEquals(expectedAnswer, fibonacciArray2);
    }

}
