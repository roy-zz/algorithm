package com.roy.algorithm.inflearn.retry1.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 다익스트라 알고리즘
//
// 아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요.
// 경로가 없으면 Impossible를 출력한다.
//
// - 입력설명
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.
// - 출력설명
// 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
// - 입력예제 1
// 1 2 12 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
// 1 3 4
// 2 1 2
// 2 3 5
// 2 5 5
// 3 4 5
// 4 2 2
// 4 5 5
// 6 4 5
// - 출력예제 1
// 2 11
// 3 4
// 4 9
// 5 14
// 6 impossible
// - 풀이
// 다익스트라 알고리즘을 적용하기 위해서는 가중치에 음수가 있어서는 안된다.
// PriorityQueue를 사용하지 않은 경우의 시간 복잡도는 O(n * n)이 된다.
// PriorityQueue의 시간 복잡도는 logn이므로 시간 복잡도는 = O(n * logn)이 된다.
// HARD 다시 풀어볼 것!
@SuppressWarnings("NewClassNamingConvention")
public class Dijkstra {

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;
        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }

    private static final int NUMBERS = 6;
    private static final int[] DISTANCES = new int[NUMBERS + 1];
    private static final ArrayList<ArrayList<Edge>> GRAPH = new ArrayList<>();

    public void solution1(int v) {
        Queue<Edge> queueOfEdge = new PriorityQueue<>();
        queueOfEdge.offer(new Edge(v, 0));
        DISTANCES[0] = 0;
        DISTANCES[v] = 0;
        while (!queueOfEdge.isEmpty()) {
            Edge currentEdge = queueOfEdge.poll();
            int currentVertex = currentEdge.vertex;
            int currentCost = currentEdge.cost;
            if (currentCost > DISTANCES[currentVertex]) {
                continue;
            }
            for (Edge edge : GRAPH.get(currentVertex)) {
                if (DISTANCES[edge.vertex] > currentCost + edge.cost) {
                    DISTANCES[edge.vertex] = currentCost + edge.cost;
                    queueOfEdge.offer(new Edge(edge.vertex, currentCost + edge.cost));
                }
            }
        }
    }

    @Test
    @DisplayName("다익스트라 알고리즘")
    public void main() {
        for (int i = 0; i <= 9; i++) {
            GRAPH.add(new ArrayList<>());
        }
        Arrays.fill(DISTANCES, Integer.MAX_VALUE);
        GRAPH.get(1).add(new Edge(2, 12));
        GRAPH.get(1).add(new Edge(3, 4));
        GRAPH.get(2).add(new Edge(1, 2));
        GRAPH.get(2).add(new Edge(3, 5));
        GRAPH.get(2).add(new Edge(5, 5));
        GRAPH.get(3).add(new Edge(4, 5));
        GRAPH.get(4).add(new Edge(2, 2));
        GRAPH.get(4).add(new Edge(5, 5));
        GRAPH.get(6).add(new Edge(4, 5));
        solution1(1);
        int[] expectedAnswer = {0, 0, 11, 4, 9, 14, Integer.MAX_VALUE};
        assertArrayEquals(expectedAnswer, DISTANCES);
    }

}
