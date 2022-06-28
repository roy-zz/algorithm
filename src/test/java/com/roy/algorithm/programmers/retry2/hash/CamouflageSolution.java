package com.roy.algorithm.programmers.retry2.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamouflageSolution {

    @Test
    void problem() {
        String[][] clothes1 = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int expectedAnswer1 = 5;
        int answer1 = solution1(clothes1);
        assertEquals(expectedAnswer1, answer1);

        String[][] clothes2 = {
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        int expectedAnswer2 = 3;
        int answer2 = solution1(clothes2);
        assertEquals(expectedAnswer2, answer2);
    }

    private int solution1(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> mapOfClothes = new HashMap<>();
        for (String[] cloth : clothes) {
            mapOfClothes.put(cloth[1], mapOfClothes.getOrDefault(cloth[1], 0) + 1);
        }

        for (String key : mapOfClothes.keySet()) {
            answer *= mapOfClothes.get(key) + 1;
        }

        return answer - 1;
    }

}
