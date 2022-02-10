package com.roy.algorithm.programmers.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼 것
public class DiskControllerSolution {

  @Test
  void solutionTest() {

    int[][] jobsForCase1 = {{0, 3}, {1, 9}, {2, 6}};
    int expectedResultForCase1 = 9;
    int actualResultForCase1 = this.solution(jobsForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  public int solution(int[][] jobs) {

    // SPN(Shortest Process Next) / SJF(Shortest Job First)
    // KEY
    // 1. 작업 소요 시간이 적은 일을 먼저 처리
    // 2. 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리
    LinkedList<Job> queueOfWaitingJobs = new LinkedList<>();
    PriorityQueue<Job> priorityQueueRequiredTime = new PriorityQueue<>(new Comparator<Job>() {
      @Override
      public int compare(Job job1, Job job2) {
        return job1.getWorkingTime() - job2.getWorkingTime();
      }
    });

    for (int i = 0; i < jobs.length; i++) {
      queueOfWaitingJobs.offer(new Job(jobs[i]));
    }

    Collections.sort(queueOfWaitingJobs, new Comparator<Job>() {
      @Override
      public int compare(Job job1, Job job2) {
        return job1.getRequestTime() - job2.getRequestTime();
      }
    });

    int answer = 0;
    int count = 0;
    int time = queueOfWaitingJobs.peek().requestTime;

    while (count < jobs.length) {

      while (!queueOfWaitingJobs.isEmpty() && queueOfWaitingJobs.peek().requestTime <= time) {
        priorityQueueRequiredTime.offer(queueOfWaitingJobs.pollFirst());
      }

      if (!priorityQueueRequiredTime.isEmpty()) {
        Job job = priorityQueueRequiredTime.poll();
        time += job.getWorkingTime();
        answer += time - job.getRequestTime();
        count++;
      } else {
        time++;
      }

    }

    return answer / count;
  }

  private static class Job {

    int requestTime;
    int workingTime;

    public Job(int[] value) {
      this.requestTime = value[0];
      this.workingTime = value[1];
    }

    public int getRequestTime() {
      return this.requestTime;
    }

    public int getWorkingTime() {
      return this.workingTime;
    }
  }
}
