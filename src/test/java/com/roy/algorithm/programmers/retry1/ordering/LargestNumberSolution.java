package com.roy.algorithm.programmers.retry1.ordering;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼 것
@Slf4j
public class LargestNumberSolution {

  @Test
  void solutionTest() {

    int[] numbersForCase1 = {6, 10, 2};
    String expectedResultForCase1 = "6210";
    String actualResultForCase1 = this.solution(numbersForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    int[] numbersForCase2 = {3, 30, 34, 5, 9};
    String expectedResultForCase2 = "9534330";
    String actualResultForCase2 = this.solution(numbersForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);
  }

  public String solution(int[] numbers) {

    String[] stringValueOfNumbers = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      stringValueOfNumbers[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(stringValueOfNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

    if (stringValueOfNumbers[0].equals("0")) {
      return "0";
    }

    String answer = "";
    for (String i : stringValueOfNumbers) {
      answer += i;
    }

    return answer;
  }
}
