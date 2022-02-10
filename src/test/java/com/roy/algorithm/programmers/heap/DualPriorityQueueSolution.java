package com.roy.algorithm.programmers.heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DualPriorityQueueSolution {

  @Test
  void solutionTest() {

    String[] operationsForCase1 = {"I 16", "D 1"};
    int[] expectedResultForCase1 = {0, 0};
    int[] actualResultForCase1 = this.solution(operationsForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);

    String[] operationsForCase2 = {"I 7", "I 5", "I -5", "D -1"};
    int[] expectedResultForCase2 = {7, 5};
    int[] actualResultForCase2 = this.solution(operationsForCase2);

    Assertions.assertArrayEquals(expectedResultForCase2, actualResultForCase2);

  }

  public int[] solution(String[] operations) {

    // CAUTION
    // 1. 최댓값/최솟값이 복수일 경우 '하나만' 삭제한다.
    // 2. 빈 큐에 데이터를 삭제하라는 연산은 '무시'한다.
    LinkedList<Integer> queueOfIntegers = new LinkedList<>();

    for (String operation : operations) {

      // 데이터 삽입
      if (operation.contains("I")) {
        queueOfIntegers.offer(Integer.valueOf(operation.split(" ")[1]));
        Collections.sort(queueOfIntegers);
        // 최대값 삭제
      } else if (operation.contains("D 1")) {
        queueOfIntegers.pollLast();
        // 최솟값 삭제
      } else {
        queueOfIntegers.pollFirst();
      }
    }

    int[] answer = {Objects.isNull(queueOfIntegers.peekLast()) ? 0 : queueOfIntegers.peekLast(),
        Objects.isNull(queueOfIntegers.peekFirst()) ? 0 : queueOfIntegers.peekFirst()};
    return answer;
  }

}
