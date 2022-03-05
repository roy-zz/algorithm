package com.roy.algorithm.inflearn.retry1.string;

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

    public String solution1(String sentence) {
        StringBuilder answer = new StringBuilder();
        // 입력받은 문자열의 마지막 문자열을 위해 가장 마지막에 공백을 하나 추가한다.
        char[] chars = String.format("%s ", sentence).toCharArray();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                answer.append(chars[i]);
                if (count > 1) {
                    answer.append(count);
                }
                count = 1;
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("문자열 압축")
    public void main() {
        String expectedAnswer = "K2HS7E";
        String answer1 = solution1("KKHSSSSSSSE");
        assertEquals(expectedAnswer, answer1);
    }

}
