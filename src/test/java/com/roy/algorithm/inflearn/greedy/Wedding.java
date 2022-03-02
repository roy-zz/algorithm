package com.roy.algorithm.inflearn.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 결혼식
//
// 현수는 다음 달에 결혼을 합니다.
// 현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
// 피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
// 각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
// 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
// 만약 한 친구가 오는 시간 13, 가는 시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.
// - 입력설명
// 첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
// 두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
// 시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.
// - 출력설명
// 첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.
// - 입력예제 1
// 5
// 14 18
// 12 15
// 15 20
// 20 30
// 5 14
// - 출력예제 1
// 2
// 해설
// 동일한 시간에 가는 사람과 오는 사람이 있는 경우 항상 가는 사람이 먼저 간다는 것을 주의할 것!
@SuppressWarnings("NewClassNamingConvention")
public class Wedding {

    static class Time implements Comparable<Time> {
        int time;
        char status; // a = 가는 시간, b = 오는 시간
        public Time(int time, char status) {
            this.time = time;
            this.status = status;
        }
        // 시작시간 순으로 오름차순
        // 시작시간이 동일한 경우 status값 기준으로 오름차순
        @Override
        public int compareTo(Time t) {
            return this.time == t.time
                    ? this.status - t.status
                    : this.time - t.time;
        }
    }

    public int solution1(Time[] times) {
        Arrays.sort(times);
        int answer = Integer.MIN_VALUE;
        int count = 0;
        for (Time time : times) {
            if (time.status == 'b') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    @Test
    @DisplayName("결혼식")
    public void main() {
        Time[] inputs = {
                new Time(14, 'b'), new Time(18, 'a'),
                new Time(12, 'b'), new Time(15, 'a'),
                new Time(15, 'b'), new Time(20, 'a'),
                new Time(20, 'b'), new Time(30, 'a'),
                new Time(5, 'b'), new Time(14, 'a')
        };
        int answer1 = solution1(inputs);
        assertEquals(2, answer1);
    }

}
