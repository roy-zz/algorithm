package com.roy.algorithm.inflearn.hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

// K번째 큰 수
//
// 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
// 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
// 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
// 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
// - 입력설명
// 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
// - 출력설명
// 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
// - 입력예제 1
// 10 3
// 13 15 34 23 45 65 33 11 26 42
// - 출력예제 1
// 143
@SuppressWarnings("NewClassNamingConvention")
public class KthBigNumber {

    public int solution1(int length, int count, int[] numbers) {
        int answer = -1;
        Set<Integer> setOfSum = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    setOfSum.add(numbers[i] + numbers[j] + numbers[k]);
                }
            }
        }
        int tmpCount = 0;
        for (int sum : setOfSum) {
            tmpCount++;
            if (tmpCount == count) {
                return sum;
            }
        }

        return answer;
    }

    @Test
    @DisplayName("K번째 큰 수")
    public void main() {
        int expectedAnswer = 143;
        int answer1 = solution1(10, 3, new int[]{13, 15, 34, 23, 45, 65, 33, 11, 26, 42});
        assertEquals(expectedAnswer, answer1);
    }

}
