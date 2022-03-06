package com.roy.algorithm.inflearn.retry2.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 멘토링
//
// 현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
// 멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
// 선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
// 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
// M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지인지 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
// 두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다.
// 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
// 만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등,
// 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
// - 출력설명
// 첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
// - 입력예제 1
// 4 3
// 3 4 1 2
// 4 3 2 1
// 3 1 4 2
// - 출력예제 1
// 3
// (3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.
// HARD
@SuppressWarnings("NewClassNamingConvention")
public class Mentoring {

    static class Student {
        int bestRank;
        int worstRank;
        public Student() {
            bestRank = Integer.MAX_VALUE;
            worstRank = Integer.MIN_VALUE;
        }
    }

    public int solution1(int[][] scores, int studentCount, int problemCount) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                Student tempStudent = students.get(scores[i][j] - 1);
                tempStudent.bestRank = Math.min(tempStudent.bestRank, j + 1);
                tempStudent.worstRank = Math.max(tempStudent.worstRank, j + 1);
            }
        }
        int answer = 0;
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (i != j && students.get(i).worstRank <= students.get(j).bestRank) {
                    answer++;
                }
            }
        }
        return answer;
    }


    @Test
    @DisplayName("멘토링")
    public void main() {
        int[][] scores = {
                {3, 4, 1, 2},
                {4, 3, 2, 1},
                {3, 1, 4, 2}
        };
        int studentCount = 4;
        int problemCount = 3;
        int expectedAnswer = 3;
        int answer = solution1(scores, studentCount, problemCount);
        assertEquals(expectedAnswer, answer);
    }

}
