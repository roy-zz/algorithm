package com.roy.algorithm.inflearn.retry1.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 조합 구하기
//
// 1부터 N까지 번호가 적힌 구슬이 있습니다.이중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
// - 출력설명
// 첫 번째 줄에 결과를 출력합니다.
// 출력순서는 사전순으로 오름차순으로 출력합니다.
// - 입력예제 1
// 4 2
// - 출력예제 1
// 1 2
// 1 3
// 1 4
// 2 3
// 2 4
// 3 4
@SuppressWarnings("NewClassNamingConvention")
public class GetCombinations {

    private static final int MAX_NUMBER = 4;
    private static final int NUMBER_COUNT = 2;
    private static final int[][] EXPECTED_ANSWER = {
            {1, 2}, {1, 3}, {1, 4},
            {2, 3}, {2, 4}, {3, 4}
    };

    List<int[]> answer = new ArrayList<>();
    private final int[] tempCombination = new int[NUMBER_COUNT];

    public void solution1(int level, int startNumber) {
        if (level == NUMBER_COUNT) {
            answer.add(tempCombination.clone());
        } else {
            for (int i = startNumber; i <= MAX_NUMBER; i++) {
                tempCombination[level] = i;
                solution1(level + 1, i + 1);
            }
        }
    }


    @Test
    @DisplayName("조합 구하기")
    public void main() {
        solution1(0, 1);
        assertArrayEquals(EXPECTED_ANSWER, answer.toArray());
    }

}
