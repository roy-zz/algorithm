package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 문자열 압축
//
// 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
// 단 반복횟수가 1인 경우 생략합니다.
// - 입력설명
// 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
// - 출력설명
// 첫 줄에 압축된 문자열을 출력한다.
// - 입력예제 1
// KKHSSSSSSSE
// - 출력예제 1
// K2HS7E
@SuppressWarnings("NewClassNamingConvention")
public class SentenceCompression {

    public String solution1(String input) {
        // 마지막 문자열을 위한 처리
        input = String.format("%s ", input);
        StringBuilder answer = new StringBuilder();
        int count = 1;
        char tempChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (tempChar == input.charAt(i)) {
                count++;
            } else {
                if (count > 1) {
                    answer.append(tempChar).append(count);
                } else {
                    answer.append(tempChar);
                }
                count = 1;
                tempChar = input.charAt(i);
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("문자열 압축")
    public void main() {
        String input = "KKHSSSSSSSE";
        String expectedAnswer = "K2HS7E";
        String answer = solution1(input);
        assertEquals(expectedAnswer, answer);
    }

}
