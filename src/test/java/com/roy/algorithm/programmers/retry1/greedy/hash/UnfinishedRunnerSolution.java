package com.roy.algorithm.programmers.retry1.greedy.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UnfinishedRunnerSolution {

  @Test
  void solutionTest() {

    String[] participantForCase1 = {"leo", "kiki", "eden"};
    String[] completionForCase1 = {"eden", "kiki"};
    String expectedResultForCase1 = "leo";
    Assertions
        .assertEquals(expectedResultForCase1, solution(participantForCase1, completionForCase1));

    String[] participantForCase2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
    String[] completionForCase2 = {"josipa", "filipa", "marina", "nikola"};
    String expectedResultForCase2 = "vinko";
    Assertions
        .assertEquals(expectedResultForCase2, solution(participantForCase2, completionForCase2));

    String[] participantForCase3 = {"mislav", "stanko", "mislav", "ana"};
    String[] completionForCase3 = {"stanko", "ana", "mislav"};
    String expectedResultForCase3 = "mislav";
    Assertions
        .assertEquals(expectedResultForCase3, solution(participantForCase3, completionForCase3));

  }

  public String solution(String[] participant, String[] completion) {

    String answer = "";

    Arrays.sort(participant);
    Arrays.sort(completion);

    for (int i = 0; i < participant.length; i++) {
      if (i == completion.length) {
        answer = participant[i];
        break;
      } else if (!participant[i].equals(completion[i])) {
        answer = participant[i];
        break;
      }
    }
    return answer;

  }

}
