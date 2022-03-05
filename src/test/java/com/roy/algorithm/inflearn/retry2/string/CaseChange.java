package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 대소문자 변환
//
// 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
// - 출력설명
// 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
// - 입력예제 1
// StuDY
// - 출력예제 1
// sTUdy
@SuppressWarnings("NewClassNamingConvention")
public class CaseChange {

    // ASCII 코드를 활용한 방법
    // 다른 언어에서도 동일한 방법으로 해결할 수 있기 때문에 좋은 방법이라고 생각된다.
    public String solution1(String input) {
        StringBuilder answer = new StringBuilder();
        char[] charOfInput = input.toCharArray();
        for (char c : charOfInput) {
            // 대문자인 경우
            if (c >= 65 && c <= 90) {
                answer.append((char) (c + 32));
            // 소문자인 경우
            } else if (c >= 65 + 32 && c <= 90 + 32) {
                answer.append((char) (c - 32));
            }
        }
        return answer.toString();
    }

    // Java 함수를 활용하는 방법
    public String solution2(String input) {
        StringBuilder answer = new StringBuilder();
        char[] charOfInput = input.toCharArray();
        for (char c : charOfInput) {
            answer.append(
                    Character.isLowerCase(c)
                            ? Character.toUpperCase(c)
                            : Character.toLowerCase(c)
            );
        }
        return answer.toString();
    }

    @Test
    @DisplayName("대소문자 변환")
    public void main() {
        String input1 = "StuDY";
        String expectedAnswer1 = "sTUdy";
        String answer1 = solution1(input1);
        String answer2 = solution2(input1);
        assertEquals(expectedAnswer1, answer1);
        assertEquals(expectedAnswer1, answer2);
    }

}
