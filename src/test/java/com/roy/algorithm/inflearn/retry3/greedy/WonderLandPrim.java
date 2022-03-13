package com.roy.algorithm.inflearn.retry3.greedy;

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

//    int[] checkArray;
//
//    static class Edge implements Comparable<Edge> {
//        int vertex;
//        int cost;
//        public Edge(int vertex, int cost) {
//            this.vertex = vertex;
//            this.cost = cost;
//        }
//        @Override
//        public int compareTo(Edge edge) {
//            return this.cost - edge.cost;
//        }
//    }
//
//    @Test
//    @DisplayName("원더랜드 (최소스패닝트리: 프림, PriorityQueue)")
//    public void main() {
//    }

}
