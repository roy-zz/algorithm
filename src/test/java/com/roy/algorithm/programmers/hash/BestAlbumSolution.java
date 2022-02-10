package com.roy.algorithm.programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class BestAlbumSolution {

  @Test
  void solutionTest() {

    String[] genresForCase1 = {"classic", "pop", "classic", "classic", "pop"};
    int[] playsForCase1 = {500, 600, 150, 800, 2500};
    int[] expectedResultForCase1 = {4, 1, 3, 0};
    int[] actualResultForCase1 = solution(genresForCase1, playsForCase1);

    Assertions.assertArrayEquals(expectedResultForCase1, actualResultForCase1);

  }

  public int[] solution(String[] genres, int[] plays) {

    // 정렬 우선 순위
    // 1. 장르 총 재생 횟수 DESC
    // 2. 장르내 재생 횟수 DESC
    // 3. 고유 번호 ASC
    List<Music> musics = new ArrayList<>();
    HashMap<String, Integer> mapOfTotalPlaysNotOrdered = new HashMap<>();
    List<Integer> answerOfList = new ArrayList<>();

    for (int i = 0; i < genres.length; i++) {
      musics.add(new Music(i, genres[i], plays[i]));
      if (Objects.isNull(mapOfTotalPlaysNotOrdered.get(genres[i]))) {
        mapOfTotalPlaysNotOrdered.put(genres[i], plays[i]);
      } else {
        mapOfTotalPlaysNotOrdered
            .put(genres[i], mapOfTotalPlaysNotOrdered.get(genres[i]) + plays[i]);
      }
    }

    Collections.sort(musics);

    List<Entry<String, Integer>> listOfTotalPlays = new ArrayList<>(
        mapOfTotalPlaysNotOrdered.entrySet());

    Collections.sort(listOfTotalPlays, new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> stringIntegerEntry, Entry<String, Integer> t1) {
        return t1.getValue() - stringIntegerEntry.getValue();
      }
    });

    for (Entry<String, Integer> entry : listOfTotalPlays) {

      short count = 0;

      for (Music music : musics) {
        if (count > 1) {
          break;
        } else if (music.getGenre().equals(entry.getKey())) {
          answerOfList.add(music.getId());
          count += 1;
        }
      }
    }

    return answerOfList.stream().mapToInt(Integer::intValue).toArray();

  }

  private static class Music implements Comparable<Music> {

    int id;
    String genre;
    int play;

    @Override
    public int compareTo(Music i) {

      if (i.play == this.play) {
        return this.id - i.id;
      } else {
        return i.play - this.play;
      }
    }

    public Music(int id, String genre, int play) {
      this.id = id;
      this.genre = genre;
      this.play = play;
    }

    public int getId() {
      return this.id;
    }

    public String getGenre() {
      return this.genre;
    }

    public int getPlay() {
      return this.play;
    }
  }

//  @Test
//  void orderTest() {
//
//    // @formatter:off
//    List<OrderTest> orderTests = new ArrayList<>();
//    orderTests.addAll(List.of(
//            new OrderTest(0, 5), new OrderTest(1, 0),
//            new OrderTest(2, 9), new OrderTest(3, 1),
//            new OrderTest(4, 8), new OrderTest(5, 2),
//            new OrderTest(6, 7), new OrderTest(7, 3),
//            new OrderTest(8, 6), new OrderTest(9, 4),
//            new OrderTest(10, 5), new OrderTest(11, 0)
//        ));
//    // @formatter:on
//
//    Collections.sort(orderTests, new Comparator<OrderTest>() {
//          @Override
//          public int compare(OrderTest t1, OrderTest t2) {
//            if (t1.getPlay() == t2.getPlay()) {
//              return t1.getId() - t2.getId();
//            } else {
//              return t2.getPlay() - t1.getPlay();
//            }
//          }
//        }
//    );
//
//    for (OrderTest test : orderTests) {
//      log.info("id: {}, play: {}", test.getId(), test.getPlay());
//    }
//
//  }
//
//  @Getter
//  @AllArgsConstructor
//  private class OrderTest {
//
//    int id;
//    int play;
//
//  }
}
