package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 가장 짧은 문자거리
//
// 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다. 문자열의 길이는 100을 넘지 않는다.
// - 출력설명
// 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
// - 입력예제 1
// teachermode e
// - 출력예제 1
// 10121012210
@SuppressWarnings("NewClassNamingConvention")
public class ShortestWordDistance {

    public int[] solution1(String word, char target) {
        int[] answer = new int[word.length()];
        int count = 100;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target) {
                count = 0;
            } else {
                count++;
            }
            answer[i] = count;
        }
        count = 100;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == target) {
                count = 0;
            } else {
                count++;
            }
            answer[i] = Math.min(answer[i], count);
        }
        return answer;
    }

    @Test
    @DisplayName("가장 짧은 문자거리")
    public void main() {
        String input = "teachermode";
        char target = 'e';
        int[] expectedAnswer = {1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0};
        int[] answer = solution1(input, target);
        assertArrayEquals(expectedAnswer, answer);
    }

}
