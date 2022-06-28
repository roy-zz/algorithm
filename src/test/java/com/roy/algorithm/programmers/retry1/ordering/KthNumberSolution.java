package com.roy.algorithm.programmers.retry1.ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class KthNumberSolution {

  @Test
  void solutionTest() {

    int[] arrayForCase1 = {1, 5, 2, 6, 3, 7, 4};
    int[][] commandsForCase1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] expectedResultForCase1 = {5, 6, 3};
    int[] actualResultForCase1 = this.solution(arrayForCase1, commandsForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);
  }

  public int[] solution(int[] array, int[][] commands) {

    List<Integer> listOfAnswer = new ArrayList<>();

    for (int i = 0; i < commands.length; i++) {

      int[] tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
      Arrays.sort(tempArray);
      listOfAnswer.add(tempArray[commands[i][2] - 1]);
    }

    return listOfAnswer.stream().mapToInt(Integer::intValue).toArray();
  }

}
