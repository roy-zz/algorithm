package com.roy.algorithm.programmers.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExpressionNSolution {

  @Test
  void solutionTest() {

    int NForCase1 = 5;
    int numberForCase1 = 12;
    int expectedResultForCase1 = 4;
    int actualResultForCase1 = this.solution(NForCase1, numberForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    int NForCase2 = 2;
    int numberForCase2 = 11;
    int expectedResultForCase2 = 3;
    int actualResultForCase2 = this.solution(NForCase2, numberForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);

  }

  private int n;
  private int answer = 0;
  private int target;

  private int solution(int N, int number) {

    target = number;
    // N: 주어진 수
    // number: 만들어야하는 수
    // + - * /
    // 나머지는 무시한다. (Math.floor 사용)
    // 최솟값이 8보다 크면 -1을 리턴한다.
    // DFS ???

    return answer;
  }

  private void dfs(int count, int previous) {

    if (count > 8) {
      answer = -1;
      return;
    }

    if (previous == target) {
      answer = Math.min(answer, count);
      return;
    }

    int tempN = n;

    for (int i = 0; i < 8 - count; i++) {
      int newCount = count + i + 1;
      dfs(newCount, previous + tempN);
      dfs(newCount, previous - tempN);
    }

  }


}
