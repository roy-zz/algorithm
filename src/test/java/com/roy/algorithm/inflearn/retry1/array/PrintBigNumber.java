package com.roy.algorithm.inflearn.retry1.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 큰 수 출력하기
//
// N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작 성하세요.(첫 번째 수는 무조건 출력한다)
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

    public Integer[] solution1(int... inputs) {
        List<Integer> answer = new ArrayList<>(List.of(inputs[0]));
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i - 1] < inputs[i]) {
                answer.add(inputs[i]);
            }
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("큰 수 출력하기")
    public void main() {
        Integer[] expectedAnswer = {7, 9, 6, 12};
        Integer[] answer1 = solution1(7, 3, 9, 5, 6, 12);
        assertArrayEquals(expectedAnswer, answer1);
    }

}
