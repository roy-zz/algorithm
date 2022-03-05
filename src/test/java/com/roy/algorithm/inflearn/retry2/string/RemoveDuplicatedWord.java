package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 중복 문자 제거
//
// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
// 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
// - 입력설명
// 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
// - 출력설명
// 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
// - 입력예제 1
// ksekkset
// - 출력예제 1
// kset
@SuppressWarnings("NewClassNamingConvention")
public class RemoveDuplicatedWord {

    public String solution1(String input) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i == input.indexOf(input.charAt(i))) {
                answer.append(input.charAt(i));
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("중복 문자 제거")
    public void main() {
        String input = "ksekkset";
        String expectedAnswer = "kset";
        String answer = solution1(input);
        assertEquals(expectedAnswer, answer);
    }

}
