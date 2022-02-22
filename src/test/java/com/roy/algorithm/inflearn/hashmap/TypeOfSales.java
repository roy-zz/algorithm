package com.roy.algorithm.inflearn.hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 매출액의 종류
//
// 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속
// 된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
// 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
// 20 12 20 10 23 17 10
// 각 연속 4일간의 구간의 매출종류는
// 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
// 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
// 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
// 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
// N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
// 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
// - 출력설명
// 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
// - 입력예제 1
// 74
// 20 12 20 10 23 17 10
// - 출력예제 1
// 3 4 4 3
@SuppressWarnings("NewClassNamingConvention")
public class TypeOfSales {

    public Integer[] solution1(int days, int section, int[] sales) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> mapOfSales = new HashMap<>();
        for (int i = 0; i < section - 1; i++) {
            mapOfSales.put(sales[i], mapOfSales.getOrDefault(sales[i], 0) + 1);
        }
        int left = 0;
        for (int right = section - 1; right < days; right++) {
            mapOfSales.put(sales[right], mapOfSales.getOrDefault(sales[right], 0) + 1);
            answer.add(mapOfSales.size());
            mapOfSales.put(sales[left], mapOfSales.getOrDefault(sales[left], 0) - 1);
            if (mapOfSales.get(sales[left]) == 0) {
                mapOfSales.remove(sales[left]);
            }
            left++;
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("매출액의 종류")
    public void main() {
        int[] sales = {20, 12, 20, 10, 23, 17, 10};
        Integer[] expectedAnswer = {3, 4, 4, 3};
        Integer[] answer2 = solution1(7, 4, sales);
        assertArrayEquals(expectedAnswer, answer2);

    }

}
