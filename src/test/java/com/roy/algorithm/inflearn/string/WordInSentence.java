package com.roy.algorithm.inflearn.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 문장 속 단어
//
// 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. 문장속의 각 단어는 공백으로 구분됩니다.
// - 입력설명
// 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성 되어 있습니다.
// - 출력설명
// 첫 줄에 가장 긴 단어를 출력한다. 가장 긴 단어가 여러개일 경우 문장속에가 가장 앞쪽에 위 치한 단어를 답으로 합니다.
// - 입력예제 1
// it is time to study
// - 출력예제 1
// study
@SuppressWarnings("NewClassNamingConvention")
public class WordInSentence {

    public String solution1(String sentence) {
        int maxLength = Integer.MIN_VALUE;
        int maxLengthWordIndex = Integer.MIN_VALUE;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxLength) {
                maxLength = words[i].length();
                maxLengthWordIndex = i;
            }
        }
        return words[maxLengthWordIndex];
    }

    // indexOf를 사용한 방법
    public String solution2(String sentence) {
        String answer = "";
        int maxLength = Integer.MIN_VALUE;
        int position;
        while ((position = sentence.indexOf(" ")) != -1) {
            String tmp = sentence.substring(0, position);
            if (tmp.length() > maxLength) {
                answer = tmp;
                maxLength = tmp.length();
            }
            // 공백 부분까지 지워줘야 하므로 +1
            sentence = sentence.substring(position + 1);
        }
        // while 조건에 의해 가장 마지막 문자는 while의 로직을 타지 않으므로 따로 처리
        if (sentence.length() > maxLength) {
            answer = sentence;
        }
        return answer;
    }

    @Test
    @DisplayName("문장 속 단어")
    public void main() {
        String answer1 = solution1("it is time to study");
        Assertions.assertEquals("study", answer1);
        String answer2 = solution2("it is time to study");
        Assertions.assertEquals("study", answer2);
    }

}
