package com.roy.algorithm.inflearn.retry1.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 장난꾸러기
//
// 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
// 철수네 반에는 N명의 학생들이 있습니다.
// 선생님은 반 학생들에게 반 번호를 정해주기 위해 운동장에 반 학생들을 키가 가장 작은 학 생부터 일렬로 키순으로 세웠습니다.
// 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까 지 부여합니다. 철수는 짝꿍보다 키가 큽니다. 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
// 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
// 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를 차례로 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 자연수 N(5<=N<=100)이 주어진다.
// 두 번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다. 키(높이) 값 H는 (120<=H<=180)의 자연수 입니다.
// - 출력설명
// 첫 번째 줄에 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력합니다.
// - 입력예제 1
// 9
// 120 125 152 130 135 135 143 127 160
// - 출력예제 1
// 38
// 출력해설 : 키 정보 152가 철수이고, 127이 철수 짝꿍입니다.
// - 입력예제 2
// 6
// 120 130 150 150 130 150
// - 출력예제 2
// 35
@SuppressWarnings("NewClassNamingConvention")
public class MischievousBoy {

    // 삽입 정렬을 통한 풀이
    public Integer[] solution1(int[] students) {
        List<Integer> answer = new ArrayList<>();
        int[] originStudents = students.clone();
        for (int i = 0; i < students.length; i++) {
            int index = i;
            for (int j = i + 1; j < students.length; j++) {
                if (students[index] > students[j]) {
                    index = j;
                }
            }
            int temp = students[index];
            students[index] = students[i];
            students[i] = temp;
        }
        for (int i = 0; i < originStudents.length; i++) {
            if (originStudents[i] != students[i]) {
                answer.add(i + 1);
            }
        }
        return answer.toArray(new Integer[0]);
    }

    // 버블 정렬을 통한 풀이
    public Integer[] solution2(int[] students) {
        List<Integer> answer = new ArrayList<>();
        int[] originStudents = students.clone();
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j] > students[j + 1]) {
                    int temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < students.length; i++) {
            if (originStudents[i] != students[i]) {
                answer.add(i + 1);
            }
        }
        return answer.toArray(new Integer[0]);
    }

    // 삽입 정렬을 통한 풀이
    public Integer[] solution3(int[] students) {
        List<Integer> answer = new ArrayList<>();
        int[] originStudents = students.clone();
        for (int i = 1; i < students.length; i++) {
            int temp = students[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (students[j] > temp) {
                    students[j + 1] = students[j];
                } else {
                    break;
                }
            }
            students[j + 1] = temp;
        }
        for (int i = 0; i < students.length; i++) {
            if (originStudents[i] != students[i]) {
                answer.add(i + 1);
            }
        }
        return answer.toArray(new Integer[0]);
    }

    // Arrays.sort 를 통한 풀이
    public Integer[] solution4(int[] students) {
        List<Integer> answer = new ArrayList<>();
        int[] originStudents = students.clone();
        Arrays.sort(students);
        for (int i = 0; i < originStudents.length; i++) {
            if (students[i] != originStudents[i]) {
                answer.add(i + 1);
            }
        }
        return answer.toArray(new Integer[0]);
    }

    @Test
    @DisplayName("장난꾸러기")
    public void main() {
        int[] students1_1 = {120, 125, 152, 130, 135, 135, 143, 127, 160};
        int[] students1_2 = students1_1.clone();
        int[] students1_3 = students1_1.clone();
        int[] students1_4 = students1_1.clone();
        Integer[] expectedAnswer1 = {3, 8};
        Integer[] answer1_1 = solution1(students1_1);
        Integer[] answer1_2 = solution2(students1_2);
        Integer[] answer1_3 = solution3(students1_3);
        Integer[] answer1_4 = solution4(students1_4);
        assertArrayEquals(expectedAnswer1, answer1_1);
        assertArrayEquals(expectedAnswer1, answer1_2);
        assertArrayEquals(expectedAnswer1, answer1_3);
        assertArrayEquals(expectedAnswer1, answer1_4);

        int[] students2_1 = {120, 130, 150, 150, 130, 150};
        int[] students2_2 = students2_1.clone();
        int[] students2_3 = students2_1.clone();
        int[] students2_4 = students2_1.clone();
        Integer[] expectedAnswer2 = {3, 5};
        Integer[] answer2_1 = solution1(students2_1);
        Integer[] answer2_2 = solution2(students2_2);
        Integer[] answer2_3 = solution3(students2_3);
        Integer[] answer2_4 = solution4(students2_4);
        assertArrayEquals(expectedAnswer2, answer2_1);
        assertArrayEquals(expectedAnswer2, answer2_2);
        assertArrayEquals(expectedAnswer2, answer2_3);
        assertArrayEquals(expectedAnswer2, answer2_4);
    }

}
