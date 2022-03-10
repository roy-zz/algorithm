package com.roy.algorithm.inflearn.retry2.sorting;

import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
// - 입력예제 1
// 5
// 2 7
// 1 3
// 1 2
// 2 5
// 3 6
// - 출력예제 1
// 1 2
// 1 3
// 2 5
// 2 7
// 3 6
@SuppressWarnings("NewClassNamingConvention")
public class SortingCoordinate {

    @EqualsAndHashCode
    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Coordinate coordinate) {
            return this.x == coordinate.x
                    ? this.y - coordinate.y
                    : this.x - coordinate.x;
        }
    }

    public Coordinate[] solution1(Coordinate[] inputs) {
        Arrays.sort(inputs);
        return inputs;
    }

    @Test
    @DisplayName("좌표 정렬")
    public void main() {
        Coordinate[] inputs = {
                new Coordinate(2, 7),
                new Coordinate(1, 3),
                new Coordinate(1, 2),
                new Coordinate(2, 5),
                new Coordinate(3, 6)
        };
        Coordinate[] expectedAnswer = {
                new Coordinate(1, 2),
                new Coordinate(1, 3),
                new Coordinate(2, 5),
                new Coordinate(2, 7),
                new Coordinate(3, 6)
        };
        Coordinate[] answer = solution1(inputs);
        assertArrayEquals(expectedAnswer, answer);
    }

}
