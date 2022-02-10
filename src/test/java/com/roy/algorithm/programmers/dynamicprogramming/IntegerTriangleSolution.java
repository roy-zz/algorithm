package com.roy.algorithm.programmers.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class IntegerTriangleSolution {

  @Test
  void solutionTest() {

    int[][] triangleForCase1 = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    int expectedResultForCase1 = 30;
    int actualResultForCase1 = this.solution(triangleForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  private int solution(int[][] triangle) {
    int answer = 0;
    return answer;
  }
}
