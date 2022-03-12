package com.roy.algorithm.inflearn.retry2.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 미로탐색(DFS)
//
// 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
// 출발점은 격 자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다.
// 격자판의 1은 벽이고, 0은 통로이다. 격 자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
// S 0 0 0 0 0 0
// 0 1 1 1 1 1 0
// 0 0 0 1 0 0 0
// 1 1 0 1 0 1 1
// 1 1 0 0 0 0 1
// 1 1 0 1 1 0 0
// 1 0 0 0 0 0 E
// 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
// - 입력설명
// 7*7 격자판의 정보가 주어집니다.
// - 출력설명
// 첫 번째 줄에 경로의 가지수를 출력한다.
// - 입력예제 1
// 0 0 0 0 0 0 0
// 0 1 1 1 1 1 0
// 0 0 0 1 0 0 0
// 1 1 0 1 0 1 1
// 1 1 0 0 0 0 1
// 1 1 0 1 1 0 0
// 1 0 0 0 0 0 0
// - 출력예제 1
// 8
@SuppressWarnings("NewClassNamingConvention")
public class ExploringMaze {

    private static final int[][] MAZE = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0}
    };
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private static final int[][] CHECK_ARRAY = new int[7][7];
    private int answer = 0;

    public void solution(int currentX, int currentY) {
        if (currentX == 6 && currentY == 6) {
            answer++;
        } else {
            for (int[] direction : DIRECTIONS) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                if (nextX >= 0 && nextX <= 6
                        && nextY >= 0 && nextY <= 6
                        && CHECK_ARRAY[nextX][nextY] == 0
                        && MAZE[nextX][nextY] == 0) {
                    CHECK_ARRAY[nextX][nextY] = 1;
                    solution(nextX, nextY);
                    CHECK_ARRAY[nextX][nextY] = 0;
                }
            }
        }
    }

    @Test
    @DisplayName("미로탐색(DFS)")
    public void main() {
        CHECK_ARRAY[0][0] = 1;
        solution(0, 0);
        assertEquals(8, answer);
    }

}
