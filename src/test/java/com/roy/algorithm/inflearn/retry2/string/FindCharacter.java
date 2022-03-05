package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 문자 찾기
//
// 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
// 대소문자를 구분하지 않습니다.
// 문자열의 길이는 100을 넘지 않습니다.
// - 입력설명
// 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
// - 출력설명
// 첫 줄에 해당 문자의 개수를 출력한다.
// - 입력예제 1
// Computercooler
// c
// - 출력예제 1
// 2
@SuppressWarnings("NewClassNamingConvention")
public class FindCharacter {

    public int solution1(String word, char target) {
        int answer = 0;
        word = word.toUpperCase();
        target = Character.toUpperCase(target);
        for (char c : word.toCharArray()) {
            if (c == target) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("문자 찾기")
    public void main() {
        String word = "Computercooler";
        char target = 'c';
        int expectedAnswer = 2;
        int answer = solution1(word, target);
        assertEquals(expectedAnswer, answer);
    }

}
