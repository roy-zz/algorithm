package com.roy.algorithm.inflearn.retry1.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 특정 문자 뒤집기
//
// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
// - 출력설명
// 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
// - 입력예제 1
// a#b!GE*T@S
// - 출력예제 1
// S#T!EG*b@a
@SuppressWarnings("NewClassNamingConvention")
public class FlipSpecificWord {

    public String solution1(String word) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (Character.isAlphabetic(chars[left]) && Character.isAlphabetic(chars[right])) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
            }
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    @Test
    @DisplayName("특정 문자 뒤집기")
    public void main() {
        String answer1 = solution1("a#b!GE*T@S");
        Assertions.assertEquals("S#T!EG*b@a", answer1);
    }

}
