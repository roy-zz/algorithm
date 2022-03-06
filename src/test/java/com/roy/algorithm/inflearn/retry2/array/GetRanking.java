package com.roy.algorithm.inflearn.retry2.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 등수 구하기
//
// N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
// 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
// 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
// - 입력설명
// 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력 된다.
// - 출력설명
// 입력된 순서대로 등수를 출력한다.
// - 입력예제 1
// 5
// 87 89 92 100 76
// - 출력예제 1
// 4 3 2 1 5
@SuppressWarnings("NewClassNamingConvention")
public class GetRanking {

    public int[] solution1(int[] inputs) {
        int[] answer = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            int tempRank = 1;
            for (int other : inputs) {
                if (other > inputs[i]) {
                    tempRank++;
                }
            }
            answer[i] = tempRank;
        }
        return answer;
    }

    @Test
    @DisplayName("등수 구하기")
    public void main() {
        int[] inputs = {87, 89, 92, 100, 76};
        int[] expectedAnswer = {4, 3, 2, 1, 5};
        int[] answer = solution1(inputs);
        assertArrayEquals(expectedAnswer, answer);
    }

}
