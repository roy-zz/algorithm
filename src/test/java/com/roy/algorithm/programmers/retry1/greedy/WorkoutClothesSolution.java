package com.roy.algorithm.programmers.retry1.greedy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class WorkoutClothesSolution {

  @Test
  void solutionTest() {

    int nForCase1 = 5;
    int[] lostForCase1 = {2, 4};
    int[] reserveForCase1 = {1, 3, 5};
    int expectedResultForCase1 = 5;
    int actualResultForCase1 = this.solution(nForCase1, lostForCase1, reserveForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    int nForCase2 = 5;
    int[] lostForCase2 = {2, 4};
    int[] reserveForCase2 = {3};
    int expectedResultForCase2 = 4;
    int actualResultForCase2 = this.solution(nForCase2, lostForCase2, reserveForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);

    int nForCase3 = 3;
    int[] lostForCase3 = {3};
    int[] reserveForCase3 = {1};
    int expectedResultForCase3 = 2;
    int actualResultForCase3 = this.solution(nForCase3, lostForCase3, reserveForCase3);

    Assertions.assertEquals(expectedResultForCase3, actualResultForCase3);
    
  }

  private int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    return answer;
  }


}
