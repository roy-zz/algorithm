package com.roy.algorithm.inflearn.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 경로 탐색(인접행렬)
// 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
// 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
// 1 2 3 4 5
// 1 2 5
// 1 3 4 2 5
// 1 3 4 5
// 1 4 2 5
// 1 4 5
// 총 5 가지입니다.
// - 입력설명
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연 결정보가 주어진다.
// - 출력설명
// 총 가지수를 출력한다.
// - 입력예제 1
// 5 9
// 1 2
// 1 3
// 1 4
// 2 1
// 2 3
// 2 5
// 3 4
// 4 2
// 4 5
// - 출력예제 1
// 6
@SuppressWarnings("NewClassNamingConvention")
public class PathSearchByArray {

    private static final int VERTEXES = 5;
    private static final int[] CHECK_ARRAY = new int[VERTEXES + 1];
    private static final int[][] GRAPH = {
            // 0,0 0,1 0,2 0,3 0,4 0,5
            {0, 0, 0, 0, 0, 0},
            // 1,0 1,1 1,2 1,3 1,4 1,5
            {0, 0, 1, 1, 1, 0},
            // 2,0 2,1 2,2 2,3 2,4 2,5
            {0, 1, 0, 1, 0, 1},
            // 3,0
            {0, 0, 0, 0, 1, 0},
            // 4,0
            {0, 0, 1, 0, 0, 1},
            // 5,0
            {0, 0, 0, 0, 0, 0}
    };
    private int answer = 0;

    public void solution1(int vertex) {
        if (vertex == VERTEXES) {
            answer++;
        }
        for (int i = 1; i <= VERTEXES; i++) {
            if (GRAPH[vertex][i] == 1 && CHECK_ARRAY[i] == 0) {
                CHECK_ARRAY[i] = 1;
                solution1(i);
                CHECK_ARRAY[i] = 0;
            }
        }
    }

    @Test
    @DisplayName("경로 탐색(인접행렬)")
    public void main() {
        int expectedAnswer = 6;
        CHECK_ARRAY[1] = 1;
        solution1(1);
        assertEquals(expectedAnswer, answer);
    }

}
