package com.roy.algorithm.programmers.retry2.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnfinishedRunnerSolution {

    @Test
    void problem() {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        String expectedAnswer1 = "leo";
        String answer1 = solution(participant1, completion1);
        assertEquals(expectedAnswer1, answer1);

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String expectedAnswer2 = "vinko";
        String answer2 = solution(participant2, completion2);
        assertEquals(expectedAnswer2, answer2);

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        String expectedAnswer3 = "mislav";
        String answer3 = solution(participant3, completion3);
        assertEquals(expectedAnswer3, answer3);
    }

    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> mapOfParticipant = new HashMap<>();
        for (String participant : participants) {
            mapOfParticipant.put(participant, mapOfParticipant.getOrDefault(participant, 0) + 1);
        }

        for (String completion : completions) {
            mapOfParticipant.put(completion, mapOfParticipant.get(completion) - 1);
        }

        for (String key : mapOfParticipant.keySet()) {
            if (mapOfParticipant.get(key) != 0) {
                return key;
            }
        }
        return null;
    }
}
