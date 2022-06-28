package com.roy.algorithm.programmers.retry1.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class FurthestNodeSolution {

  @Test
  void solutionTest() {

    int nForCase1 = 6;
    int[][] vertexForCase1 = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
    int expectedResultForCase1 = 3;
    int actualResultForCase1 = this.solution(nForCase1, vertexForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);
    
  }

  private int solution(int n, int[][] vertex) {
    int answer = 0;
    return answer;
  }

}
