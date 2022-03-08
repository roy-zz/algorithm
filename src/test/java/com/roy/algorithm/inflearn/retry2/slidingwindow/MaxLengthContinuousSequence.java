package com.roy.algorithm.inflearn.retry2.slidingwindow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 최대 길이 연속부분수열
//
// 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
// 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
// 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면 11001101101101
// 여러분이 만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 [1 1 1 1 1 1 1 1] 0 1 이며 그 길이는 8입니다.
// - 입력설명
// 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다. 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
// - 출력설명
// 첫 줄에 최대 길이를 출력하세요.
// - 입력예제 1
// 14 2
// 11001101101101
// - 출력예제 1
// 8
@SuppressWarnings("NewClassNamingConvention")
public class MaxLengthContinuousSequence {

    public int solution1(int length, int change, int[] arr) {
        int answer = 0;
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > change) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }

    @Test
    @DisplayName("최대 길이 연속부분수열")
    public void main() {
        int length = 14;
        int change = 2;
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        int expectedAnswer = 8;
        int answer1 = solution1(length, change, arr);
        assertEquals(expectedAnswer, answer1);
    }

}
