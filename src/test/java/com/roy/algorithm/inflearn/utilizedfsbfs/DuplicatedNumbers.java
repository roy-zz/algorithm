package com.roy.algorithm.inflearn.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 중복가능한 순열 구하기
//
// 1부터 N까지 번호가 적힌 구슬이 있습니다.
// 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
// - 입력설명
// 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
// - 출력설명
// 첫 번째 줄에 결과를 출력합니다.
// 출력순서는 사전순으로 오름차순으로 출력합니다.
// - 입력예제 1
// 3 2
// - 출력예제 1
// 1 1
// 1 2
// 1 3
// 2 1
// 2 2
// 2 3
// 3 1
// 3 2
// 3 3
@SuppressWarnings("NewClassNamingConvention")
public class DuplicatedNumbers {

    private static final int NUMBERS = 3;
    private static final int COUNT = 2;
    private static final Integer[][] EXPECTED_ANSWER = {
            {1, 1}, {1, 2}, {1, 3},
            {2, 1}, {2, 2}, {2, 3},
            {3, 1}, {3, 2}, {3, 3}
    };
    private final List<Integer[]> numbersOfCases = new ArrayList<>();

    public void solution1(int level, Integer[] tempNumbers) {
        if (level == COUNT) {
            numbersOfCases.add(tempNumbers.clone());
        } else {
            for (int i = 1; i <= NUMBERS; i++) {
                if (Objects.isNull(tempNumbers)) {
                    tempNumbers = new Integer[COUNT];
                }
                tempNumbers[level] = i;
                solution1(level + 1, tempNumbers);
            }
        }
    }

    @Test
    @DisplayName("중복가능한 순열 구하기")
    public void main() {
        solution1(0, null);
        for (int i = 0; i < NUMBERS * NUMBERS; i++) {
            assertArrayEquals(EXPECTED_ANSWER[i], (Integer[]) numbersOfCases.toArray()[i]);
        }
    }

}
