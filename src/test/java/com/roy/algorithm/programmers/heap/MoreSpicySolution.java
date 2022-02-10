package com.roy.algorithm.programmers.heap;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class MoreSpicySolution {

  @Test
  void solutionTest() {

    int[] scovillesForCase1 = {1, 2, 3, 9, 10, 12};
    int kForCase1 = 7;
    int expectedResultForCase1 = 2;
    int actualResultForCase1 = this.solution(scovillesForCase1, kForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);
  }

  public int solution(int[] scovilles, int K) {

    int answer = 0;

    PriorityQueue<Integer> ascScovillePriorityQueue = new PriorityQueue<>();
    for (int scoville : scovilles) {
      ascScovillePriorityQueue.offer(scoville);
    }

    while (ascScovillePriorityQueue.peek() < K) {

      if (ascScovillePriorityQueue.size() == 1) {
        return -1;
      }

      int leastSpicy1stScoville = ascScovillePriorityQueue.poll();
      int leastSpciy2stScoville = ascScovillePriorityQueue.poll();

      ascScovillePriorityQueue.offer(leastSpicy1stScoville + (leastSpciy2stScoville * 2));
      answer++;
    }

    return answer;
  }

}
