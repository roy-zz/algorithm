package com.roy.algorithm.programmers.exhaustivesearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class MockTestProblem {

  @Test
  void solutionTest() {

    int[] answersForCase1 = {1, 2, 3, 4, 5};
    int[] expectedResultForCase1 = {1};
    int[] actualResultForCase1 = this.solution(answersForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);

    int[] answersForCase2 = {1, 3, 2, 4, 2};
    int[] expectedResultForCase2 = {1, 2, 3};
    int[] actualResultForCase2 = this.solution(answersForCase2);

    Assertions.assertArrayEquals(expectedResultForCase2, actualResultForCase2);

  }

  private int[] solution(int[] answers) {

    PersonOfGaveUpMath person1 = new PersonOfGaveUpMath(1, 1, 2, 3, 4, 5);
    PersonOfGaveUpMath person2 = new PersonOfGaveUpMath(2, 2, 1, 2, 3, 2, 4, 2, 5);
    PersonOfGaveUpMath person3 = new PersonOfGaveUpMath(3, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

    while (person1.getPattern().size() < answers.length) {
      person1.getPattern().addAll(person1.getPattern());
    }
    while (person2.getPattern().size() < answers.length) {
      person2.getPattern().addAll(person2.getPattern());
    }
    while (person3.getPattern().size() < answers.length) {
      person3.getPattern().addAll(person3.getPattern());
    }

    for (int i = 0; i < answers.length; i++) {

      if (answers[i] == person1.getPattern().get(i)) {
        person1.countOfRightAnswer++;
      }
      if (answers[i] == person2.getPattern().get(i)) {
        person2.countOfRightAnswer++;
      }
      if (answers[i] == person3.getPattern().get(i)) {
        person3.countOfRightAnswer++;
      }
    }

    List<PersonOfGaveUpMath> listOfResult = new ArrayList<>(
        Arrays.asList(person1, person2, person3));
    Collections.sort(listOfResult);

    int mostPoint = listOfResult.get(0).getCountOfRightAnswer();

    int[] answer = listOfResult.stream().filter(i -> i.getCountOfRightAnswer() >= mostPoint)
        .mapToInt(PersonOfGaveUpMath::getId).toArray();
    return answer;
  }

  private static class PersonOfGaveUpMath implements Comparable<PersonOfGaveUpMath> {

    int id;
    int countOfRightAnswer = 0;
    List<Integer> pattern;

    public PersonOfGaveUpMath(int id, Integer... pattern) {
      this.id = id;
      this.pattern = new ArrayList<>(Arrays.asList(pattern));
    }

    public int getId() {
      return this.id;
    }

    public int getCountOfRightAnswer() {
      return this.countOfRightAnswer;
    }

    public void setCountOfRightAnswer(int count) {
      this.countOfRightAnswer = count;
    }

    public List<Integer> getPattern() {
      return this.pattern;
    }

    @Override
    public int compareTo(PersonOfGaveUpMath p1) {
      if (p1.getCountOfRightAnswer() != this.getCountOfRightAnswer()) {
        return p1.getCountOfRightAnswer() - this.getCountOfRightAnswer();
      } else {
        return this.id - p1.getId();
      }
    }
  }


}
