package com.roy.algorithm.inflearn.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 순열 구하기
//
// 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
// - 입력설명
// 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다. 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
// - 출력설명
// 첫 번째 줄에 결과를 출력합니다.
// 출력순서는 사전순으로 오름차순으로 출력합니다.
// - 입력예제 1
// 3 2
// 3 6 9
// - 출력예제 1
// 3 6
// 3 9
// 6 3
// 6 9
// 9 3
// 9 6
@SuppressWarnings("NewClassNamingConvention")
public class Permutation {

    private static final int[] NUMBERS = {3, 6, 9};
    private static final int COUNT = 2;
    private static final int[][] EXPECTED_ANSWER = {
            {3, 6}, {3, 9},
            {6, 3}, {6, 9},
            {9, 3}, {9, 6}
    };
    private final List<int[]> answer = new ArrayList<>();
    private final int[] checkArray = new int[NUMBERS.length];

    public void solution1(int level, int[] tempNumbers) {
        if (level == COUNT) {
            answer.add(tempNumbers.clone());
        } else {
            for (int i = 0; i < NUMBERS.length; i++) {
                if (Objects.isNull(tempNumbers)) {
                    tempNumbers = new int[2];
                }
                if (checkArray[i] == 0) {
                    checkArray[i] = 1;
                    tempNumbers[level] = NUMBERS[i];
                    solution1(level + 1, tempNumbers);
                    checkArray[i] = 0;
                }
            }
        }
    }

    @Test
    @DisplayName("순열 구하기")
    public void main() {
        solution1(0, null);
        for (int i = 0; i < EXPECTED_ANSWER.length; i++) {
            assertArrayEquals(EXPECTED_ANSWER[i], answer.get(i));
        }
    }

}
