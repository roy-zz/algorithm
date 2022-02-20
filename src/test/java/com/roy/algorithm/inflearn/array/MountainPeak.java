package com.roy.algorithm.inflearn.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 봉우리
//
// 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
// 각 격자 판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
// 봉우리 지역이 몇 개 있는지 알아내는 프로그램을 작성하세요.
// 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
// 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
// 0   0   0   0   0   0   0
// 0  (5)  3  (7)  2  (3)  0
// 0   3  (7)  1  (6)  1   0
// 0  (7)  2   5   3  (4)  0
// 0   4   3  (6)  4   1   0
// 0  (8)  7   3  (5)  2   0
// 0   0   0   0   0   0   0
// - 입력설명
// 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
// 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
// - 출력설명
// 봉우리의 개수를 출력하세요.
// - 입력예제 1
// 5
// 53723
// 37161
// 72534
// 43641
// 87352
// - 출력예제 1
// 10
@SuppressWarnings("NewClassNamingConvention")
public class MountainPeak {

    public int solution1(int[][] inputs) {
        int[] xDirection = {-1, 0, 1, 0};
        int[] yDirection = {0, 1, 0, -1};
        int peakCount = 0;

        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs.length; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nextX = i + xDirection[k];
                    int nextY = j + yDirection[k];
                    // nextX와 nextY가 음수 또는 배열 범위 밖의 값을 참조하는 것을 방지한다.
                    if (nextX >= 0 && nextX < inputs.length
                            && nextY >= 0 && nextY < inputs.length
                            && inputs[nextX][nextY] >= inputs[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (Boolean.TRUE == flag) {
                    peakCount++;
                }
            }
        }
        return peakCount;
    }

    @Test
    @DisplayName("봉우리")
    public void main() {
        int[][] inputs = {
                {5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2}
        };
        int expectedAnswer = 10;
        int answer1 = solution1(inputs);
        assertEquals(expectedAnswer, answer1);
    }

}
