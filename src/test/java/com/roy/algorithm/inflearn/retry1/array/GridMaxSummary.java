package com.roy.algorithm.inflearn.retry1.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// 격자판 최대합
//
// 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
// 10 13 10 12 15
// 12 39 30 23 11
// 11 25 50 53 15
// 19 27 29 37 27
// 19 13 30 13 19
// N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합 니다.
// - 입력설명
// 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
// 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는 다.
// - 출력설명 최대합을 출력합니다.
// - 입력예제 1
// 5
// 10 13 10 12 15
// 12 39 30 23 11
// 11 25 50 53 15
// 19 27 29 37 27
// 19 13 30 13 19
// - 출력예제 1
// 155
@SuppressWarnings("NewClassNamingConvention")
public class GridMaxSummary {

    public int solution1(int[][] rows) {
        int maxSummary = Integer.MIN_VALUE;
        int rowCount = rows.length;
        for (int[] row : rows) {
            int tmpSum1 = Arrays.stream(row).sum();
            int tmpSum2 = 0;
            for (int j = 0; j < rowCount; j++) {
                tmpSum2 += row[j];
            }

            if (Math.max(tmpSum1, tmpSum2) > maxSummary) {
                maxSummary = Math.max(tmpSum1, tmpSum2);
            }
        }

        int tmpSum3 = 0;
        int tmpSum4 = 0;
        for (int i = 0; i < rowCount; i++) {
            tmpSum3 += rows[i][i];
            tmpSum4 += rows[i][rowCount - i - 1];
        }
        if (Math.max(tmpSum3, tmpSum4) > maxSummary) {
            maxSummary = Math.max(tmpSum3, tmpSum4);
        }
        return maxSummary;
    }

    @Test
    @DisplayName("격자판 최대합")
    public void main() {
        int expectedAnswer = 155;
        int[][] inputs1 = {
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        };
        int answer1 = solution1(inputs1);
        Assertions.assertEquals(expectedAnswer, answer1);
    }

}
