package com.roy.algorithm.inflearn.retry1.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Collections.reverseOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 최대 수입 스케쥴 (PriorityQueue)
//
// 현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다.
// 각 기업은 D일 안에 와서 강연을 해주면 M만큼의 강연료를 주기로 했다.
// 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야한다.
// 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
// - 입력설명
// 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
// - 출력설명
// 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
// - 입력예제 1
// 6
// 50 2
// 20 1
// 40 2
// 60 3
// 30 3
// 30 1
// - 출력예제 1
// 150
// - 풀이
// 마감일 기준으로 내림차순으로 정렬하고 금액 기준으로 내림차순한다.
// HARD 다시 풀어볼 것!
@SuppressWarnings("NewClassNamingConvention")
public class MaxIncomeSchedule {

    static class Speech implements Comparable<Speech> {
        int cost;
        int deadline;
        public Speech (int cost, int deadline) {
            this.cost = cost;
            this.deadline = deadline;
        }
        @Override
        public int compareTo(Speech speech) {
            return this.deadline == speech.deadline
                    ? speech.cost - this.cost
                    : speech.deadline - this.deadline;
        }
    }

    public int solution1(Speech[] inputs) {
        Arrays.sort(inputs);
        Queue<Integer> queueOfCost = new PriorityQueue<>(reverseOrder());
        int maxDeadline = Arrays.stream(inputs)
                .mapToInt(i -> i.deadline)
                .max()
                .orElse(0);
        int answer = 0;
        int outerJ = 0;
        for (int i = maxDeadline; i >= 1; i--) {
            for (; outerJ < 6; outerJ++) {
                if (inputs[outerJ].deadline < i) {
                    break;
                }
                queueOfCost.offer(inputs[outerJ].cost);
            }
            if (!queueOfCost.isEmpty()) {
                answer += queueOfCost.poll();
            }
        }
        return answer;
    }

    @Test
    @DisplayName("최대 수입 스케쥴")
    public void main() {
        Speech[] inputs1 = {
                new Speech(50, 2), new Speech(20, 1), new Speech(40, 2),
                new Speech(60, 3), new Speech(30, 3), new Speech(30, 1)
        };
        int answer1 = solution1(inputs1);
        assertEquals(150, answer1);
    }

}
