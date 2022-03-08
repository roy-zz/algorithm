package com.roy.algorithm.inflearn.retry2.slidingwindow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 최대 매출
//
// 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속 된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
// 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
// 12 15 (11 20 25) 10 20 19 13 15
// 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다. 여러분이 현수를 도와주세요.
// - 입력설명
// 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
// 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
// - 출력설명
// 첫 줄에 최대 매출액을 출력합니다.
// - 입력예제 1
// 10 3
// 12 15 11 20 25 10 20 19 13 15
// - 출력예제 1
// 56
@SuppressWarnings("NewClassNamingConvention")
public class BiggestSales {

    public int solution1(int[] inputs, int totalDays, int days) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < days; i++) {
            sum += inputs[i];
        }
        for (int i = days; i < totalDays; i++) {
            sum += inputs[i] - inputs[i - days];
            answer = Math.max(sum, answer);
        }
        return answer;
    }

    @Test
    @DisplayName("최대 매출")
    public void main() {
        int[] inputs = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        int totalDays = 10;
        int days = 3;
        int answer1 = solution1(inputs, totalDays, days);
        assertEquals(56, answer1);
    }

}
