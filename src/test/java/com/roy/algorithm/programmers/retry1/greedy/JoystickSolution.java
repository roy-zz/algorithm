package com.roy.algorithm.programmers.retry1.greedy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class JoystickSolution {

  @Test
  void solutionTest() {

    String nameForCase1 = "JEROEN";
    int expectedResultForCase1 = 56;
    int actualResultForCase1 = this.solution(nameForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    String nameForCase2 = "JAN";
    int expectedResultForCase2 = 23;
    int actualResultForCase2 = this.solution(nameForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);
    
  }

  private int solution(String name) {
    int answer = 0;
    return answer;
  }


}
