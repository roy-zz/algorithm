package com.roy.algorithm.inflearn.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 보이는 학생
//
// 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
// 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
// (어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고, 작거나 같으면 보이지 않 습니다.)
// - 입력설명
// 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순 서대로 주어진다.
// - 출력설명
// 선생님이 볼 수 있는 최대학생수를 출력한다.
// - 입력예제 1
// 8
// 130 135 148 140 145 150 150 153
// - 출력예제 1
// 5
@SuppressWarnings("NewClassNamingConvention")
public class VisibleStudent {

    public int solution1(int... inputs) {
        int visibleCount = 1;
        int maxHeight = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            if (maxHeight < inputs[i]) {
                visibleCount++;
                maxHeight = inputs[i];
            }
        }
        return visibleCount;
    }

    @Test
    @DisplayName("보이는 학생")
    public void main() {
        int expectedAnswer = 5;
        int answer1 = solution1(130, 135, 148, 140, 145, 150, 150, 153);
        assertEquals(answer1, expectedAnswer);
    }

}
