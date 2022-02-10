package com.roy.algorithm.programmers.dfsbfs;

import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 다시 풀어볼 것
@Slf4j
public class WordTransformationSolution {

  @Test
  void solutionTest() {

    String beginForCase1 = "hit";
    String targetForCase1 = "cog";
    String[] wordsForCase1 = {"hot", "dot", "dog", "lot", "log", "cog"};
    int expectedResultForCase1 = 4;
    int actualResultForCase1 = this.solution(beginForCase1, targetForCase1, wordsForCase1);

    Assertions.assertEquals(expectedResultForCase1, actualResultForCase1);

    String beginForCase2 = "hit";
    String targetForCase2 = "cog";
    String[] wordsForCase2 = {"hot", "dot", "dog", "lot", "log"};
    int expectedResultForCase2 = 0;
    int actualResultForCase2 = this.solution(beginForCase2, targetForCase2, wordsForCase2);

    Assertions.assertEquals(expectedResultForCase2, actualResultForCase2);

  }


  private int solution(String begin, String target, String[] words) {

    int answer = 0;

    // 가장 짧은 변환 과정을 찾는다. (Breadth first search 알고리즘 사용)
    // 목록에 타겟이 없으면 0을 리턴
    // 각 단어를 그래프로 생각
    // 각 단어가 두개 이상 있는 것들을 간선으로 연결 -> 그래프 구현
    LinkedList<Node> queueValueOfNode = new LinkedList<>();
    boolean[] isVisited = new boolean[words.length];

    queueValueOfNode.add(new Node(begin, 0));

    while (!queueValueOfNode.isEmpty()) {
      // poll: no exception & return null
      Node current = queueValueOfNode.poll();

      if (current.word.equals(target)) {
        answer = current.edge;
        break;
      }

      for (int i = 0; i < words.length; i++) {
        if (isVisited[i] == Boolean.FALSE && isPossibleNext(current.word, words[i])) {
          isVisited[i] = Boolean.TRUE;
          queueValueOfNode.add(new Node(words[i], current.edge + 1));
        }
      }
    }

    return answer;
  }

  static boolean isPossibleNext(String current, String next) {
    int count = 0;
    for (int i = 0; i < current.length(); i++) {
      if (current.charAt(i) != next.charAt(i)) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return true;

  }

  static class Node {

    String word;
    int edge;

    public Node(String word, int edge) {
      this.word = word;
      this.edge = edge;
    }

  }

}
