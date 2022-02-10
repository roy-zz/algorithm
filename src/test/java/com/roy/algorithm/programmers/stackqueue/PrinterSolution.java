package com.roy.algorithm.programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class PrinterSolution {

  @Test
  void solutionTest() {

    int[] prioritiesForCase1 = {2, 1, 3, 2};
    int locationForCase1 = 2;
    int expectedResultForCase1 = 1;

    Assertions.assertEquals(expectedResultForCase1,
        this.solution(prioritiesForCase1, locationForCase1));

    int[] prioritiesForCase2 = {1, 1, 9, 1, 1, 1};
    int locationForCase2 = 0;
    int expectedResultForCase2 = 5;

    Assertions.assertEquals(expectedResultForCase2,
        this.solution(prioritiesForCase2, locationForCase2));

  }

  public int solution(int[] priorities, int location) {

    int answer = 1;
    boolean isFinished = false;

    Queue<Paper> queueOfPaper = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++) {
      queueOfPaper.offer(new Paper(i, priorities[i]));
    }

    while (Boolean.FALSE == isFinished) {

      Paper target = queueOfPaper.poll();

      if (queueOfPaper.stream().filter(i -> i.getPriorities() > target.getPriorities()).findFirst()
          .isEmpty()) {
        if (target.getId() == location) {
          isFinished = Boolean.TRUE;
        } else {
          answer++;
        }
      } else {
        queueOfPaper.offer(target);
      }
    }

    return answer;
  }

  private class Paper {

    int id;
    int priorities;

    public Paper(int id, int priorities) {
      this.id = id;
      this.priorities = priorities;
    }

    public int getId() {
      return this.id;
    }

    public int getPriorities() {
      return this.priorities;
    }

  }

}
