package com.roy.algorithm.inflearn.retry1.dfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 송아지 찾기(BFS: 상태트리탐색)
//
// 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
// 현수의 위치와 송아 지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
// 송아지는 움직이지 않고 제자리에 있다.
// 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
// 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
// - 입력설명
// 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000 까지이다.
// - 출력설명
// 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
// - 입력예제 1
// 5 14
// - 출력예제 1
// 3
// - 입력예제 2
// 8 3
// - 출력예제 2
// 5
@SuppressWarnings("NewClassNamingConvention")
public class FindCalfBFS {

    int[] directionWithLength = {1, -1, 5};
    int[] checkArray = new int[10001];
    Queue<Integer> queueOfPosition = new LinkedList<>();

    public int solution1(int hyPosition, int calfPosition) {
        checkArray[hyPosition] = 1;
        queueOfPosition.offer(hyPosition);
        int jump = 0;
        while (!queueOfPosition.isEmpty()) {
            for (int i = 0; i < queueOfPosition.size(); i++) {
                int tempPosition = queueOfPosition.poll();
                for (int j = 0; j < directionWithLength.length; j++) {
                    int nextPosition = tempPosition + directionWithLength[j];
                    if (nextPosition == calfPosition) {
                        return jump + 1;
                    } else if (nextPosition >= 1
                            && nextPosition <= 10000
                            && checkArray[nextPosition] == 0) {
                        checkArray[nextPosition] = 1;
                        queueOfPosition.offer(nextPosition);
                    }
                }
            }
            jump++;
        }
        return jump;
    }

    @Test
    @DisplayName("송아지 찾기(BFS: 상태트리탐색")
    public void main() {
        int expectedAnswer1 = 2;
        int answer1 = solution1(5, 14);
        assertEquals(expectedAnswer1, answer1);
        int expectedAnswer2 = 1;
        int answer2 = solution1(8, 3);
        assertEquals(expectedAnswer2, answer2);
    }

}
