package com.roy.algorithm.inflearn.retry1.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.Collectors;

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

    // Stack을 활용한 풀이
    public String solution1(String input) {
        Stack<Character> stackOfBrackets = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stackOfBrackets.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                while (true) {
                    if (stackOfBrackets.pop() == '(') {
                        break;
                    }
                }
            } else {
                stackOfBrackets.add(input.charAt(i));
            }
        }
        return stackOfBrackets.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // 괄호가 정상이라는 가정하에 단순 괄호 계산을 통한 풀이
    public String solution2(String input) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                count++;
            } else if (input.charAt(i) == ')') {
                count--;
            } else if (count == 0) {
                answer.append(input.charAt(i));
            }
        }
        return answer.toString();
    }

    @Test
    @DisplayName("괄호 문자 제거")
    public void main() {
        String input = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        String expectedAnswer = "EFLM";
        String answer1 = solution1(input);
        assertEquals(expectedAnswer, answer1);
        String answer2 = solution2(input);
        assertEquals(expectedAnswer, answer2);
    }

}
