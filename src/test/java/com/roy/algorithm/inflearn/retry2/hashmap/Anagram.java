package com.roy.algorithm.inflearn.retry2.hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 아나그램
//
// Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
// 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치합니다.
// 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
// 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요.
// 아나그램 판별시 대소문자가 구분됩니다.
// - 입력설명
// 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다. 단어의 길이는 100을 넘지 않습니다.
// - 출력설명
// 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
// - 입력예제 1
// AbaAeCe
// baeeACA
// - 출력예제 1
// YES
// - 입력예제 2
// abaCC
// Caaab
// - 출력예제 2
// NO
@SuppressWarnings("NewClassNamingConvention")
public class Anagram {

    public String solution(String wordA, String wordB) {
        if (wordA.length() != wordB.length()) {
            return "NO";
        }
        Map<Character, Integer> mapOfWordA = new HashMap<>();
        Map<Character, Integer> mapOfWordB = new HashMap<>();
        for (int i = 0; i < wordA.length(); i++) {
            mapOfWordA.put(wordA.charAt(i), mapOfWordA.getOrDefault(wordA.charAt(i), 0) + 1);
            mapOfWordB.put(wordB.charAt(i), mapOfWordB.getOrDefault(wordB.charAt(i), 0) + 1);
        }
        for (char c : mapOfWordA.keySet()) {
            if (!Objects.equals(mapOfWordA.get(c), mapOfWordB.get(c))) {
                return "NO";
            }
        }
        return "YES";
    }

    @Test
    @DisplayName("아나그램")
    public void main() {
        String wordA1 = "AbaAeCe";
        String wordB1 = "baeeACA";
        String expectedAnswer1 = "YES";
        String answer1 = solution(wordA1, wordB1);
        assertEquals(expectedAnswer1, answer1);

        String wordA2 = "abaCC";
        String wordB2 = "Caaab";
        String expectedAnswer2 = "NO";
        String answer2 = solution(wordA2, wordB2);
        assertEquals(expectedAnswer2, answer2);
    }

}
