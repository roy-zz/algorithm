package com.roy.algorithm.inflearn.retry1.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 돌다리 건너기
//
// 철수는 학교에 가는데 개울을 만났습니다.
// 개울은 N개의 돌로 다리를 만들어 놓았습니다.
// 철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
// 철수가 개울을 건너는 방법은 몇 가지일까요?
// - 입력설명
// 첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.
// - 출력설명
// 첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.
// - 입력예제 1
// 7
// - 출력예제 1
// 34
// - 해설
// 돌은 7개, 마지막 육지를 돌로 생각하면 총 8개의 돌
@SuppressWarnings("NewClassNamingConvention")
public class StoneBridge {

    public int solution1(int stoneCount, int[] dynamics) {
        dynamics[1] = 1;
        dynamics[2] = 2;
        for (int i = 3; i <= stoneCount + 1; i++) {
            dynamics[i] = dynamics[i - 2] + dynamics[i - 1];
        }
        return dynamics[stoneCount + 1];
    }

    @Test
    @DisplayName("돌다리 건너기")
    public void main() {
        int stoneCount = 7;
        int[] dynamics = new int[stoneCount + 2];
        int expectedAnswer1 = 34;
        int answer1 = solution1(stoneCount, dynamics);
        assertEquals(expectedAnswer1, answer1);
    }

}
