package com.roy.algorithm.inflearn.retry1.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 최대점수 구하기(DFS)
//
// 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
// 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
// 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
// (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
// - 입력설명
// 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
// 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
// - 출력설명
// 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
// - 입력예제 1
// 5 20
// 10 5
// 25 12
// 15 8
// 6 3
// 7 4
// - 출력예제 1
// 41
@SuppressWarnings("NewClassNamingConvention")
public class MaxScore {

    private static final int PROBLEM_COUNT = 5;
    private static final int LIMIT_SECOND = 20;
    private static final int[][] PROBLEMS = {
            {10, 5}, {25, 12}, {15, 8}, {6, 3}, {7, 4}
    };
    private int maxScore = Integer.MIN_VALUE;

    public void solution1(int level, int score, int second) {
        if (second > LIMIT_SECOND) {
            return;
        }
        if (level == PROBLEM_COUNT) {
            maxScore = Math.max(maxScore, score);
        } else {
            // 문제를 푸는 경우
            solution1(level + 1,
                    score + PROBLEMS[level][0],
                    second + PROBLEMS[level][1]);
            // 문제를 풀지 않는 경우
            solution1(level + 1, score, second);
        }
    }

    @Test
    @DisplayName("최대점수 구하기(DFS")
    public void main() {
        int expectedAnswer = 41;
        solution1(0, 0, 0);
        assertEquals(expectedAnswer, maxScore);
    }

}
