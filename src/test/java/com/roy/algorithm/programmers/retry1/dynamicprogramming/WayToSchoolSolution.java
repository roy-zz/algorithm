package com.roy.algorithm.programmers.retry1.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class WayToSchoolSolution {

  @Test
  void solutionTest() {

    int mForCase1 = 4;
    int nForCase1 = 3;
    int[][] puddlesForCase1 = {{2, 2}};
    int expectedResultForCase1 = 4;
    int actualResultFOrCase1 = this.solution(mForCase1, nForCase1, puddlesForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultFOrCase1);

  }

  private int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    return answer;
  }

}
