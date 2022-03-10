package com.roy.algorithm.inflearn.retry2.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 정렬
//
// N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 선택정렬입니다.
// - 입력설명
// 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
// 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
// - 출력설명
// 오름차순으로 정렬된 수열을 출력합니다.
// - 입력예제 1
// 6
// 13 5 11 7 23 15
// - 출력예제 1
// 5 7 11 13 15 23
// - 풀이
// 반드시 암기할 것!
@SuppressWarnings("NewClassNamingConvention")
public class Sorting {

    // 선택정렬
    public int[] solution1(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            int index = i;
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[index] > inputs[j]) {
                    index = j;
                }
            }
            int temp = inputs[index];
            inputs[index] = inputs[i];
            inputs[i] = temp;
        }
        return inputs;
    }

    // 버블정렬
    public int[] solution2(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs.length - i - 1; j++) {
                if (inputs[j] > inputs[j + 1]) {
                    int temp = inputs[j];
                    inputs[j + 1] = inputs[j];
                    inputs[j] = temp;
                }
            }
        }
        return inputs;
    }

    // 삽입정렬
    public int[] solution3(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            int temp = inputs[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (inputs[j] > temp) {
                    inputs[j + 1] = inputs[j];
                } else {
                    break;
                }
            }
            inputs[j + 1] = temp;
        }
        return inputs;
    }

    @Test
    @DisplayName("정렬")
    public void main() {
        int[] inputs = {13, 5, 11, 7, 23, 15};
        int[] expectedAnswer = {5, 7, 11, 13, 15, 23};
        int[] answer1 = solution1(inputs);
        assertArrayEquals(expectedAnswer, answer1);
        int[] answer2 = solution2(inputs);
        assertArrayEquals(expectedAnswer, answer2);
        int[] answer3 = solution3(inputs);
        assertArrayEquals(expectedAnswer, answer3);
    }

}
