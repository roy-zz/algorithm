package com.roy.algorithm.inflearn.retry2.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 문장 속 단어
//
// 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. 문장속의 각 단어는 공백으로 구분됩니다.
// - 입력설명
// 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성 되어 있습니다.
// - 출력설명
// 첫 줄에 가장 긴 단어를 출력한다. 가장 긴 단어가 여러개일 경우 문장속에가 가장 앞쪽에 위치한 단어를 답으로 합니다.
// - 입력예제 1
// it is time to studyy studyz
// - 출력예제 1
// studyy
@SuppressWarnings("NewClassNamingConvention")
public class WordInSentence {

    public String solution1(String input) {
        String answer = "";
        String[] seperated = input.split(" ");
        for (String word : seperated) {
            if (word.length() > answer.length()) {
                answer = word;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("문장 속 단어")
    public void main() {
        String input = "it is time to studyy studyz";
        String expectedAnswer = "studyy";
        String answer = solution1(input);
        assertEquals(expectedAnswer, answer);
    }

}
