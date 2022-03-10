package com.roy.algorithm.inflearn.retry2.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 두 배열 합치기
//
// 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다. 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
// 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다. 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
// 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
// - 출력설명
// 오름차순으로 정렬된 배열을 출력합니다.
// - 입력예제 1
// 3
// 135
// 5
// 23679
// - 출력예제 1
// 12335679
@SuppressWarnings("NewClassNamingConvention")
public class CombiningTwoArray {

    public Integer[] solution1(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        answer.addAll(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        answer.addAll(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
        Collections.sort(answer);
        return answer.toArray(new Integer[0]);
    }

    public Integer[] solution2(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        int arr1Position = 0;
        int arr2Position = 0;
        while (arr1Position < arr1.length && arr2Position < arr2.length) {
            if (arr1[arr1Position] <= arr2[arr2Position]) {
                answer.add(arr1[arr1Position++]);
            } else {
                answer.add(arr2[arr2Position++]);
            }
        }
        while (arr1Position < arr1.length) {
            answer.add(arr1[arr1Position++]);
        }
        while (arr2Position < arr2.length) {
            answer.add(arr2[arr2Position++]);
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("두 배열 합치기")
    public void main() {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 6, 7, 9};
        Integer[] expectedAnswer = {1, 2, 3, 3, 5, 6, 7, 9};
        Integer[] answer1 = solution1(arr1, arr2);
        assertArrayEquals(expectedAnswer, answer1);

        Integer[] answer2 = solution2(arr1, arr2);
        assertArrayEquals(expectedAnswer, answer2);
    }

}
