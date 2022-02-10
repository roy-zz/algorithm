package com.roy.algorithm.programmers.exhaustivesearch;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CarpetSolution {

  @Test
  void solutionTest() {

    int brownForCase1 = 10;
    int yellowForCase1 = 2;
    int[] expectedResultForCase1 = {4, 3};
    int[] actualResultForCase1 = this.solution(brownForCase1, yellowForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);

    int brownForCase2 = 8;
    int yellowForCase2 = 1;
    int[] expectedResultForCase2 = {3, 3};
    int[] actualResultForCase2 = this.solution(brownForCase2, yellowForCase2);

    Assertions.assertArrayEquals(expectedResultForCase2, actualResultForCase2);

    int brownForCase3 = 24;
    int yellowForCase3 = 24;
    int[] expectedResultForCase3 = {8, 6};
    int[] actualResultForCase3 = this.solution(brownForCase3, yellowForCase3);

    Assertions.assertArrayEquals(expectedResultForCase3, actualResultForCase3);

  }

  private int[] solution(int brown, int yellow) {

    int[] answer = new int[2];

    // X와 Y는 brown * yellow 의 약수여야 한다.
    // Brown[X] = Yellow[X] + 2
    // Brown[Y] = Yellow[Y] + 2
    // brown + yellow = Brown[X] * Brown[Y];
    // brown + yellow = (Yellow[X] + 2) * (Yellow[Y] + 2)
    // brown = (Brown[X] * Brown[Y]) - (Yellow[X] * Yellow[Y])
    // yellow = Yellow[X] * Yellow[Y]
    // Brown[X] >= Brown[Y]
    // Brown[Y] >= 3

    // 가능한 X의 값들
    int[] possibleX = this.getDivisors(brown + yellow);

    for (int i = 0; i < possibleX.length; i++) {

      int x = possibleX[i];
      int y = (brown + yellow) / x;

      if (brown == (x * y) - ((x - 2) * (y - 2))) {
        answer[0] = x;
        answer[1] = y;
      }
    }

    return answer;
  }

  private int[] getDivisors(int number) {

    List<Integer> divisors = new ArrayList<>();

    for (int i = 1; i <= number; i++) {
      if ((number % i) == 0) {
        divisors.add(i);
      }
    }

    return divisors.stream().mapToInt(Integer::intValue).toArray();
  }
}
