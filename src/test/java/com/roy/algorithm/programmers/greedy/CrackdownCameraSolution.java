package com.roy.algorithm.programmers.greedy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CrackdownCameraSolution {

  @Test
  void solutionTest() {

    int[][] routesForCase1 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
    int expectedResultForCase1 = 2;
    int actualResultForCase1 = this.solution(routesForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  private int solution(int[][] routes) {
    int answer = 0;
    return answer;
  }

}
