package com.roy.algorithm.inflearn.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 조합의 경우의 수(메모이제이션)
//
// 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
// nCr = n-1Cr-1 + n-1Cr
// - 입력설명
// 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
// - 출력설명
// 첫째 줄에 조합수를 출력합니다.
// - 입력예제 1
// 5 3
// - 출력예제 1
// 10
// - 입력예제
// 2
// 33 19
// - 출력예제 2
// 818809200
@SuppressWarnings("NewClassNamingConvention")
public class NumberOfCombinations {

    // 자연수 n이 33까지 들어올 수 있으므로 최대 33개의 수가 저장될 수 있도록 한다.
    private final int[][] memory = new int[34][34];

    public int solution1(int n, int r) {
        if (memory[n][r] > 0) {
            return memory[n][r];
        } else {
            if (n == r || r == 0) {
                return 1;
            } else {
                return memory[n][r] = solution1(n - 1, r - 1) + solution1(n - 1, r);
            }
        }
    }

    @Test
    @DisplayName("조합의 경우의 수(메모이제이션")
    public void main() {
        int expectedAnswer1 = 10;
        int answer1 = solution1(5, 3);
        assertEquals(expectedAnswer1, answer1);
        int expectedAnswer2 = 818809200;
        int answer2 = solution1(33, 19);
        assertEquals(expectedAnswer2, answer2);
    }

}
