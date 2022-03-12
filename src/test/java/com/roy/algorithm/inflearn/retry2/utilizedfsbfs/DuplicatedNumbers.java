package com.roy.algorithm.inflearn.retry2.utilizedfsbfs;

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

    private static final int TOTAL_NUMBER = 3;
    private static final int TOTAL_COUNT = 2;
    List<int[]> answer = new ArrayList<>();

    public void solution(int[] tempNumbers, int level) {
        if (level == TOTAL_COUNT) {
            answer.add(tempNumbers.clone());
        } else {
            for (int i = 1; i <= TOTAL_NUMBER; i++) {
                if (Objects.isNull(tempNumbers)) {
                    tempNumbers = new int[TOTAL_COUNT];
                }
                tempNumbers[level] = i;
                solution(tempNumbers, level + 1);
            }
        }
    }

    @Test
    @DisplayName("중복가능한 순열 구하기")
    public void main() {
        int[][] expectedAnswer = {
                {1, 1}, {1, 2}, {1, 3},
                {2, 1}, {2, 2}, {2, 3},
                {3, 1}, {3, 2}, {3, 3}
        };
        solution(null, 0);
        for (int i = 0; i < answer.size(); i++) {
            assertArrayEquals(answer.get(i), expectedAnswer[i]);
        }
    }

}
