package com.roy.algorithm.programmers.retry2.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberListSolution {

    @Test
    void problem() {
        String[] phoneBook1 = {"119", "97674223", "1195524421"};
        boolean expectedAnswer1 = false;
        boolean answer1 = solution1(phoneBook1);
        assertEquals(expectedAnswer1, answer1);

        String[] phoneBook2 = {"123", "456", "789"};
        boolean expectedAnswer2 = true;
        boolean answer2 = solution1(phoneBook2);
        assertEquals(expectedAnswer2, answer2);

        String[] phoneBook3 = {"12", "123", "1235", "567", "88"};
        boolean expectedAnswer3 = false;
        boolean answer3 = solution1(phoneBook3);
        assertEquals(expectedAnswer3, answer3);
    }

    private boolean solution1(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
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

    private boolean solution2(String[] phoneBook) {
        Map<String, Void> mapOfPhoneNumber = new HashMap<>();

        for (String phone : phoneBook) {
            mapOfPhoneNumber.put(phone, null);
        }

        for (String phone : phoneBook) {
            for (int i = 1; i < phoneBook.length; i++) {
                String prefix = phone.substring(0, i);
                if (mapOfPhoneNumber.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }



}
