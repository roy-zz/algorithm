package com.roy.algorithm.inflearn.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 중복 문자 제거
//
// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
// 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
// - 입력설명
// 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
// - 출력설명
// 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
// - 입력예제 1
// ksekkset
// - 출력예제 1
// kset
@Slf4j
@SuppressWarnings("NewClassNamingConvention")
public class RemoveDuplicatedWord {

    public String solution1(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            // word.indexOf("a")라고 가정하였을 때 word의 문자열 중 가장 앞의 a의 index를 return한다.
            // 만약 i와 word.indexOf(word.charAt(i))가 일치한다면 해당 char는 word중 가장 첫번째 문자다.
            // 만약 i와 word.indexOf(word.charAt(i))가 일치하지 않는다면 해당 char는 앞에서 이미 존재했던 char가 된다.
            // log.info("{}, {}, {}", word.charAt(i), i, word.indexOf(word.charAt(i)));
            if (i == word.indexOf(word.charAt(i))) {
                answer.append(word.charAt(i));
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("중복 문자 제거")
    public void main() {
        String answer1 = solution1("ksekkset");
        Assertions.assertEquals("kset", answer1);
    }
}

