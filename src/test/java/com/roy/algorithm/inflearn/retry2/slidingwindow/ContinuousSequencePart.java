package com.roy.algorithm.inflearn.retry2.slidingwindow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 연속 부분수열
//
// N개의 수로 이루어진 수열이 주어집니다.
// 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
// 만약 N=8, M=6이고 수열이 다음과 같다면
// 12131112
// 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
// - 입력설명
// 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다. 수열의 원소값은 1,000을 넘지 않는 자연수이다.
// - 출력설명
// 첫째 줄에 경우의 수를 출력한다.
// - 입력예제 1
// 8 6
// 1 2 1 3 1 1 1 2
// - 출력예제 1
// 3
@SuppressWarnings("NewClassNamingConvention")
public class ContinuousSequencePart {

    public int solution1(int length, int sum, int[] inputs) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int tempSum = 0;
        while (left < length && right < length) {
            if (tempSum == sum) {
                answer++;
                tempSum -= inputs[left++];
            } else if (tempSum > sum) {
                tempSum -= inputs[left++];
            } else {
                tempSum += inputs[right++];
            }
        }
        return answer;
    }

    public int solution2(int length, int sum, int[] inputs) {
        int answer = 0;
        int tempSum = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            tempSum += inputs[right];
            if (tempSum == sum) {
                answer++;
            }
            while (tempSum >= sum) {
                tempSum -= inputs[left++];
                if (tempSum == sum) {
                    answer++;
                }
            }
        }
        return answer;
    }

    @Test
    @DisplayName("연속 부분수열")
    public void main() {
        int[] inputs = {1, 2, 1, 3, 1, 1, 1, 2};
        int length = 8;
        int sum = 6;
        int expectedAnswer = 3;
        int answer1 = solution1(length, sum, inputs);
        assertEquals(expectedAnswer, answer1);
        int answer2 = solution2(length, sum, inputs);
        assertEquals(expectedAnswer, answer2);
    }

}
