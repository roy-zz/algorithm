package com.roy.algorithm.programmers.retry1.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class TruckCrossingBridgeSolution {

  @Test
  void solutionTest() {

    int bridgeLengthForCase1 = 2;
    int weightForCase1 = 10;
    int[] truckWeightsForCase1 = {7, 4, 5, 6};
    int expectedResultForCase1 = 8;

    Assertions.assertEquals(expectedResultForCase1,
        this.solution(bridgeLengthForCase1, weightForCase1, truckWeightsForCase1));

    int bridgeLengthForCase2 = 100;
    int weightForCase2 = 100;
    int[] truckWeightsForCase2 = {10};
    int expectedResultForCase2 = 101;

    Assertions.assertEquals(expectedResultForCase2,
        this.solution(bridgeLengthForCase2, weightForCase2, truckWeightsForCase2));

    int bridgeLengthForCase3 = 100;
    int weightForCase3 = 100;
    int[] truckWeightsForCase3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    int expectedResultForCase3 = 110;

    Assertions.assertEquals(expectedResultForCase3,
        this.solution(bridgeLengthForCase3, weightForCase3, truckWeightsForCase3));


  }

  public int solution(int bridgeLength, int weight, int[] truckWeights) {

    // 트럭이 두 대 이상 다리 위에 올라갈 수 있다.
    int answer = 0;

    Queue<Integer> queueOfTrucksOnBridge = new LinkedList<>();

    int truckWeightOfOnBridge = 0;

    for (int truckWeight : truckWeights) {

      while (true) {

        if (queueOfTrucksOnBridge.isEmpty()) {

          queueOfTrucksOnBridge.offer(truckWeight);
          truckWeightOfOnBridge += truckWeight;
          answer++;
          break;

        } else if (queueOfTrucksOnBridge.size() == bridgeLength) {

          truckWeightOfOnBridge -= queueOfTrucksOnBridge.poll();

        } else {

          if (truckWeightOfOnBridge + truckWeight > weight) {

            queueOfTrucksOnBridge.offer(0);
            answer++;

          } else {

            queueOfTrucksOnBridge.offer(truckWeight);
            truckWeightOfOnBridge += truckWeight;
            answer++;
            break;

          }
        }
      }
    }

    return answer + bridgeLength;
  }
}
