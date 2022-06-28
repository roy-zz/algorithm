package com.roy.algorithm.programmers.retry1.dfsbfs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class TargetNumberSolution {

  @Test
  void solutionTest() {

    int[] numbersForCase1 = {1, 1, 1, 1, 1};
    int targetForCase1 = 3;
    int expectedResultForCase1 = 5;
    int actualResultForCase1 = this.solution(numbersForCase1, targetForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  private int[] globalNumbers;

  private int globalTarget;

  private int solution(int[] numbers, int target) {

    int answer = 0;

    // 경우의 수는 +,- 두 가지
    // 모든 경우를 탐색하다 결과가 target 과 같은 경우 answer++
    // 최상위 노드가 -1인 경우 +1인 경우 두 가지가 존재

    globalNumbers = numbers;
    globalTarget = target;

    answer += dfs(globalNumbers[0], 1);
    answer += dfs(-globalNumbers[0], 1);

    return answer;

  }

  private int dfs(int sum, int count) {

    if (count == globalNumbers.length) {
      if (sum == globalTarget) {
        return 1;
      } else {
        return 0;
      }
    }

    int result = 0;
    result += dfs(sum + globalNumbers[count], count + 1);
    result += dfs(sum - globalNumbers[count], count + 1);
    return result;

  }

}
