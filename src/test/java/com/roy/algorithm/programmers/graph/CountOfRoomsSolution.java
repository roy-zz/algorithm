package com.roy.algorithm.programmers.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CountOfRoomsSolution {

  @Test
  void solutionTest() {

    int[] arrowsForCase1 = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
    int expectedResultForCase1 = 3;
    int actualResultForCase1 = this.solution(arrowsForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  private int solution(int[] arrows) {
    int answer = 0;
    return answer;
  }

}
