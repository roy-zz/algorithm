package com.roy.algorithm.inflearn.retry1.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    public int[] solution1(String sentence, char target) {
        int[] distances = new int[sentence.length()];
        int position = 100;

        // 정방향으로 순회하며 target과 떨어진 거리를 구하여 distances 배열에 넣는다.
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == target) {
                position = 0;
            } else {
                position++;
            }
            distances[i] = position;
        }
        // position 값을 최대 문자열의 길이인 100으로 초기화한다.
        position = 100;
        // 역방향으로 순회하며 target과 떨어진 거리를 구하여 distances 배열에 넣는다.
        // 이때 정방향으로 구한 거리보다 짧은 경우에만 distances 배열을 업데이트 한다.
        for (int i = sentence.length() - 1; i >= 0; i--) {
            if (sentence.charAt(i) == target) {
                position = 0;
            } else {
                position++;
                distances[i] = Math.min(distances[i], position);
            }
        }
        return distances;
    }


    @Test
    @DisplayName("가장 빫은 문자거리")
    public void main() {
        int[] expectedAnswer = {1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0};
        int[] answer1 = solution1("teachermode", 'e');
        Assertions.assertArrayEquals(expectedAnswer, answer1);
    }

}
