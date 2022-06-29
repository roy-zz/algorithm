package com.roy.algorithm.programmers.retry2.stackqueue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FunctionalDevelopmentSolution {

    @Test
    void problem() {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] expectedAnswer1 = {2, 1};
        int[] answer1 = solution1(progresses1, speeds1);
        assertArrayEquals(expectedAnswer1, answer1);

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] expectedAnswer2 = {1, 3, 2};
        int[] answer2 = solution1(progresses2, speeds2);
        assertArrayEquals(expectedAnswer2, answer2);
    }

    private int[] solution1(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Job> queueOfJobs = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queueOfJobs.offer(new Job(progresses[i], speeds[i]));
        }

        while (!queueOfJobs.isEmpty()) {
            for (Job job : queueOfJobs) {
                job.progress = job.progress + job.speed;
            }
            if (queueOfJobs.peek().progress >= 100) {
                int tempCount = 0;
                while (!queueOfJobs.isEmpty() && queueOfJobs.peek().progress >= 100) {
                    tempCount++;
                    queueOfJobs.poll();
                }
                if (tempCount > 0) {
                    answer.add(tempCount);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Job {
        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

}
