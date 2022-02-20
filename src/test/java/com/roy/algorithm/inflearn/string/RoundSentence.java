package com.roy.algorithm.inflearn.string;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 회문 문자열
//
// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
// 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력 하는 프로그램을 작성하세요.
// 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
// - 입력설명
// 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
// - 출력설명
// 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
// - 입력예제 1
// gooG
// - 출력예제 1
// YES
@SuppressWarnings("NewClassNamingConvention")
public class RoundSentence {

    // StringBuilder의 reverse를 사용한 방법
    public String solution1(String sentence) {
        String lowerCaseSentence = sentence.toLowerCase();
        StringBuilder answer = new StringBuilder(lowerCaseSentence);
        return answer.reverse().toString().equals(lowerCaseSentence)
                ? "YES"
                : "NO";
    }

    // 직접 문자열을 뒤집는 방법
    public String solution2(String sentence) {
        String lowerCaseSentence = sentence.toLowerCase();
        char[] lowerCaseSentenceChars = lowerCaseSentence.toCharArray();
        for (int i = 0; i < lowerCaseSentenceChars.length; i++) {
            if (lowerCaseSentenceChars[i] != lowerCaseSentenceChars[lowerCaseSentenceChars.length -1 -i]) {
                return "NO";
            }
        }
        return "YES";
    }

    @Test
    @DisplayName("회문 문자열")
    public void main() {
        String expectedAnswer = "YES";
        String answer1 = solution1("gooG");
        assertEquals(expectedAnswer, answer1);
        String answer2 = solution2("gooG");
        assertEquals(expectedAnswer, answer2);
    }

}
