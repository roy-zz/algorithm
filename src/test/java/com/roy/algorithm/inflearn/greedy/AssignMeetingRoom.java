package com.roy.algorithm.inflearn.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 회의실 배정
//
// 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
// 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
// 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
// - 입력설명
// 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다.
// 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
// 회의 시간은 0시부터 시작된다.
// 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
// - 출력설명
// 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
// - 입력예제 1
// 5
// 1 4
// 2 3
// 3 5
// 4 6
// 5 7
// - 출력예제 1
// 3
// - 예제설명
// (2, 3), (3, 5), (5, 7)이 회의실을 이용할 수 있다.
// - 입력예제 2
// 3
// 3 3
// 1 3
// 2 3
// - 출력예제 2
// 2
// - 풀이
// 회의가 빨리 끝나는 순으로 선택을 해야한다.
@SuppressWarnings("NewClassNamingConvention")
public class AssignMeetingRoom {

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;
        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        @Override
        public int compareTo(Meeting meeting) {
            return this.endTime == meeting.endTime
                    ? this.startTime - meeting.startTime
                    : this.endTime - meeting.endTime;
        }
    }

    public int solution1(Meeting[] meetings) {
        Queue<Meeting> queueOfMeetings = new PriorityQueue<>();
        for (Meeting meeting : meetings) {
            queueOfMeetings.offer(meeting);
        }
        int answer = 0;
        int maxEndTime = Integer.MIN_VALUE;
        while (!queueOfMeetings.isEmpty()) {
            Meeting tmpMeeting = queueOfMeetings.poll();
            if (tmpMeeting.startTime >= maxEndTime) {
                maxEndTime = tmpMeeting.endTime;
                answer++;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("회의실 배정")
    public void main() {
        Meeting[] input1 = {
                new Meeting(1, 4), new Meeting(2, 3), new Meeting(3, 5),
                new Meeting(4, 6), new Meeting(5, 7)
        };
        int answer1 = solution1(input1);
        assertEquals(3, answer1);
        Meeting[] input2 = {
                new Meeting(3, 3), new Meeting(1, 3), new Meeting(2, 3)
        };
        int answer2 = solution1(input2);
        assertEquals(2, answer2);
    }

}
