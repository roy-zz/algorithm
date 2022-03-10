package com.roy.algorithm.inflearn.retry2.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 이분검색
//
// 임의의 N개의 숫자가 입력으로 주어집니다.
// N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
// 단 중복값은 존재하지 않습니다.
// - 입력설명
// 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다. 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
// - 출력설명
// 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
// - 입력예제 1
// 8 32
// 23 87 65 12 57 32 99 81
// - 출력예제 1
// 3
// - 풀이
// 이분탐색법 암기할 것!
@SuppressWarnings("NewClassNamingConvention")
public class BinarySearch {

    public int solution1(int[] numbers, int targetNumber) {
        Arrays.sort(numbers);
        int answer = 0;
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = numbers[mid];
            if (temp == targetNumber) {
                answer = mid + 1;
                break;
            } else if (temp > targetNumber) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("이분검색")
    public void main() {
        int[] numbers = {23, 87, 65, 12, 57, 32, 99, 81};
        int targetNumber = 32;
        int expectedAnswer = 3;
        int answer = solution1(numbers, targetNumber);
        assertEquals(expectedAnswer, answer);
    }

}
