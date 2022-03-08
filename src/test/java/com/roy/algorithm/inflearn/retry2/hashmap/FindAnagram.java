package com.roy.algorithm.inflearn.retry2.hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 모든 아나그램 찾기
//
// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
// 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
// - 입력설명
// 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
// S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
// - 출력설명
// S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
// - 입력예제 1
// bacaAacba
// abc
// - 출력예제 1
// 3
// 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
// - 입력예제 2
// bacaAacbaa
// abca
// - 출력예제 2
// 3
// HARD
@SuppressWarnings("NewClassNamingConvention")
public class FindAnagram {

    public int solution(String inputs, String target) {
        int answer = 0;
        Map<Character, Integer> mapOfTarget = new HashMap<>();
        Map<Character, Integer> mapOfInput = new HashMap<>();
        for (char c : target.toCharArray()) {
            mapOfTarget.put(c, mapOfTarget.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < target.length() - 1; i++) {
            mapOfInput.put(inputs.charAt(i), mapOfInput.getOrDefault(inputs.charAt(i), 0) + 1);
        }
        int left = 0;
        for (int right = target.length() - 1; right < inputs.length(); right++) {
            mapOfInput.put(inputs.charAt(right), mapOfInput.getOrDefault(inputs.charAt(right), 0) + 1);
            if (mapOfInput.equals(mapOfTarget)) {
                answer++;
            }
            mapOfInput.put(inputs.charAt(left), mapOfInput.getOrDefault(inputs.charAt(left), 0) - 1);
            if (mapOfInput.getOrDefault(inputs.charAt(left), 0) == 0) {
                mapOfInput.remove(inputs.charAt(left));
            }
            left++;
        }
        return answer;
    }

    @Test
    @DisplayName("모든 아나그램  찾기")
    public void main() {
        String inputs1 = "bacaAacba";
        String target1 = "abc";
        int expectedAnswer1 = 3;
        int answer1 = solution(inputs1, target1);
        assertEquals(expectedAnswer1, answer1);

        String inputs2 = "bacaAacbaa";
        String target2 = "abca";
        int expectedAnswer2 = 3;
        int answer2 = solution(inputs2, target2);
        assertEquals(expectedAnswer2, answer2);
    }

}
