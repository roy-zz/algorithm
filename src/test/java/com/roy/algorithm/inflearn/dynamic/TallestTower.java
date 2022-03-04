package com.roy.algorithm.inflearn.dynamic;

// 가장 높은 탑 쌓기
//
// 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다.
// 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어간다.
// 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.

// (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
// (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
// (조건3) 벽돌들의 높이는 같을 수도 있다.
// (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
// (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// - 입력설명
//
// 입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.
// 둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.
// 각 벽돌은 입력되는 순서대로 1부터 연속 적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.
// - 출력설명
// 첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.
// - 입력예제 1
// 5
// 25 3 4
// 4 4 6
// 9 2 3
// 16 2 5
// 1 5 2
// - 출력예제 1
// 10
// - 해설
// dynamic 배열의 값은 자신이 가장 높은 곳에 있는 경우의 최대 높이이다.
@SuppressWarnings("NewClassNamingConvention")
public class TallestTower {

    static class Tower implements Comparable<Tower> {
        int area;   // 넓이
        int height; // 높이
        int weight; // 무게
        public Tower(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Tower tower) {
            return tower.area - this.area;
        }
    }

    public int solution1(Tower[] towers) {
        Arrays.sort(towers);
        int[] dynamics = new int[towers.length];
        dynamics[0] = towers[0].height;
        int answer = dynamics[0];
        for (int i = 1; i < towers.length; i++) {
            int tempHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (towers[i].weight < towers[j].weight && dynamics[j] > tempHeight) {
                    tempHeight = dynamics[j];
                }
            }
            dynamics[i] = tempHeight + towers[i].height;
            answer = Math.max(answer, dynamics[i]);
        }
        return answer;
    }

    @Test
    @DisplayName("가장 높은 탑 쌓기")
    public void main() {
        Tower[] towers = {
                new Tower(25, 3, 4),
                new Tower(4, 4, 6),
                new Tower(9, 2, 3),
                new Tower(16, 2, 5),
                new Tower(1, 5, 2)
        };
        int expectedAnswer1 = 10;
        int answer1 = solution1(towers);
        assertEquals(expectedAnswer1, answer1);
    }

}
