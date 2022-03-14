package com.roy.algorithm.inflearn.retry2.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 섬나라 아일랜드(DFS)
//
// N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
// 각 섬은 1로 표시되어 상하좌 우와 대각선으로 연결되어 있으며, 0은 바다입니다.
// 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
// 1 1 0 0 0 1 0
// 0 1 1 0 1 1 0
// 0 1 0 0 0 0 0
// 0 0 0 1 0 1 1
// 1 1 0 1 1 0 0
// 1 0 0 0 1 0 0
// 1 0 1 0 1 0 0
// 만약 위와 같다면 섬의 개수는 5개입니다.
// - 입력설명
// 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다. 두 번째 줄부터 격자판 정보가 주어진다.
// - 출력설명
// 첫 번째 줄에 섬의 개수를 출력한다.
// - 입력예제 1
// 7
// 1 1 0 0 0 1 0
// 0 1 1 0 1 1 0
// 0 1 0 0 0 0 0
// 0 0 0 1 0 1 1
// 1 1 0 1 1 0 0
// 1 0 0 0 1 0 0
// 1 0 1 0 1 0 0
// - 출력예제 1
// 5
@SuppressWarnings("NewClassNamingConvention")
public class IslandDFS {

    private static final int[][] MAP = {
            {1, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 0, 0}
    };
    private static final int[][] DIRECTIONS = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public void solution(int x, int y) {
        for (int[] direction : DIRECTIONS) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (nextX >= 0 && nextX < MAP.length
                    && nextY >= 0 && nextY < MAP.length
                    && MAP[nextX][nextY] == 1) {
                MAP[nextX][nextY] = 0;
                solution(nextX, nextY);
            }
        }
    }

    @Test
    @DisplayName("섬나라 아일랜드(DFS)")
    public void main() {
        int answer = 0;
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP.length; j++) {
                if (MAP[i][j] == 1) {
                    answer++;
                    MAP[i][j] = 0;
                    solution(i, j);
                }
            }
        }
        assertEquals(5, answer);
    }

}
