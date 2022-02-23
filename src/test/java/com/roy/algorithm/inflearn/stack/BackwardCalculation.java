package com.roy.algorithm.inflearn.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 후위식 연산(postfix)
//
// 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
// 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
// - 입력설명
// 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다. 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
// - 출력설명
// 연산한 결과를 출력합니다.
// - 입력예제 1
// 352+*9-
// - 출력예제 1
// 12
@SuppressWarnings("NewClassNamingConvention")
public class BackwardCalculation {

    public int solution1(String input) {
        char[] chars = input.toCharArray();
        Stack<Integer> stackOfChar = new Stack<>();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                // Ascii '0' 은 10진수 48이므로
                // Ascii - 48 은 10진수 0이 된다.
                stackOfChar.push(c - 48);
            } else {
                int right = stackOfChar.pop();
                int left = stackOfChar.pop();
                switch (c) {
                    case '+':
                        stackOfChar.push(left + right);
                        break;
                    case '-':
                        stackOfChar.push(left - right);
                        break;
                    case '*':
                        stackOfChar.push(left * right);
                        break;
                    case '/':
                        stackOfChar.push(left / right);
                        break;
                }
            }
        }
        return stackOfChar.get(0);
    }

    @Test
    @DisplayName("후위식 연산")
    public void main() {
        String input = "352+*9-";
        int expectedAnswer = 12;
        int answer1 = solution1(input);
        assertEquals(expectedAnswer, answer1);
    }

}
