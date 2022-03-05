package com.roy.algorithm.inflearn.retry1.utilizedfsbfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 바둑이 승차(DFS)
//
// 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
// 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
// N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다. 둘째 줄부터 N마리 바둑이의 무게가 주어진다.
// - 출력설명
// 첫 번째 줄에 가장 무거운 무게를 출력한다.
// - 입력예제 1
// 259 5
// 81
// 58
// 42
// 33
// 61
// - 출력예제 1
// 242
@SuppressWarnings("NewClassNamingConvention")
public class RidingDog {

    private static final int[] DOGS_WEIGHT = {81, 58, 42, 33, 61};
    private static final int LIMIT_TOTAL_WEIGHT = 259;
    private static int answer = Integer.MIN_VALUE;

    public void solution1(int level, int sum) {
        if (level == DOGS_WEIGHT.length) {
            answer = LIMIT_TOTAL_WEIGHT >= sum ? Math.max(answer, sum) : answer;
        } else {
            // 해당 인덱스의 바둑이가 승차하는 경우
            solution1(level + 1, sum + DOGS_WEIGHT[level]);
            // 해당 인덱스의 바둑이가 승차하지 않는 경우
            solution1(level + 1, sum);
        }
    }

    @Test
    @DisplayName("바둑이 승차(DFS)")
    public void main() {
        int expectedAnswer = 242;
        solution1(0, 0);
        Assertions.assertEquals(expectedAnswer, answer);
    }

}
