package com.roy.algorithm.inflearn.retry2.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 중복 확인
//
// 현수네 반에는 N명의 학생들이 있습니다.
// 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어내라고 했습니다.
// 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
// N 명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
// 두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
// - 출력설명
// 첫 번째 줄에 D 또는 U를 출력한다.
// - 입력예제 1
// 8
// 20 25 52 30 39 33 43 33
// - 출력예제 1
// D
@SuppressWarnings("NewClassNamingConvention")
public class DuplicateCheck {

    // 이중 반복문을 사용하는 경우 O(n * n)
    public char solution1(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[i] == inputs[j]) {
                    return 'D';
                }
            }
        }
        return 'U';
    }

    // Map을 사용하여 푸는 경우 O(n)
    public char solution2(int[] inputs) {
        Map<Integer, Integer> mapOfInputs = new HashMap<>();
        for (int i : inputs) {
            if (mapOfInputs.containsKey(i)) {
                return 'D';
            } else {
                mapOfInputs.put(i, i);
            }
        }
        return 'U';
    }

    // 선택정렬 이후 중복 확인 O(nlogn)
    public char solution3(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            int index = i;
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[index] > inputs[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = inputs[index];
                inputs[index] = inputs[i];
                inputs[i] = temp;
            }
        }
        for (int i = 0; i < inputs.length - 1; i++) {
            if (inputs[i] == inputs[i + 1]) {
                return 'D';
            }
        }
        return 'U';
    }

    // 버블정렬 이후 중복 확인 O(nlogn)
    public char solution4(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs.length - i - 1; j++) {
                if (inputs[j] > inputs[j + 1]) {
                    int temp = inputs[j];
                    inputs[j] = inputs[j + 1];
                    inputs[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < inputs.length - 1; i++) {
            if (inputs[i] == inputs[i + 1]) {
                return 'D';
            }
        }
        return 'U';
    }

    // 삽입정렬 이후 중복 확인 O(nlogn)
    public char solution5(int[] inputs) {
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
        for (int i = 0; i < inputs.length - 1; i++) {
            if (inputs[i] == inputs[i + 1]) {
                return 'D';
            }
        }
        return 'U';
    }

    @Test
    @DisplayName("중복 확인")
    public void main() {
        int[] inputs = {20, 25, 52, 30, 39, 33, 43, 33};
        char expectedAnswer = 'D';
        char answer1 = solution1(inputs);
        assertEquals(expectedAnswer, answer1);

        char answer2 = solution2(inputs);
        assertEquals(expectedAnswer, answer2);

        char answer3 = solution3(inputs);
        assertEquals(expectedAnswer, answer3);

        char answer4 = solution4(inputs);
        assertEquals(expectedAnswer, answer4);

        char answer5 = solution5(inputs);
        assertEquals(expectedAnswer, answer5);
    }

}
