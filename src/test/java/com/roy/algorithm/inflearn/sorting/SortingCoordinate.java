package com.roy.algorithm.inflearn.sorting;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 좌표 정렬
//
// N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
// 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
// - 입력설명
// 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
// 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
// - 출력설명
// N개의 좌표를 정렬하여 출력하세요.
// - 입력예제 1 5
// 27
// 13
// 12
// 25
// 36
// - 출력예제 1
// 12
// 13
// 25
// 27
// 36
@SuppressWarnings("NewClassNamingConvention")
public class SortingCoordinate {

    @AllArgsConstructor
    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        // compareTo는 사용할 때마다 헷갈리므로 암기하도록 한다.
        // 결과값은 무조건 음수가 나오게 맞춘다.
        // 결과 정렬은 this, target 순으로 정렬된다고 가정한다.
        // 오름차순이라면 this(임의의 수 10), target(임의의 수 20)으로 정렬될 것이다.
        // 따라서 음수가 나오게 하려면 this - target이 되어야한다.
        // 내림차순이라면 this(임의의 수 20), target(임의의 수 10)으로 정렬될 것이다.
        // 따라서 음수가 나오게 하려면 target - this가 되어야한다.
        @Override
        public int compareTo(Coordinate target) {
            if (this.x == target.x) {
                return y - target.y;
            } else {
                return x - target.x;
            }
        }
    }

    public int[][] solution1(int[][] coordinates) {
        List<Coordinate> listOfCoordinates = new ArrayList<>();
        for (int[] c : coordinates) {
            listOfCoordinates.add(new Coordinate(c[0], c[1]));
        }
        Collections.sort(listOfCoordinates);
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] = listOfCoordinates.get(i).x;
            coordinates[i][1] = listOfCoordinates.get(i).y;
        }
        return coordinates;
    }

    @Test
    @DisplayName("좌표 정렬")
    public void main() {
        int[][] coordinates = {
                {2, 7}, {1, 3}, {1, 2}, {2, 5}, {3, 6}
        };
        int[][] expectedAnswer = {
                {1, 2}, {1, 3}, {2, 5}, {2, 7}, {3, 6}
        };
        int[][] answer1 = solution1(coordinates);
        assertArrayEquals(expectedAnswer, answer1);
    }

}
