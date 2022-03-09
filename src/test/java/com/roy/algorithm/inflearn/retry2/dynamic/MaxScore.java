package com.roy.algorithm.inflearn.retry2.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 최대점수 구하기(냅색 알고리즘)
//
// 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
// 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
// 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
// 해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.
// - 입력설명
// 첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
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
// - 풀이
// dynamics 테이블을 만들고 사이즈는 제한시간 + 1로 한다.
// 각 값에는 해당 시간까지 풀 수 있는 최대 점수이다.
// 문제당 한번밖에 풀 수 없다는 점을 주의해야한다.
// 뒤에서부터 순회해야 문제를 중복으로 푸는 문제를 해결할 수 있다.
// 무한개면 앞에서 부터 순회하고 유한개라면 뒤에서 부터 순회해야한다.
@SuppressWarnings("NewClassNamingConvention")
public class MaxScore {

    @Test
    @DisplayName("최대점수 구하기(냅색 알고리즘)")
    public void main() {
        int problemCount1 = 5;
        int timeLimit1 = 20;
        int[][] problems1 = {
                {10, 5}, {25, 12}, {15, 8},
                {6, 3}, {7, 4}
        };
        int expectedAnswer1 = 41;
//        int answer1 = solution1(problemCount1, timeLimit1, problems1);
//        assertEquals(expectedAnswer1, answer1);
    }

}
