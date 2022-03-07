package com.roy.algorithm.inflearn.retry2.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 괄호 문자 제거
//
// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
// - 출력설명
// 남은 문자만 출력한다.
// - 입력예제 1 (A(BC)D)EF(G(H)(IJ)K)LM(N)
// - 출력예제 1 EFLM
@SuppressWarnings("NewClassNamingConvention")
public class RemoveBracketCharacter {

    public String solution1(String inputs) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stackOfChar = new Stack<>();
        for (char c : inputs.toCharArray()) {
            switch (c) {
                case '(':
                    stackOfChar.push(c);
                    break;
                case ')':
                    stackOfChar.pop();
                    break;
                default :
                    if (stackOfChar.isEmpty()) {
                        answer.append(c);
                    }
                    break;
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("괄호 문자 제거")
    public void main() {
        String inputs = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        String expectedAnswer = "EFLM";
        String answer = solution1(inputs);
        assertEquals(expectedAnswer, answer);
    }

}
