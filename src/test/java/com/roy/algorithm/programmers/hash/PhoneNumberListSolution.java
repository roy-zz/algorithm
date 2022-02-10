package com.roy.algorithm.programmers.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneNumberListSolution {

  @Test
  void solutionTest() {

    String[] booksForCase1 = {"119", "97674223", "1195524421"};
    Assertions.assertFalse(solution(booksForCase1));

    String[] booksForCase2 = {"123", "456", "789"};
    Assertions.assertTrue(solution(booksForCase2));

    String[] booksForCase3 = {"12", "123", "1235", "567", "88"};
    Assertions.assertFalse(solution(booksForCase3));

  }

  public boolean solution(String[] phoneBook) {

    for (int i=0; i<phoneBook.length-1; i++) {
      for (int j=i+1; j<phoneBook.length; j++) {
        if (phoneBook[i].startsWith(phoneBook[j])) {
          return false;
        }
        if (phoneBook[j].startsWith(phoneBook[i])) {
          return false;
        }
      }
    }
    return true;
  }

}
