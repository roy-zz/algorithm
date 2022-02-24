package com.roy.algorithm.inflearn.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 정렬
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
@SuppressWarnings("NewClassNamingConvention")
public class Sorting {

    // 선택 정렬을 통한 해결 방법
    public int[] solution1(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            // 기본 인덱스는 i로 한다.
            int index = i;
            // i 이후부터 순회하며 i번째보다 작은 수를 찾아간다.
            // index 계속 더 작은 값을 찾아가며 가장 작은 값을 가진 값의 인덱스로 결정된다.
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[j] < inputs[index]) {
                    index = j;
                }
            }
            // i번 인덱스의 값을 복사하고
            int temp = inputs[i];
            // 위의 로직에서 찾은 가장 작은 값을 i값에 넣는다.
            inputs[i] = inputs[index];
            // 기존 i번 인덱스의 값을 위의 로직에서 찾은 가장 작은 값이 있던 인덱스에 넣는다.
            inputs[index] = temp;
        }
        return inputs;
    }

    // 버블 정렬을 통한 해결 방법
    public int[] solution2(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            // 배열의 끝의 직전까지 순회한다.
            for (int j = 0; j < inputs.length - i - 1; j++) {
                if (inputs[j] > inputs[j + 1]) {
                    int tmp = inputs[j];
                    inputs[j] = inputs[j + 1];
                    inputs[j + 1] = tmp;
                }
            }
        }
        return inputs;
    }

    // 삽입 정렬을 통한 해결 방법
    public int[] solution3(int[] inputs) {
        for (int i = 1; i < inputs.length; i++) {
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
