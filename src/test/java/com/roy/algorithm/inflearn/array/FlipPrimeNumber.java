package com.roy.algorithm.inflearn.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 뒤집은 소수
//
// N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
// 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출 력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
// 첫 자리부터의 연속된 0은 무시한다.
// - 입력설명
// 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다. 각 자연수의 크기는 100,000를 넘지 않는다.
// - 출력설명
// 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
// - 입력예제 1
// 9
// 32 55 62 20 250 370 200 30 100
// - 출력예제 1
// 23 2 73 2 3
@SuppressWarnings("NewClassNamingConvention")
public class FlipPrimeNumber {

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Integer[] solution1(int... inputs) {
        List<Integer> flipPrimeNumbers = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            int tmp = inputs[i];
            int result = 0;
            while (tmp > 0) {
                // 입력받은 값을 10으로 나눈 값의 소수점을 구한다.
                int decimalPoint = tmp % 10;
                // 결과 값에 10을 곱해주고 소수점을 더한다.
                result = result * 10 + decimalPoint;
                // 현재 값을 10으로 나누어 1의 자리를 버리도록 한다.
                tmp = tmp / 10;
            }
            if (isPrime(result)) {
                flipPrimeNumbers.add(result);
            }
        }
        return flipPrimeNumbers.toArray(new Integer[0]);
    }

    // StringBuilder의 reverse를 활용한 방법이다.
    // 입력받은 문자열을 String으로 변환하여 reverse함수를 사용하여 뒤집는다.
    // 뒤집은 문자열을 Integer의 parseInt 함수를 사용하여 형변환을 시킨다.
    // 이 때 가장 앞자리가 0인 경우 0은 제거되고 숫자로 형변환이 된다.
    public Integer[] solution2(int... inputs) {
        List<Integer> flipPrimeNumbers = new ArrayList<>();
        for (int input : inputs) {
            input = Integer.parseInt(new StringBuilder(String.valueOf(input)).reverse().toString());
            if (isPrime(input)) {
                flipPrimeNumbers.add(input);
            }
        }
        return flipPrimeNumbers.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("뒤집은 소수")
    public void main() {
        Integer[] expectedAnswer = {23, 2, 73, 2, 3};
        Integer[] answer1 = solution1(32, 55, 62, 20, 250, 370, 200, 30, 100);
        assertArrayEquals(expectedAnswer, answer1);
        Integer[] answer2 = solution2(32, 55, 62, 20, 250, 370, 200, 30, 100);
        assertArrayEquals(expectedAnswer, answer2);
    }

}
