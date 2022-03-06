package com.roy.algorithm.inflearn.retry2.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 큰 수 출력하기
//
// N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.(첫 번째 수는 무조건 출력한다)
// - 입력설명
// 첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
// - 출력설명
// 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
// - 입력예제 1
// 6
// 7 3 9 5 6 12
// - 출력예제 1
// 7 9 6 12
@SuppressWarnings("NewClassNamingConvention")
public class PrintBigNumber {

    public Integer[] solution1(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        answer.add(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                answer.add(numbers[i]);
            }
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("큰 수 출력하기")
    public void main() {
        int[] numbers = {7, 3, 9, 5, 6, 12};
        Integer[] expectedAnswer = {7, 9, 6, 12};
        Integer[] answer = solution1(numbers);
        assertArrayEquals(expectedAnswer, answer);
    }

}
