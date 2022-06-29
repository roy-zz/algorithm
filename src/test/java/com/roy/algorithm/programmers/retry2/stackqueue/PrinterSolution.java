package com.roy.algorithm.programmers.retry2.stackqueue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterSolution {

    @Test
    void problem() {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        int expectedAnswer1 = 1;
        int answer1 = solution1(priorities1, location1);
        assertEquals(expectedAnswer1, answer1);

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int expectedAnswer2 = 5;
        int answer2 = solution1(priorities2, location2);
        assertEquals(expectedAnswer2, answer2);
    }

    private int solution1(int[] priorities, int location) {
        Queue<Printer> queueOfPrinters = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queueOfPrinters.add(new Printer(priorities[i], i));
        }

        int printCount = 0;
        while (!queueOfPrinters.isEmpty()) {
            Printer tempPrinter = queueOfPrinters.poll();
            boolean isProceed = false;
            for (int i = 0; i < queueOfPrinters.size(); i++) {
                if (queueOfPrinters.peek().priority > tempPrinter.priority) {
                    queueOfPrinters.add(tempPrinter);
                    break;
                }
                isProceed = true;
            }
            if (isProceed) {
                printCount++;
                if (tempPrinter.location == location) {
                    break;
                }
            }
        }

        return printCount;
    }

    private static class Printer {
        int location;
        int priority;
        public Printer(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

}
