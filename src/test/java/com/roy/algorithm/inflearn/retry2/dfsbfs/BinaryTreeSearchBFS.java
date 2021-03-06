package com.roy.algorithm.inflearn.retry2.dfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 이진트리 순회(넓이우선탐색: 레벨탐색, BFS)
//
// 아래와 같은 이진트리를 레벨탐색 연습해보세요.
//          1
//      2       3
//    4   5   6   7
//
// 레벨 탐색 순회 출력: 1 2 3 4 5 6 7
@SuppressWarnings("NewClassNamingConvention")
public class BinaryTreeSearchBFS {

    static class Node {
        Node leftSon;
        Node rightSon;
        int data;
        public Node (int data) {
            this.data = data;
        }
    }

    private final List<Integer> answer = new ArrayList<>();

    public void solution(Node root) {
        Queue<Node> queueOfNode = new LinkedList<>();
        queueOfNode.offer(root);
        while (!queueOfNode.isEmpty()) {
            Node tempNode = queueOfNode.poll();
            answer.add(tempNode.data);
            if (Objects.nonNull(tempNode.leftSon)) {
                queueOfNode.offer(tempNode.leftSon);
            }
            if (Objects.nonNull(tempNode.rightSon)) {
                queueOfNode.offer(tempNode.rightSon);
            }
        }
    }

    @Test
    @DisplayName("이진트리 순회(넓이우선탐색: 레벨탐색)")
    public void main() {
        Node root = new Node(1);
        root.leftSon = new Node(2);
        root.rightSon = new Node(3);
        root.leftSon.leftSon = new Node(4);
        root.leftSon.rightSon = new Node(5);
        root.rightSon.leftSon = new Node(6);
        root.rightSon.rightSon = new Node(7);
        Integer[] expectedAnswer1 = {1, 2, 3, 4, 5, 6, 7};
        solution(root);
        assertArrayEquals(expectedAnswer1, answer.toArray());
    }

}
