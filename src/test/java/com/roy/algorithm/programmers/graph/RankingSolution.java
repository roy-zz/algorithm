package com.roy.algorithm.programmers.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class RankingSolution {

  @Test
  void solutionTest() {

    int nForCase1 = 5;
    int[][] resultsForCase1 = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
    int expectedResultForCase1 = 2;
    int actualResultForCase1 = this.solution(nForCase1, resultsForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  private int solution(int n, int[][] results) {
    int answer = 0;
    return answer;
  }
}
