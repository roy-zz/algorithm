package com.roy.algorithm.inflearn.sorting;

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

    // HashMap을 활용한 방법 O(n)
    public String solution1(int[] numbers) {
        Map<Integer, Integer> mapOfNumber = new HashMap<>();
        for (int number : numbers) {
            if (mapOfNumber.containsKey(number)) {
                return "D";
            } else {
                mapOfNumber.put(number, 0);
            }
        }
        return "U";
    }

    // 선택 정렬 이후 중복을 확인하는 방법 O(nlogn)
    public String solution2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int index = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[index]) {
                    index = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = temp;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

    // 버블 정렬 이후 중복을 확인하는 방법 O(nlogn)
    public String solution3(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

    // 삽입 정렬 이후 중복을 확인하는 방법 O(nlogn)
    public String solution4(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (numbers[j] > temp) {
                    numbers[j + 1] = numbers[j];
                } else {
                    break;
                }
            }
            numbers[j + 1] = temp;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

    @Test
    @DisplayName("중복 확인")
    public void main() {
        int[] numbers = {20, 25, 52, 30, 39, 33, 43, 33};
        String expectedAnswer = "D";
        String answer1 = solution1(numbers);
        assertEquals(expectedAnswer, answer1);

        String answer2 = solution2(numbers);
        assertEquals(expectedAnswer, answer2);

        String answer3 = solution3(numbers);
        assertEquals(expectedAnswer, answer3);

        String answer4 = solution4(numbers);
        assertEquals(expectedAnswer, answer4);
    }

}
