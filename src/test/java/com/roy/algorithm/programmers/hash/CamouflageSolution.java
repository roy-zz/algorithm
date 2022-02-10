package com.roy.algorithm.programmers.hash;

import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CamouflageSolution {

  @Test
  void solutionTest() {

    String[][] clothesForCase1 = { {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"} };
    int expectedResultForCase1 = 5;
    Assertions.assertEquals(expectedResultForCase1, solution(clothesForCase1));

    String[][] clothesForCase2 = { {"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"} };
    int expectedResultForCase2 = 3;
    Assertions.assertEquals(expectedResultForCase2, solution(clothesForCase2));

  }


  public int solution(String[][] clothes) {

    int answer = 1;

    HashMap<String, Integer> mapOfClothes = new HashMap<>();

    for (int i = 0; i < clothes.length; i++) {
      mapOfClothes.put(clothes[i][1], mapOfClothes.getOrDefault(clothes[i][1], 0) + 1);
    }

    Set<String> keySet = mapOfClothes.keySet();

    for (String key : keySet) {
      answer *= mapOfClothes.get(key) + 1;
    }

    return answer - 1;

  }
}
