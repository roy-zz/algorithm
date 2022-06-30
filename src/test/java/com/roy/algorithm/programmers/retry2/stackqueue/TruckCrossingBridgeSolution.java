package com.roy.algorithm.programmers.retry2.stackqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridgeSolution {

    @Test
    void problem() {
        int bridgeLengthForCase1 = 2;
        int weightForCase1 = 10;
        int[] truckWeightsForCase1 = {7, 4, 5, 6};
        int expectedResultForCase1 = 8;
        int answer1 = solution(bridgeLengthForCase1, weightForCase1, truckWeightsForCase1);

        Assertions.assertEquals(expectedResultForCase1, answer1);

        int bridgeLengthForCase2 = 100;
        int weightForCase2 = 100;
        int[] truckWeightsForCase2 = {10};
        int expectedResultForCase2 = 101;
        int answer2 = solution(bridgeLengthForCase2, weightForCase2, truckWeightsForCase2);

        Assertions.assertEquals(expectedResultForCase2, answer2);

        int bridgeLengthForCase3 = 100;
        int weightForCase3 = 100;
        int[] truckWeightsForCase3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int expectedResultForCase3 = 110;
        int answer3 = solution(bridgeLengthForCase3, weightForCase3, truckWeightsForCase3);

        Assertions.assertEquals(expectedResultForCase3, answer3);
    }

    private int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> queueOfTrucksOnBridge = new LinkedList<>();
        int weightSumOfOnBridge = 0;
        int spentTimes = 0;

        for (int i = 0; i < truckWeights.length; i++) {
            int truckWeight = truckWeights[i];
            while(true) {
                if (queueOfTrucksOnBridge.isEmpty()) {
                    queueOfTrucksOnBridge.add(truckWeight);
                    weightSumOfOnBridge += truckWeight;
                    spentTimes++;
                    break;
                } else if (queueOfTrucksOnBridge.size() == bridgeLength) {
                    weightSumOfOnBridge -= queueOfTrucksOnBridge.poll();
                } else {
                    if (weightSumOfOnBridge + truckWeight <= weight) {
                        queueOfTrucksOnBridge.add(truckWeight);
                        weightSumOfOnBridge += truckWeight;
                        spentTimes++;
                        break;
                    } else {
                        queueOfTrucksOnBridge.add(0);
                        spentTimes++;
                    }
                }
            }
        }

        return spentTimes + bridgeLength;
    }
}
