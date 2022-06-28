package com.roy.algorithm.programmers.retry1.exhaustivesearch;

import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class FindDecimalSolution {

  @Test
  void solutionTest() {

    String numbersForCase1 = "17";
    int expectedResultForCase1 = 2;
    int actualResultForCase1 = this.solution(numbersForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    String numbersForCase2 = "011";
    int expectedResultForCase2 = 2;
    int actualResultForCase2 = this.solution(numbersForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);

  }

  private int solution(String numbers) {

    int answer = 0;

    int count = 0;
    String[] map;
    String result;
    boolean[] visit;
    HashSet<Integer> list;

    visit = new boolean[numbers.length()];
    map = new String[numbers.length()];
    map = numbers.split("");

    list = new HashSet<>();

    return answer;

  }

  private void cycle(int start, int end, int length) {

    if (start == end) {

    }


  }

  private boolean isPrimeNumber(Integer number) {

    if (number <= 0) {
      return true;
    }

    for (int i = 2; i < number; i++) {

      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

  private int[] makePermutation(int[] arr, int r, int[] temp, int current, boolean[] visited) {

    if (r == current) {
      return temp;
    } else {
      for (int i = 0; i < arr.length; i++) {
        if (Boolean.FALSE == visited[i]) {
          visited[i] = true;
          temp[i] = arr[i];
          makePermutation(arr, r, temp, current + 1, visited);
          visited[i] = false;
        }
      }
    }

    return null;
  }

}
