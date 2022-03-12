package com.roy.algorithm.inflearn.retry2.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 경로 탐색(인접행렬)
//
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
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
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
    private static final int[][] CONNECTIONS = {
            {1, 2}, {1, 3}, {1, 4},
            {2, 1}, {2, 3}, {2, 5},
            {3, 4}, {4, 2}, {4, 5}
    };
    private int[][] graph;
    private int answer = 0;

    public void solution(int vertex) {
        if (vertex == VERTEXES) {
            answer++;
        } else {
            for (int i = 1; i <= VERTEXES; i++) {
                if (CHECK_ARRAY[i] == 0 && graph[vertex][i] == 1) {
                    CHECK_ARRAY[i] = 1;
                    solution(i);
                    CHECK_ARRAY[i] = 0;
                }
            }
        }
    }

    @Test
    @DisplayName("경로 탐색(인접행렬)")
    public void main() {
        int expectedAnswer = 6;
        graph = new int[VERTEXES + 1][VERTEXES + 1];
        Arrays.stream(CONNECTIONS).forEach(connection ->
            graph[connection[0]][connection[1]] = 1
        );
        CHECK_ARRAY[1] = 1;
         solution(1);
         assertEquals(expectedAnswer, answer);
    }

}
