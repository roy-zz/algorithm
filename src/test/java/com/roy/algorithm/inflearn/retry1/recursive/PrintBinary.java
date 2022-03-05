package com.roy.algorithm.inflearn.retry1.recursive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 재귀함수를 이용한 이진수 출력
//
// 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
// 단 재귀함수를 이용해서 출력해야 합니다.
// - 입력설명
// 첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
// - 출력설명
// 첫 번째 줄에 이진수를 출력하세요.
// - 입력예제 1
// 11
// - 출력예제 1
// 1011
@SuppressWarnings("NewClassNamingConvention")
public class PrintBinary {

    StringBuilder answer = new StringBuilder();

    public String solution1(int number) {
        if (number == 0) {
            return answer.toString();
        } else {
            solution1(number / 2);
            answer.append(number % 2);
        }
        return answer.toString();
    }

    @Test
    @DisplayName("재귀함수를 이용한 이진수 출력")
    public void main() {
        String expectedAnswer = "1011";
        String answer1 = solution1(11);
        Assertions.assertEquals(expectedAnswer, answer1);
    }

}
