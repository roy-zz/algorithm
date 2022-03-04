package com.roy.algorithm.inflearn.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 원더랜드 (최소스패닝트리: 프림, PriorityQueue)
//
// 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
// 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
// 아래의 그림은 그 한 예를 설명하는 그림이다.
// 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시 를 연결하는 방법을 찾아낸 것이다.
// - 입력설명
// 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
// 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
// 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
// - 출력설명
// 모든 도시를 연결하면서 드는 최소비용을 출려한다.
// - 입력예제 1
// 9 12
// 1 2 12
// 1 9 25
// 2 3 10
// 2 8 17
// 2 9 8
// 3 4 18
// 3 7 55
// 4 5 44
// 5 6 60
// 5 7 38
// 7 8 35
// 8 9 15
// - 출력예제 1
// 196
// - 풀이
// 가중치가 있는 무방향 인접리스트를 만들어야한다.
// 정점을 확인하는 1차원 체크배열이 필요하다.
// 우선순위큐가 필요한데 우선순위큐에는 선택한 정점에서 갈 수 있는 정점들의 비용이 들어간다.
@SuppressWarnings("NewClassNamingConvention")
public class WonderLandPrim {

    int[] checkArray;

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

    public int solution1(ArrayList<ArrayList<Edge>> graph) {
        int answer = 0;
        Queue<Edge> queueOfEdge = new PriorityQueue<>();
        queueOfEdge.add(new Edge(1, 0));
        while (!queueOfEdge.isEmpty()) {
            Edge currentEdge = queueOfEdge.poll();
            int currentVertex = currentEdge.vertex;
            if (checkArray[currentVertex] == 0) {
                checkArray[currentVertex] = 1;
                answer += currentEdge.cost;
                for (Edge edge : graph.get(currentVertex)) {
                    if (checkArray[edge.vertex] == 0) {
                        queueOfEdge.offer(edge);
                    }
                }
            }
        }
        return answer;
    }

    @Test
    @DisplayName("원더랜드 (최소스패닝트리: 프림, PriorityQueue)")
    public void main() {
        int edgeCount = 9;
        checkArray = new int[edgeCount + 1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= edgeCount; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(new Edge(2, 12));
        graph.get(2).add(new Edge(1, 12));
        graph.get(1).add(new Edge(9, 25));
        graph.get(9).add(new Edge(1, 25));
        graph.get(2).add(new Edge(3, 10));
        graph.get(3).add(new Edge(2, 10));
        graph.get(2).add(new Edge(8, 17));
        graph.get(8).add(new Edge(2, 17));
        graph.get(2).add(new Edge(9, 8));
        graph.get(9).add(new Edge(2, 8));
        graph.get(3).add(new Edge(4, 18));
        graph.get(4).add(new Edge(3, 18));
        graph.get(3).add(new Edge(7, 55));
        graph.get(7).add(new Edge(3, 55));
        graph.get(4).add(new Edge(5, 44));
        graph.get(5).add(new Edge(4, 44));
        graph.get(5).add(new Edge(6, 60));
        graph.get(6).add(new Edge(5, 60));
        graph.get(5).add(new Edge(7, 38));
        graph.get(7).add(new Edge(5, 38));
        graph.get(7).add(new Edge(8, 35));
        graph.get(8).add(new Edge(7, 35));
        graph.get(8).add(new Edge(9, 15));
        graph.get(9).add(new Edge(8, 15));
        int expectedAnswer1 = 196;
        int answer1 = solution1(graph);
        assertEquals(expectedAnswer1, answer1);
    }

}
