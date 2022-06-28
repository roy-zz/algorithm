package com.roy.algorithm.programmers.retry1.stackqueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class StockPriceSolution {

  @Test
  void solutionTest() {

    int[] pricesForCase1 = {1, 2, 3, 2, 3};
    int[] expectedResultForCase1 = {4, 3, 1, 1, 0};
    int[] actualResultForCase1 = this.solution(pricesForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1,
        actualResultForCase1);

  }

  public int[] solution(int[] prices) {

    int[] answer = new int[prices.length];

    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        answer[i]++;
        if (prices[i] > prices[j]) {
          break;
        }
      }
    }
    return answer;

  }

}
