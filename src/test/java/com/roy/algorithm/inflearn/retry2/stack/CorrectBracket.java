package com.roy.algorithm.inflearn.retry2.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 올바른 괄호
//
// 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
// (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
// - 입력설명
// 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
// - 출력설명
// 첫 번째 줄에 YES, NO를 출력한다.
// - 입력예제 1
// (()(()))(()
// - 출력예제 1
// NO
@SuppressWarnings("NewClassNamingConvention")
public class CorrectBracket {

    public String solution1(String inputs) {
        Stack<Character> stackOfInputs = new Stack<>();
        for (char c : inputs.toCharArray()) {
            if (c == '(') {
                stackOfInputs.push(c);
            } else if (stackOfInputs.isEmpty()) {
                return "NO";
            } else {
                stackOfInputs.pop();
            }
        }
        return stackOfInputs.isEmpty() ? "YES" : "NO";
    }

    @Test
    @DisplayName("올바른 괄호")
    public void main() {
        String inputs = "(()(()))(()";
        String expectedAnswer = "NO";
        String answer = solution1(inputs);
        assertEquals(expectedAnswer, answer);
    }

}
