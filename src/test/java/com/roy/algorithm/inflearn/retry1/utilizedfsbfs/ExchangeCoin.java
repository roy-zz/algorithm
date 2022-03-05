package com.roy.algorithm.inflearn.retry1.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 동전교환
//
// 다음과 같이 여러 단위의 동전들이 주어져 있을 때 거스름 돈을 가장 적은 수의 동전으로 교환 해주려면 어떻게 주면 되는가?
// 각 단위의 동전은 무한정 쓸 수 있다.
// - 입력설명
// 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다.
// 두 번째 줄에는 N개의 동전의 종 류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
// 각 동전의 종류는 100원을 넘지 않는다.
// - 출력설명
// 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
// - 입력예제 1
// 3
// 1 2 5
// 15
// - 출력예제 1
// 3
@SuppressWarnings("NewClassNamingConvention")
public class ExchangeCoin {

    private static final int[] COINS = {1, 2, 5};
    private static final int TARGET_COST = 15;
    private static final int EXPECTED_ANSWER = 3;
    private int minCoins = Integer.MAX_VALUE;

    // DFS를 통한 풀이
    public void solution1(int level, int sum) {
        if (sum == TARGET_COST) {
            minCoins = Math.min(minCoins, level);
        } else if (sum < TARGET_COST && level < minCoins) {
            for (int coin : COINS) {
                if (sum + coin <= TARGET_COST) {
                    solution1(level + 1, sum + coin);
                }
            }
        }
    }

    @Test
    @DisplayName("동전교환")
    public void main() {
        solution1(0, 0);
        assertEquals(EXPECTED_ANSWER, minCoins);
    }

}
