package com.roy.algorithm.inflearn.retry2.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 동전교환(냅색 알고리즘)
//
// 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환 해주려면 어떻게 주면 되는가?
// 각 단위의 동전은 무한정 쓸 수 있다.
// - 입력설명
// 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
// 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
// 각 동전의 종류는 100원을 넘지 않는다.
// - 출력설명
// 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
// - 입력예제 1
// 3
// 1 2 5
// 15
// - 출력예제 1
// 3
// - 해설
// dynamics 배열을 금액의 크기 사이즈로 만든다.
// 값은 i금액을 만드는데 드는 최소 동전의 갯수로 한다.
// 총 동전의 갯수만큼의 반복문을 돌린다.
// 최초 1원이 채워놓은 배열을 다음 2원이 돌면서 더 적은 수량으로 만들 수 있다면
// dynamics 배열의 값을 업데이트 한다.
@SuppressWarnings("NewClassNamingConvention")
public class ExchangeCoin {

    @Test
    @DisplayName("동전교환")
    public void main() {
        int[] coins1 = {1, 2, 5};
        int targetCost1 = 15;
        // int answer1 = solution1(coins1, targetCost1);
        // assertEquals(3, answer1);
    }

}
