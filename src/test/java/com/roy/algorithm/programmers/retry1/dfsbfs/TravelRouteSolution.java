package com.roy.algorithm.programmers.retry1.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 풀이 실패, 다음에 다시 푸는 것으로...
@Slf4j
public class TravelRouteSolution {

  @Test
  void solutionTest() {

    String[][] ticketsForCase1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    String[] expectedResultForCase1 = {"ICN", "JFK", "HND", "IAD"};
    String[] actualResultForCase1 = this.solution(ticketsForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);

    String[][] ticketsForCase2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
        {"ATL", "SFO"}};
    String[] expectedResultForCase2 = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
    String[] actualResultForCase2 = this.solution(ticketsForCase2);

    Assertions.assertArrayEquals(expectedResultForCase2, actualResultForCase2);

  }

  private static List<String> answer = new ArrayList<>();
  private String route = "";
  private boolean[] isVisited;

  private String[] solution(String[][] tickets) {

    for (int i = 0; i < tickets.length; i++) {

      isVisited = new boolean[tickets.length];
      String departure = tickets[i][0];
      String destination = tickets[i][1];

      if (departure.equals("ICN")) {
        route = departure + ",";
        isVisited[i] = Boolean.TRUE;
        dfs(tickets, destination, 1);
      }
    }

    Collections.sort(answer);
    return answer.get(0).split(",");
  }

  private void dfs(String[][] tickets, String destination, int visitedCount) {

    route += destination + ",";

    if (visitedCount == tickets.length) {
      answer.add(route);
      return;
    }

    for (int i = 0; i < tickets.length; i++) {
      String nextDeparture = tickets[i][0];
      String nextDestination = tickets[i][1];
      if (nextDeparture.equals(destination) && !isVisited[i]) {
        isVisited[i] = Boolean.TRUE;
        dfs(tickets, nextDestination, visitedCount + 1);
        isVisited[i] = Boolean.FALSE;
        route = route.substring(0, route.length() - 4);
      }
    }

  }

}
