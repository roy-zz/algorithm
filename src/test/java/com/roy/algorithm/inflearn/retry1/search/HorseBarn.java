package com.roy.algorithm.inflearn.retry1.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 마구간 정하기 (결정알고리즘)
//
// N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며,
// 마구간 간의 좌표가 중복되는 일은 없습니다.
// 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다.
// 각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
// C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대 값을 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다. 둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
// - 출력설명
// 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
// - 입력예제 1
// 5 3
// 1 2 8 4 9
// - 출력예제 1
// 3
@SuppressWarnings("NewClassNamingConvention")
public class HorseBarn {

    public int decision(int distance, int[] barns) {
        int answer = 1;
        int startingPoint = barns[0];
        for (int i = 0; i < barns.length; i++) {
            if (barns[i] - startingPoint >= distance) {
                answer++;
                startingPoint = barns[i];
            }
        }
        return answer;
    }

    public int solution1(int horseCount, int[] barns) {
        Arrays.sort(barns);
        int answer = 0;
        // 가능한 말들의 거리의 최소값과 최대값을 구한다.
        int maxDistance = Arrays.stream(barns).max().getAsInt();
        int minDistance = 1;

        while (minDistance <= maxDistance) {
            int mid = (maxDistance + minDistance) / 2;
            if (decision(mid, barns) >= horseCount) {
                minDistance = mid + 1;
                answer = mid;
            } else {
                maxDistance = mid - 1;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("마구간")
    public void main() {
        int barnCount = 3;
        int[] barns = {1, 2, 8, 4, 9};
        int expectedAnswer = 3;
        int answer1 = solution1(barnCount, barns);
        assertEquals(expectedAnswer, answer1);
    }

}