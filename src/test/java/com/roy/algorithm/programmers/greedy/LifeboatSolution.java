package com.roy.algorithm.programmers.greedy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class LifeboatSolution {

  @Test
  void solutionTest() {

    int[] peopleForCase1 = {70, 50, 80, 50};
    int limitForCase1 = 100;
    int expectedForCase1 = 3;
    int actualForCase1 = this.solution(peopleForCase1, limitForCase1);

    Assertions.assertEquals(expectedForCase1, actualForCase1);

    int[] peopleForCase2 = {70, 80, 50};
    int limitForCase2 = 100;
    int expectedForCase2 = 3;
    int actualForCase2 = this.solution(peopleForCase2, limitForCase2);

    Assertions.assertEquals(expectedForCase2, actualForCase2);

  }

  private int solution(int[] people, int limit) {
    int answer = 0;
    return answer;
  }
}
