package com.roy.algorithm.programmers.ordering;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼것
@Slf4j
public class HIndexSolution {

  @Test
  void solutionTest() {

    int[] citationsForCase1 = {3, 0, 6, 1, 5};
    int expectedResultForCase1 = 3;
    int actualResultForCase1 = this.solution(citationsForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

  }

  public int solution(int[] citations) {

    int answer = 0;

    Arrays.sort(citations);

    // 논문 N편
    // H번 이상 인용된 논문이 H편 이상
    // 내림차순으로 정렬할 경우 아래의 조건은 고려할 필요 없음
    // 나머지 논문이 H번 이하 인용
    // 이럴때 H의 최댓값이 H-Index
    for (int i = 0; i < citations.length; i++) {

      int tmpCitation = citations.length - i;

      if (citations[i] >= tmpCitation) {
        answer = tmpCitation;
        break;
      }
    }
    return answer;
  }
}
