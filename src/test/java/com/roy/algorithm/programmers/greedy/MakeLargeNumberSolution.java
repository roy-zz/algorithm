package com.roy.algorithm.programmers.greedy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class MakeLargeNumberSolution {

  @Test
  void solutionTest() {

    String numberForCase1 = "1924";
    int kForCase1 = 2;
    String expectedResultForCase1 = "94";
    String actualResultForCase1 = this.solution(numberForCase1, kForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    String numberForCase2 = "1231234";
    int kForCase2 = 3;
    String expectedResultForCase2 = "3234";
    String actualResultForCase2 = this.solution(numberForCase2, kForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);

    String numberForCase3 = "4177252841";
    int kForCase3 = 4;
    String expectedResultForCase3 = "775841";
    String actualResultForCase3 = this.solution(numberForCase3, kForCase3);

    Assertions.assertEquals(expectedResultForCase3, actualResultForCase3);
    
  }

  private String solution(String number, int k) {
    String answer = "";
    return answer;
  }

}
