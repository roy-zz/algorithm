package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 특정 문자 뒤집기
//
// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
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

    // isAlphabetic 함수를 활용한 방법
    public String solution1(String input) {
        char[] charOfInput = input.toCharArray();
        for (int i = 0; i < charOfInput.length / 2; i++) {
            if (Character.isAlphabetic(charOfInput[i])) {
                char temp = charOfInput[i];
                charOfInput[i] = charOfInput[charOfInput.length - i - 1];
                charOfInput[charOfInput.length - i - 1] = temp;
            }
        }
        return String.valueOf(charOfInput);
    }

    // ASCII 코드를 활용한 방법
    public String solution2(String input) {
        char[] charOfInput = input.toCharArray();
        for (int i = 0; i < charOfInput.length / 2; i++) {
            if ((charOfInput[i] >= 65 && charOfInput[i] <= 90)
                || (charOfInput[i] >= 65 + 32 && charOfInput[i] <= 90 + 32)) {
                char temp = charOfInput[i];
                charOfInput[i] = charOfInput[charOfInput.length - i - 1];
                charOfInput[charOfInput.length - i - 1] = temp;
            }
        }
        return String.valueOf(charOfInput);
    }

    // solution1, solution2는 한쪽만 확인하고 반대쪽은 확인하지 않았다.
    // 양쪽을 모두 확인하는 방법
    public String solution3(String input) {
        char[] charOfInput = input.toCharArray();
        int left = 0;
        int right = charOfInput.length - 1;
        while (right >= left) {
            if (Character.isAlphabetic(charOfInput[left])
                    && Character.isAlphabetic(charOfInput[right])) {
                char temp = charOfInput[left];
                charOfInput[left] = charOfInput[right];
                charOfInput[right] = temp;
            }
            left++;
            right--;
        }
        return String.valueOf(charOfInput);
    }

    @Test
    @DisplayName("특정 문자 뒤집기")
    public void main() {
        String input = "a#b!GE*T@S";
        String expectedAnswer = "S#T!EG*b@a";
        String answer1 = solution1(input);
        assertEquals(expectedAnswer, answer1);

        String answer2 = solution2(input);
        assertEquals(expectedAnswer, answer2);

        String answer3 = solution3(input);
        assertEquals(expectedAnswer, answer3);
    }

}
