package com.roy.algorithm.inflearn.retry1.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 재귀함수
//
// 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
// - 출력설명
// 첫째 줄에 출력한다.
// - 입력예제 1
// 3
// - 출력예제 1
// 1 2 3
@SuppressWarnings("NewClassNamingConvention")
public class RecursiveFunction {

    private List<Integer> answer = new ArrayList<>();

    public Integer[] solution1(int number) {
        if (number == 0) {
            return answer.toArray(new Integer[0]);
        } else {
            solution1(number - 1);
            answer.add(number);
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("재귀함수")
    public void main() {
        Integer[] expectedAnswer = {1, 2, 3};
        Integer[] answer1 = solution1(3);
        assertArrayEquals(expectedAnswer, answer1);
    }

}
