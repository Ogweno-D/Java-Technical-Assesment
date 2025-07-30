package question_4;

import java.util.*;

public class FirstArrayElement {

    // Using HashMaps
    // Iterate through the array and record a value(number of times) the key(element)
    // has occurred
    // Simply, count the frequency of the element
    // Key: The number itself
    // Value: The count of it's appearances

    // I was deeply thinking of generics or using a C++ void pointer here.
    // For reducing the Lines Of Code
    public  static List<String> findUniqueOccurringOnce(String[] strings){
        Map<String,Integer> frequencyMap = new HashMap<>();
        for(String s : strings){
            // Into the map put the String(s) and the count for (s),
            // if string(s) is not in the map then default zero(null as per the question) is added;
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        for (String str : strings) {
            if (str != null && frequencyMap.get(str) == 1) {
                return Collections.singletonList(str); // Return the first one found
            }
        }

        return null; // No unique string found
    }
    public static void main(String[] args) {
        // Test Case 1: Standard case with duplicates and unique strings
        String[] strings1 = {"apple", "banana", "orange", "apple", "grape", "banana", "kiwi"};
        System.out.println("Input: " + java.util.Arrays.toString(strings1));
        List<String> unique1 = findUniqueOccurringOnce(strings1);
        System.out.println("Strings occurring exactly once: " + unique1); // Expected: [orange, grape, kiwi] (order may vary)
        System.out.println("--------------------");

        // Test Case 2: All strings are unique
        String[] strings2 = {"red", "green", "blue", "yellow"};
        System.out.println("Input: " + java.util.Arrays.toString(strings2));
        List<String> unique2 = findUniqueOccurringOnce(strings2);
        System.out.println("Strings occurring exactly once: " + unique2); // Expected: [red, green, blue, yellow] (order may vary)
        System.out.println("--------------------");

        // Test Case 3: No strings occur exactly once
        String[] strings3 = {"cat", "cat", "dog", "dog", "bird", "bird"};
        System.out.println("Input: " + java.util.Arrays.toString(strings3));
        List<String> unique3 = findUniqueOccurringOnce(strings3);
        System.out.println("Strings occurring exactly once: " + unique3); // Expected: []
        System.out.println("--------------------");

        // Test Case 4: Empty array
        String[] strings4 = {};
        System.out.println("Input: " + java.util.Arrays.toString(strings4));
        List<String> unique4 = findUniqueOccurringOnce(strings4);
        System.out.println("Strings occurring exactly once: " + unique4); // Expected: []
        System.out.println("--------------------");

        // Test Case 5: Array with one element
        String[] strings5 = {"single"};
        System.out.println("Input: " + java.util.Arrays.toString(strings5));
        List<String> unique5 = findUniqueOccurringOnce(strings5);
        System.out.println("Strings occurring exactly once: " + unique5); // Expected: [single]
        System.out.println("--------------------");

        // Test Case 6: Array with nulls and empty strings
        String[] strings6 = {"hello", "", null, "world", "hello", "", "test", null};
        System.out.println("Input: " + java.util.Arrays.toString(strings6));
        List<String> unique6 = findUniqueOccurringOnce(strings6);
        // Expected: [world, test]
        // Note: "" (empty string) appears twice, null is skipped.
        System.out.println("Strings occurring exactly once: " + unique6);
        System.out.println("--------------------");

        // Test Case 7: Case sensitivity
        String[] strings7 = {"Apple", "apple", "APPLE"};
        System.out.println("Input: " + java.util.Arrays.toString(strings7));
        List<String> unique7 = findUniqueOccurringOnce(strings7);
        // Expected: [Apple, apple, APPLE] if case-sensitive, or [] if case-insensitive (depending on requirements)
        System.out.println("Strings occurring exactly once (case-sensitive): " + unique7);
        System.out.println("--------------------");

        // Test Case 8: Numbers as strings
        String[] strings8 = {"123", "abc", "123", "456", "abc"};
        System.out.println("Input: " + java.util.Arrays.toString(strings8));
        List<String> unique8 = findUniqueOccurringOnce(strings8);
        System.out.println("Strings occurring exactly once: " + unique8); // Expected: [456]
        System.out.println("--------------------");
    }
}
