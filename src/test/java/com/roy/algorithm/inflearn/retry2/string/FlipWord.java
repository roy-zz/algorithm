package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 단어 뒤집기
//
// N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
// 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
// - 출력설명
// N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
// - 입력예제 1
// 3
// good
// Time
// Big
// - 출력예제 1
// doog
// emiT
// giB
@SuppressWarnings("NewClassNamingConvention")
public class FlipWord {

    // 직접 뒤집는 방법
    public String[] solution1(String[] input) {
        String[] answer = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            char[] charOfWord = input[i].toCharArray();
            int left = 0;
            int right = charOfWord.length - 1;
            while (right >= left) {
                char temp = charOfWord[left];
                charOfWord[left] = charOfWord[right];
                charOfWord[right] = temp;
                left++;
                right--;
            }
            answer[i] = String.valueOf(charOfWord);
        }
        return answer;
    }

    // StringBuilder의 reverse 함수를 활용하는 방법
    public String[] solution2(String[] input) {
        String[] answer = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            StringBuilder word = new StringBuilder(input[i]);
            answer[i] = word.reverse().toString();
        }
        return answer;
    }

    @Test
    @DisplayName("단어 뒤집기")
    public void main() {
        String[] input = {"good", "Time", "Big"};
        String[] expectedAnswer = {"doog", "emiT", "giB"};
        String[] answer1 = solution1(input);
        assertArrayEquals(expectedAnswer, answer1);

        String[] answer2 = solution2(input);
        assertArrayEquals(expectedAnswer, answer2);
    }

}
