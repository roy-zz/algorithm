package com.roy.algorithm.inflearn.retry1.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 친구인가 (Disjoint-Set: Union & Find)
//
// 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
// 모든 학생은 1부터 N까지 번호가 부여되어있고, 현수에게는 각각 두명의 학생은 친구관계가 번호로 표현된 숫자쌍이 주어진다.
// 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구,
// 3번 학생과 4번 학생이 친구이다. 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
// 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
// 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
// - 입력설명
// 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,
// 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
// 마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
// - 출력설명
// 첫 번째 줄에 “YES"또는 "NO"를 출력한다.
// - 입력예제 1
// 9 7
// 1 2
// 2 3
// 3 4
// 1 5
// 6 7
// 7 8
// 8 9
// 3 8
// - 출력예제 1
// NO
// - 풀이
// Disjoint-Set: 서로소 집합. 서로 공통되는 부분이 없는 집합
// 친구들 연결관계를 그래프로 이해하고 연결관계가 다른 친구는 서로소 그래프라고 판단한다.
// find 메서드와 union 메서드는 형태를 암기해서 사용하자.
// return unionAndFind[vertex] = find(unionAndFind[vertex])
// 코드를 통해 압축을 이해하고 시간복잡도를 줄인다.
@SuppressWarnings("NewClassNamingConvention")
public class IsFriend {

    private int[] unionAndFind;

    private int find(int vertex) {
        if (vertex == unionAndFind[vertex]) {
            return vertex;
        } else {
            return unionAndFind[vertex] = find(unionAndFind[vertex]);
        }
    }

    private void union(int studentA, int studentB) {
        int studentAGroup = find(studentA);
        int studentBGroup = find(studentB);
        if (studentAGroup != studentBGroup) {
            unionAndFind[studentAGroup] = studentBGroup;
        }
    }

    public String solution1(int[][] students, int targetA, int targetB) {
        for (int[] student : students) {
            union(student[0], student[1]);
        }
        int targetAGroup = find(targetA);
        int targetBGroup = find(targetB);
        return targetAGroup == targetBGroup ? "YES" : "NO";
    }

    @Test
    @DisplayName("친구인가 (Disjoint-Set: Union & Find)")
    public void main() {
        int studentCount = 9;
        int[][] students1 = {
                {1, 2}, {2, 3}, {3, 4}, {1, 5},
                {6, 7}, {7, 8}, {8, 9}
        };
        unionAndFind = new int[studentCount + 1];
        for (int i = 0; i < unionAndFind.length; i++) {
            unionAndFind[i] = i;
        }
        String expectedAnswer1 = "NO";
        String answer1 = solution1(students1, 3, 8);
        assertEquals(expectedAnswer1, answer1);
    }

}
