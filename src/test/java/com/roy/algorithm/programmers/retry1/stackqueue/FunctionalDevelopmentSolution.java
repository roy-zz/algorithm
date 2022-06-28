package com.roy.algorithm.programmers.retry1.stackqueue;

import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼 것
@Slf4j
public class FunctionalDevelopmentSolution {

  @Test
  void solutionTest() {

    int[] progressesForCase1 = {93, 30, 55};
    int[] speedsForCase1 = {1, 30, 5};
    int[] expectedResultForCase1 = {2, 1};
    int[] actualResultForCase1 = this.solution(progressesForCase1, speedsForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);

    int[] progressesForCase2 = {95, 90, 99, 99, 80, 99};
    int[] speedsForCase2 = {1, 1, 1, 1, 1, 1};
    int[] expectedResultForCase2 = {1, 3, 2};
    int[] actualResultForCase2 = this.solution(progressesForCase2, speedsForCase2);

    Assertions.assertArrayEquals(expectedResultForCase2, actualResultForCase2);

  }

  // @formatter:off
  public int[] solution(int[] progresses, int[] speeds) {

    double[] days = new double[progresses.length];

    double max = 0;
    LinkedList<int[]> queueOfAnswer = new LinkedList<>();
    for (int i = 0; i < progresses.length; i++) {

      days[i] = Math.ceil((100 - progresses[i]) / speeds[i]);

      if (days[i] > max) {
        max = days[i];
        queueOfAnswer.add(new int[]{ 1 });
      } else {
        queueOfAnswer.getLast()[0]++;
      }
    }

    int size = queueOfAnswer.size();
    int[] answer = new int[size];
    for (int i = 0; i < size; i++) {
      answer[i] = queueOfAnswer.pollFirst()[0];
    }

    return answer;
  }
  // @formatter:on

}
