package com.roy.algorithm.inflearn.retry1.string;

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

    // Character의 isLowerCase를 사용한 풀이
    public String solution1(String input) {
        StringBuilder answer = new StringBuilder();
        for (char inputChar : input.toCharArray()) {
            answer.append(
                    Character.isLowerCase(inputChar)
                            ? Character.toUpperCase(inputChar)
                            : Character.toLowerCase(inputChar));
        }
        return answer.toString();
    }

    // ascii를 사용한 풀이, 대문자에 32를 더하면 소문자가 된다.
    // A ~ Z = 65 ~ 90
    // a ~ z = 97 ~ 122
    public String solution2(String input) {
        StringBuilder answer = new StringBuilder();
        for (char inputChar : input.toCharArray()) {
            if (inputChar >= 65 && inputChar <= 90) {
                answer.append((char) (inputChar + 32));
            } else if (inputChar >= 97 && inputChar <= 122) {
                answer.append((char) (inputChar - 32));
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("대소문자 변환")
    public void main() {
        String answer1 = solution1("StuDY");
        assertEquals("sTUdy", answer1);
        String answer2 = solution2("StuDY");
        assertEquals("sTUdy", answer2);
    }

}
