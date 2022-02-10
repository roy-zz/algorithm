package com.roy.algorithm.programmers.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class StealingSolution {

  @Test
  void solutionTest() {

    int[] moneyForCase1 = {1, 2, 3, 1};
    int expectedResultForCase1 = 4;
    int actualResultForCase1 = this.solution(moneyForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);
    
  }

  private int solution(int[] money) {
    int answer = 0;
    return answer;
  }


}
