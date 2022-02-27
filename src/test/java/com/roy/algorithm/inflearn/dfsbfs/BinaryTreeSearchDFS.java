package com.roy.algorithm.inflearn.dfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 이진트리 순회(깊이우선탐색)
//
// 아래와 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
//          1
//      2       3
//    4   5   6   7
//
// 전위순회 출력: 1 2 4 5 3 6 7
// 중위순회 출력: 4 2 5 1 6 3 7
// 후위순회 출력: 4 5 2 6 7 3 1
//
// 전위순회: 부모 -> 왼쪽 자식 -> 오른쪽 자식 순으로 방문
// 중위순회: 왼쪽 자식 -> 부모 -> 오른쪽 자식 순으로 방문
// 후위순회: 왼쪽 자식 -> 오른쪽 자식 -> 부모 순으로 방문
@SuppressWarnings("NewClassNamingConvention")
public class BinaryTreeSearchDFS {

    private final List<Integer> frontSearch = new ArrayList<>();
    private final List<Integer> midSearch = new ArrayList<>();
    private final List<Integer> rearSearch = new ArrayList<>();

    static class Node {
        int data;
        Node leftSon;
        Node rightSon;
        public Node(int data) {
            this.data = data;
        }
    }

    public void solution1(Node root) {
        if (Objects.nonNull(root)) {
            frontSearch.add(root.data);
            solution1(root.leftSon);
            solution1(root.rightSon);
        }
    }

    public void solution2(Node root) {
        if (Objects.nonNull(root)) {
            solution2(root.leftSon);
            midSearch.add(root.data);
            solution2(root.rightSon);
        }
    }

    public void solution3(Node root) {
        if (Objects.nonNull(root)) {
            solution3(root.leftSon);
            solution3(root.rightSon);
            rearSearch.add(root.data);
        }
    }

    @Test
    @DisplayName("이진트리 순회(깊이우선탐색)")
    public void main() {
        Node root = new Node(1);
        root.leftSon = new Node(2);
        root.rightSon = new Node(3);
        root.leftSon.leftSon = new Node(4);
        root.leftSon.rightSon = new Node(5);
        root.rightSon.leftSon = new Node(6);
        root.rightSon.rightSon = new Node(7);
        solution1(root);
        solution2(root);
        solution3(root);
        Integer[] expectedAnswer1 = {1, 2, 4, 5, 3, 6, 7};
        Integer[] expectedAnswer2 = {4, 2, 5, 1, 6, 3, 7};
        Integer[] expectedAnswer3 = {4, 5, 2, 6, 7, 3, 1};
        assertArrayEquals(expectedAnswer1, frontSearch.toArray());
        assertArrayEquals(expectedAnswer2, midSearch.toArray());
        assertArrayEquals(expectedAnswer3, rearSearch.toArray());
    }

}
