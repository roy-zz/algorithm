package com.roy.algorithm.programmers.binarysearch;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼 것
@Slf4j
public class ImmigrationSolution {

  @Test
  void solutionTest() {

    int nForCase1 = 6;
    int[] timesForCase1 = {7, 10};
    long expectedResultForCase1 = 28;
    long actualResultForCase1 = this.solution(nForCase1, timesForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);
  }

  private long solution(int n, int[] times) {

    Arrays.sort(times);

    long start = 1;
    long end = Long.MAX_VALUE;
    long mid;
    long sum;
    long answer = end;

    while (start <= end) {

      sum = 0;
      mid = (start + end) / 2;

      for (int time : times) {
        // 심사관 당 맡을 수 있는 입국자 수
        sum += mid / time;
      }

      // 더 맡을 수 있으므로 시간 줄임
      if (sum >= n) {
        if (mid < answer) {
          answer = mid;
        }
        end = mid - 1;
        // 작업이 불가능하므로 시간 늘림
      } else {
        start = mid + 1;
      }
    }

    return answer;
  }
}
