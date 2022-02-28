package com.roy.algorithm.inflearn.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 그래프 최단거리(BFS)
//
// 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
// - 입력설명
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
// - 출력설명
// 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
// - 입력예제 1
// 6 9
// 1 3
// 1 4
// 2 1
// 2 5
// 3 4
// 4 5
// 4 6
// 6 2
// 6 5
// - 출력예제 1
// 2 3
// 3 1
// 4 1
// 5 2
// 6 2
@SuppressWarnings("NewClassNamingConvention")
public class ShortestPath {

    private static final int VERTEXES = 6;
    private static final int[] CHECK_ARRAY = new int[VERTEXES + 1];
    private static final int[] EXPECTED_DISTANCES = {0, 0, 3, 1, 1, 2, 2};
    private static final int[] DISTANCES = new int[VERTEXES + 1];
    private static final int[][] CONNECTIONS = {
            {1, 3}, {1, 4},
            {2, 1}, {2, 5},
            {3, 4},
            {4, 5}, {4, 6},
            {6, 2}, {6, 2}
    };
    private final List<ArrayList<Integer>> graph = new ArrayList<>();

    public void solution1(int vertex) {
        Queue<Integer> queueOfVertex = new LinkedList<>();
        CHECK_ARRAY[vertex] = 1;
        DISTANCES[vertex] = 0;
        queueOfVertex.offer(vertex);
        while(!queueOfVertex.isEmpty()) {
            int currentVertex = queueOfVertex.poll();
            for (int nextVertex : graph.get(currentVertex)) {
                if (CHECK_ARRAY[nextVertex] == 0) {
                    CHECK_ARRAY[nextVertex] = 1;
                    queueOfVertex.offer(nextVertex);
                    DISTANCES[nextVertex] = DISTANCES[currentVertex] + 1;
                }
            }
        }
    }

    @Test
    @DisplayName("그래프 최단거리(BFS)")
    public void main() {
        for (int i = 0; i <= VERTEXES; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : CONNECTIONS) {
            graph.get(connection[0]).add(connection[1]);
        }
        solution1(1);
        assertArrayEquals(EXPECTED_DISTANCES, DISTANCES);
    }

}
