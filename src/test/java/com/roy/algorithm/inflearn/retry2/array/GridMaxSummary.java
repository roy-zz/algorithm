package com.roy.algorithm.inflearn.retry2.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 격자판 최대합
//
// 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
// 10 13 10 12 15
// 12 39 30 23 11
// 11 25 50 53 15
// 19 27 29 37 27
// 19 13 30 13 19
// N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력합니다.
// - 입력설명
// 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
// 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
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

    public int solution1(int[][] grid) {
        int maxRowSum = 0;
        int maxColumnSum = 0;
        int maxCrossSum = 0;

        for (int i = 0; i < grid.length; i++) {
            int tempRowSum = 0;
            // 열의 합
            for (int j = 0; j < grid.length; j++) {
                tempRowSum+=grid[j][i];
            }
            int tempColumnSum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                tempColumnSum+=grid[i][j];
            }
            maxRowSum = Math.max(maxRowSum, tempRowSum);
            maxColumnSum = Math.max(maxColumnSum, tempColumnSum);
        }

        int leftStartCrossSum = 0;
        int rightStartCrossSum = 0;
        for (int i = 0; i < grid.length; i++) {
            leftStartCrossSum+=grid[i][i];
            rightStartCrossSum+=grid[i][grid.length - 1 - i];
        }
        maxCrossSum = Math.max(leftStartCrossSum, rightStartCrossSum);
        return Math.max(maxRowSum, Math.max(maxColumnSum, maxCrossSum));

    }

    @Test
    @DisplayName("격자판 최대합")
    public void main() {
        int[][] grid = {
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        };
        int expectedAnswer = 155;
        int answer = solution1(grid);
        assertEquals(expectedAnswer, answer);
    }

}
