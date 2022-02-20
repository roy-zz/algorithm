package com.roy.algorithm.inflearn.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 숫자만 추출
//
// 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만 듭니다.
// 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205 이 됩니다.
// 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
// - 입력설명
// 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
// - 출력설명
// 첫 줄에 자연수를 출력합니다.
// - 입력예제 1 g0en2T0s8eSoft
// - 출력예제 1 208
@SuppressWarnings("NewClassNamingConvention")
public class ExtractNumber {

    // ascii 코드를 활용하여 숫자만 추출하는 방법
    public int solution1(String sentence) {
        char[] chars = sentence.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char c : chars) {
            if (c >= 48 && c <= 57) {
                answer.append(c);
            }
        }
        return Integer.parseInt(answer.toString());
    }

    // Character의 isDisit() 함수를 활용한 방법
    public int solution2(String sentence) {
        char[] chars = sentence.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                answer.append(c);
            }
        }
        return Integer.parseInt(answer.toString());
    }


    @Test
    @DisplayName("숫자만 추출")
    public void main() {
        int expectedAnswer = 208;
        int answer1 = solution1("g0en2T0s8eSoft");
        assertEquals(expectedAnswer, answer1);
        int answer2 = solution2("g0en2T0s8eSoft");
        assertEquals(expectedAnswer, answer2);
    }

}
