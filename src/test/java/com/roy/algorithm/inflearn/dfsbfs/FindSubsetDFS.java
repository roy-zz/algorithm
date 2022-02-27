package com.roy.algorithm.inflearn.dfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 부분집합 구하기(DFS)
//
// 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
// - 출력설명
// 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다. 단 공집합은 출력하지 않습니다.
// - 입력예제 1
// 3
// - 출력예제 1
// 1 2 3
// 1 2
// 1 3
// 1
// 2 3
// 2
// 3
//
// 해설
//                                          1
//             2 (1을 사용하는 경우)                       2 (1을 사용하지 않는 경우)
// 3 (2를 사용하는 경우) 3 (2를 사용하지 않는 경우)     3 (2를 사용하는 경우)          3 (2를 사용하지 않는 경우)
@SuppressWarnings("NewClassNamingConvention")
public class FindSubsetDFS {

    private final List<Integer[]> answer1 = new ArrayList<>();
    private final int number = 3;
    private final Integer[] checkArray = new Integer[number + 1];

    public void solution1(int tempNumber) {
        if (tempNumber == number + 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                if (Objects.nonNull(checkArray[i]) && checkArray[i] == 1) {
                    tempList.add(i);
                }
            }
            if (tempList.size() > 0) {
                answer1.add(tempList.toArray(new Integer[0]));
            }
        } else {
            checkArray[tempNumber] = 1;
            solution1(tempNumber + 1);
            checkArray[tempNumber] = 0;
            solution1(tempNumber + 1);
        }
    }

    @Test
    @DisplayName("부분집합 구하기(DFS)")
    public void main() {
        Integer[][] expectedAnswer1 = {
                {1, 2, 3},
                {1, 2},
                {1, 3},
                {1},
                {2, 3},
                {2},
                {3}
        };
        solution1(1);
        assertArrayEquals(expectedAnswer1, answer1.toArray());
    }

}
