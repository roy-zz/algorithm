package com.roy.algorithm.programmers.retry2.hash;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BestAlbumSolution {

    @Test
    void problem() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] expectedAnswer = {4, 1, 3, 0};
        int[] answer = solution(genres, plays);
        assertArrayEquals(expectedAnswer, answer);
    }

    // 1. 장르 총 재생 횟수 DESC
    // 2. 장르내 재생 횟수 DESC
    // 3. 고유 번호 ASC
    private int[] solution(String[] genres, int[] plays) {
        List<Music> musics = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        Map<String, Integer> mapOfGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            mapOfGenres.put(genres[i], mapOfGenres.getOrDefault(genres[i], 0) + plays[i]);
            musics.add(new Music(i, genres[i], plays[i]));
        }

        Collections.sort(musics);

        List<Map.Entry<String, Integer>> listOfEntry = new ArrayList<>(mapOfGenres.entrySet());
        listOfEntry.sort((entry, o) -> o.getValue() - entry.getValue());

        for (Map.Entry<String, Integer> entry : listOfEntry) {
            int count = 0;

            for (Music music : musics) {
                if (count > 1) {
                    break;
                } else if (music.genre.equals(entry.getKey())) {
                    answers.add(music.index);
                    count++;
                }
            }
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Music implements Comparable<Music> {
        int index;
        String genre;
        int play;

        public Music(int index, String genre, int play) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }

        // 내가 앞이면 오름차순
        // 내가 뒤면 내림차순
        @Override
        public int compareTo(Music o) {
            return o.play == this.play
                    ? this.index - o.index
                    : o.play - this.play;
        }
    }

}
