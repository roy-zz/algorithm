package com.roy.algorithm.inflearn.retry2.array;

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

//    private boolean isPrime(int number) {
//
//    }

    private int flip(int number) {
        StringBuilder sbNumber = new StringBuilder(number);
        sbNumber.reverse();
        return Integer.parseInt(sbNumber.toString());
    }

    public Integer[] solution1(int[] inputs) {
        List<Integer> answer = new ArrayList<>();
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("뒤집은 소수")
    public void main() {
        int[] inputs = {32, 55, 62, 20, 250, 370, 200, 30, 100};
        Integer[] expectedAnswer = {23, 2, 73, 2, 3};
        Integer[] answer = solution1(inputs);
        assertArrayEquals(expectedAnswer, answer);
    }

}
