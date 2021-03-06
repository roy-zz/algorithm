package com.roy.algorithm.inflearn.retry2.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 연속된 자연수의 합
//
// N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를
// 출력하는 프로그램을 작성하세요.
// 만약 N=15이면
// 7 + 8 = 15
// 4 + 5 + 6 = 15
// 1 + 2 + 3 + 4 + 5 = 15
// 와 같이 총 3가지의 경우가 존재한다.
// - 입력설명
// 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
// - 출력설명
// 첫 줄에 총 경우의 수를 출력합니다.
// - 입력예제 1
// 15
// - 출력예제 1
// 3
// HARD
@SuppressWarnings("NewClassNamingConvention")
public class SumOfNaturalNumber {

    public int solution1(int input) {
        int answer = 0;
        int[] numbers = new int[input];
        for (int i = 0; i < input; i++) {
            numbers[i] = i + 1;
        }
        int left = 0;
        int right = 0;
        int tempSum = 0;
        while (right < input) {
            if (tempSum < input) {
                tempSum += numbers[right++];
            } else if (tempSum > input) {
                tempSum -= numbers[left++];
            } else {
                answer++;
                tempSum += numbers[right++];
            }
        }
        return answer;
    }

    public int solution2(int input) {
        int answer = 0;
        int count = 1;
        input--;
        while (input > 0) {
            count++;
            input -= count;
            if (input % count == 0) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("연속된 자연수의 합")
    public void main() {
        int expectedAnswer = 3;
        int answer1 = solution1(15);
        assertEquals(expectedAnswer, answer1);
        int answer2 = solution2(15);
        assertEquals(expectedAnswer, answer2);
    }

}
