package com.roy.algorithm.inflearn.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 유효한 팰린드롬
//
// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
// 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
// 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다. 알파벳 이외의 문자들의 무시합니다.
// - 입력설명
// 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
// - 출력설명
// 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
// - 입력예제 1
// found7, time: study; Yduts; emit, 7Dnuof
// - 출력예제 1 YES
@SuppressWarnings("NewClassNamingConvention")
public class Palindrome {

    // 정규식을 통한 ReplaceAll과 StringBuilder의 reverse를 사용하는 방법
    public String solution1(String sentence) {
        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder reversedSentence = new StringBuilder(sentence).reverse();
        return reversedSentence.toString().equals(sentence)
                ? "YES"
                : "NO";
    }

    // 직접 문자열을 하나씩 비교하는 방법
    public String solution2(String sentence) {
        String lowerSentence = sentence.toLowerCase();
        char[] chars = lowerSentence.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char left = chars[i];
            char right = chars[chars.length -i -1];
            if (Character.isAlphabetic(left) && Character.isAlphabetic(right)) {
                if (left != right) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    // ascii 코드를 활용하여 직접 문자열을 하나씩 비교하는 방법
    public String solution3(String sentence) {
        char[] chars = sentence.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char left = chars[i];
            char right = chars[chars.length -1 -i];
            if (left >= 97 && right >= 97 && left <= 122 && right <= 122) {
                if (left != right) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    @Test
    @DisplayName("유효한 팰린드롬")
    public void main() {
        String expectedAnswer = "YES";
        String answer1 = solution1("found7, time: study; Yduts; emit, 7Dnuof");
        assertEquals(expectedAnswer, answer1);
        String answer2 = solution2("found7, time: study; Yduts; emit, 7Dnuof");
        assertEquals(expectedAnswer, answer2);
        String answer3 = solution3("found7, time: study; Yduts; emit, 7Dnuof");
        assertEquals(expectedAnswer, answer3);
    }

}
