package com.roy.algorithm.inflearn.retry3.greedy;

// 원더랜드 (최소스패닝트리: 크루스칼, Union & Find 활용)
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
// 최소스패닝트리: 크루스칼 = 어떠한 그래프에서 모든 Vertex가 연결되어 있는 그래프를 추출해내는 것
// 그래프와 트리의 차이는 그래프는 자기자신으로 돌아올 수 있는 회로가 존재하고
// 트리는 자기 자신으로 돌아올 수 있는 회로가 존재하지 않는다.
// 크루스칼 알고리즘은 회로가 되어서는 안된다.
// 트리에서 간선의 수 = 정점의 수 + 1이 된다.
// 트리구조가 만들어지고나면 이후에 더 이상의 간선이 추가되지 않을 것이므로 중간에 끊어줄 수 있다. (시간복잡도 감소)
// 만든 간선의 수를 카운트하고 만들어진 간선의 수가 정점의 수 + 1이라면 로직을 타지않고 흘려보내도록 한다.
@SuppressWarnings("NewClassNamingConvention")
public class WonderLandKruskal {

//    @Test
//    @DisplayName("원더랜드 (최소스패닝트리: 크루스칼, Union & Find 활용)")
//    public void main() {
//    }

}
