package com.roy.algorithm.programmers.greedy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class ConnectIslandSolution {


  @Test
  void solutionTest() {

    int numberOfIslandsForCase1 = 4;
    int[][] costsOfForCase1 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
    int expectedResultForCase1 = 4;
    int actualResultForCase1 = this.solution(numberOfIslandsForCase1, costsOfForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);
    
  }


  private int solution(int numberOfIslands, int[][] costs) {
    int answer = 0;
    return answer;
  }
}
