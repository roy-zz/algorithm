package com.roy.algorithm.inflearn.retry1.utilizedfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 합이 같은 부분집합(DFS, 아마존 기출)
//
// N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고,
// 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
// 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어야 합니다.
// 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
// - 입력설명
// 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
// 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
// - 출력설명
// 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
// - 입력예제 1
// 6
// 1 3 5 6 7 10
// - 출력예제 1
// YES
@SuppressWarnings("NewClassNamingConvention")
public class SameSumSubset {

    private static final int[] NUMBERS = {1, 3, 5, 6, 7, 10};
    private static final int TOTAL_SUM = Arrays.stream(NUMBERS).sum();
    private boolean isEnd = false;
    private String answer = "NO";

    public void solution1(int level, int sum) {
        // 이미 조건에 부합하는 부분집합을 찾은 경우 더이상 로직을 타지않도록 return 처리한다.
        if (isEnd == Boolean.TRUE) {
            return;
        }
        // 최대합을 2로 나눈 경우가 sum보다 큰 경우는 끝까지 진행하더라도 문제에서 원하는 부분집합일 수 없으므로
        // 더이상 로직을 타지 않도록 return 처리한다.
        if (sum > TOTAL_SUM / 2) {
            return;
        }
        if (level == NUMBERS.length) {
            if (TOTAL_SUM / 2 == sum) {
                answer = "YES";
                isEnd = true;
            }
        } else {
            // 포함되는 경우
            solution1(level + 1, sum + NUMBERS[level]);
            // 포함되지 않는 경우
            solution1(level + 1, sum);
        }
    }

    @Test
    @DisplayName("합이 같은 부분집합(DFS)")
    public void main() {
        String expectedAnswer = "YES";
        solution1(0, 0);
        assertEquals(expectedAnswer, answer);
    }

}
