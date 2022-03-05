package com.roy.algorithm.inflearn.retry1.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 단어 뒤집기
//
// N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
// 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되 어 있습니다.
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

    // StringBuilder의 reverse() 함수를 사용하는 방법
    public String[] solution1(String... words) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            answer.add(new StringBuilder(word).reverse().toString());
        }
        return answer.toArray(new String[0]);
    }

    // 직접 뒤집는 방식
    public String[] solution2(String... words) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
            answer.add(String.valueOf(chars));
        }
        return answer.toArray(new String[0]);
    }

    @Test
    @DisplayName("단어 뒤집기")
    public void main() {
        String[] expectedAnswer = {"doog", "emiT", "giB"};
        String[] answer1 = solution1("good", "Time", "Big");
        assertArrayEquals(answer1, expectedAnswer);
        String[] answer2 = solution2("good", "Time", "Big");
        assertArrayEquals(answer2, expectedAnswer);
    }

}
