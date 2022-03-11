package com.roy.algorithm.inflearn.retry2.dfsbfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Tree 말단 노드까지의 가장 짧은 경로
//
// 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
// 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
//          1
//      2       3
//    4   5
// 가장 짧은 길이는 3번 노드까지의 길이인 1이다.
@SuppressWarnings("NewClassNamingConvention")
public class ShortestPathToTerminalNode {

    static class Node {
        Node leftSon;
        Node rightSon;
        int data;
        public Node (int data) {
            this.data = data;
        }
    }

    // dfs를 통한 풀이
    public int solution1(int level, Node root) {
        if (Objects.isNull(root.leftSon) && Objects.isNull(root.rightSon)) {
            return level;
        } else {
            return Math.min(solution1(level + 1, root.leftSon), solution1(level + 1, root.rightSon));
        }
    }

    // bfs를 통한 풀이
    public int solution2(Node root) {
        Queue<Node> queueOfNode = new LinkedList<>();
        queueOfNode.offer(root);
        int level = 0;
        while (!queueOfNode.isEmpty()) {
            for (int i = 0; i < queueOfNode.size(); i++) {
                Node tempNode = queueOfNode.poll();
                if (Objects.isNull(tempNode.leftSon)
                        && Objects.isNull(tempNode.rightSon)) {
                    return level;
                }
                if (Objects.nonNull(tempNode.leftSon)) {
                    solution2(tempNode.leftSon);
                }
                if (Objects.nonNull(tempNode.rightSon)) {
                    solution2(tempNode.rightSon);
                }
            }
            level++;
        }
        return level;
    }

    @Test
    @DisplayName("Tree 말단 노드까지의 가장 짧은 경로")
    public void main() {
        Node root = new Node(1);
        root.leftSon = new Node(2);
        root.rightSon = new Node(3);
        root.leftSon.leftSon = new Node(4);
        root.leftSon.rightSon = new Node(5);

        int expectedAnswer = 1;
        int answer1 = solution1(0, root);
        assertEquals(expectedAnswer, answer1);

        int answer2 = solution2(root);
        assertEquals(expectedAnswer, answer2);
    }

}
