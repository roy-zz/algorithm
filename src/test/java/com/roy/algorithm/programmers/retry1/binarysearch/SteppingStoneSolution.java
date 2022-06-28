package com.roy.algorithm.programmers.retry1.binarysearch;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼 것
@Slf4j
public class SteppingStoneSolution {

  @Test
  void solutionTest() {

    int distanceForCase1 = 25;
    int[] rocksForCase1 = {2, 14, 11, 21, 17};
    int nForCase1 = 2;
    int expectedResultForCase1 = 4;
    int actualResultForCase1 = this.solution(distanceForCase1, rocksForCase1, nForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  private int solution(int distance, int[] rocks, int n) {

    Arrays.sort(rocks);

    int left = 1;
    int mid;
    int right = distance;
    int answer = distance;

    while (left <= right) {

      int count = 0;
      int previous = 0;
      mid = (left + right) / 2;

      for (int i = 0; i < rocks.length; i++) {

        if (rocks[i] - previous < mid) {
          count++;
        } else {
          previous = rocks[i];
        }

      }

    }

    return answer;
  }

}
