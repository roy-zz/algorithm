package com.roy.algorithm.programmers.retry1.dfsbfs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class NetworkSolution {

  @Test
  void solutionTest() {

    int nForCase1 = 3;
    int[][] computersForCase1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    int expectedResultForCase1 = 2;
    int actualResultForCase1 = this.solution(nForCase1, computersForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    int nForCase2 = 3;
    int[][] computersForCase2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
    int expectedResultForCase2 = 1;
    int actualResultForCase2 = this.solution(nForCase2, computersForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);

  }

  private boolean[] isVisited;
  private int[][] globalComputers;

  private int solution(int n, int[][] computers) {

    // # DFS (Depth first search, 깊이 우선 탐색)
    // 장점 1) 현 경로상의 노드를 기억하기 때문에 적은 메모리를 사용한다.
    // 장점 2) 찾으려는 노드가 깊은 단계에 있는 경우 BFS보다 빠르게 찾을 수 있다.
    // 단점 1) 해가 없는 경로를 탐색 할 경우 단계가 끝날 때까지 탐색한다.
    // 단점 2) DFS를 통해서 얻은 값이 최단 경로라는 보장이 없다.

    // # BFS (Breadth first search, 너비 우선 탐색)
    // 장점 1) 답이 되는 경로가 여러 개인 경우에도 최단 경로임을 보장한다.
    // 장점 2) 최단 경로가 존재하면 깊이가 무한정 깊어진다고 하더라도 답을 찾을 수 있다.
    // 단점 1) 경로가 매우 길 경우 탐색 가지가 급격히 증가함에 따라 보다 많은 기억 공간을 필요로 하게 된다.
    // 단점 2) 값이 존재하지 않는다면 유한 그래프의 경우 모든 그래프를 탐색한 후에 실패로 끝난다.
    // 단점 3) 무한 그래프의 경우에는 해를 찾지도 못하고 끝내지도 못한다.

    int answer = 0;

    isVisited = new boolean[n];
    globalComputers = computers;

    for (int i = 0; i < n; i++) {
      if (isVisited[i] == Boolean.FALSE) {
        answer++;
        dfs(i);
      }
    }

    return answer;

  }

  private void dfs(int node) {

    isVisited[node] = Boolean.TRUE;

    for (int i = 0; i < globalComputers.length; i++) {
      if (isVisited[i] == Boolean.FALSE && globalComputers[node][i] == 1) {
        dfs(i);
      }
    }

  }
}










