package com.roy.algorithm.inflearn.retry2.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 팩토리얼
//
// 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
// 예를 들어 5! = 5*4*3*2*1=120입니다.
// - 입력설명
// 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
// - 출력설명
// 첫 번째 줄에 N팩토리얼 값을 출력합니다.
// - 입력예제 1
// 5
// - 출력예제 1
// 120
@SuppressWarnings("NewClassNamingConvention")
public class Factorial {

    private static int ANSWER = 1;

    public int solution(int input) {
        if (input == 0) {
            return ANSWER;
        } else {
            ANSWER = ANSWER * input;
            solution(input - 1);
        }
        return ANSWER;
    }

    @Test
    @DisplayName("팩토리얼")
    public void main() {
        int input = 5;
        int expectedAnswer = 120;
        int answer = solution(input);
        assertEquals(expectedAnswer, answer);
    }

}
