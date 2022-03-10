package com.roy.algorithm.inflearn.retry2.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 공통 원소 구하기
//
// A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
// 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
// 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
// - 출력설명
// 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
// - 입력예제 1
// 5
// 1 3 9 5 2
// 5
// 3 2 5 7 8
// - 출력예제 1
// 2 3 5
@SuppressWarnings("NewClassNamingConvention")
public class FindingCommonElements {

    public Integer[] solution1(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int arr1Position = 0;
        int arr2Position = 0;
        while (arr1Position < arr1.length && arr2Position < arr2.length) {
            if (arr1[arr1Position] < arr2[arr2Position]) {
                arr1Position++;
            } else if (arr1[arr1Position] > arr2[arr2Position]) {
                arr2Position++;
            } else {
                answer.add(arr1[arr1Position++]);
                arr2Position++;
            }
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("공통 원소 구하기")
    public void main() {
        int[] arr1 = {1, 3, 9, 5, 2};
        int[] arr2 = {3, 2, 5, 7, 8};
        Integer[] expectedAnswer = {2, 3, 5};
        Integer[] answer1 = solution1(arr1, arr2);
        assertArrayEquals(expectedAnswer, answer1);
    }

}
