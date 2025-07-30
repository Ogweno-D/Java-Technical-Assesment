package question_6;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostCommonStrings {
    // Step 1.
    // Normalize the sentence: Convert to Lowercase and remove punctuation
    // Split the normalized sentence to individual words as tokens
    // Use a HashMap to store the frequency of each word.


    // Step 2
    // Get all the entries (word-frequency) pairs from the HashMap
    // Sort the entries in ascending order based on their frequency and alphabetical order
    // Select the top three words from the sorted list
    public static List<String> mostCommonStrings(String sentence) {
        // Null check!
        if (sentence == null || sentence.isEmpty()) {
            return Collections.emptyList();
        }

        //Step 1. Normalization and Tokenizing
        Map<String, Integer> frequencyMap = new HashMap<>();
        // Using regex to split by non-alphanumeric characters
        // \\b => matches word boundary
        // [a-zA-Z0-9]+ matches any non-alpha-numeric character
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9]+\\b");
        Matcher matcher = pattern.matcher(sentence.toLowerCase());

        // Find the match and put it in the hashMap
        while (matcher.find()) {
            String word = matcher.group();
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2.Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> sortedWordsByFrequency = new ArrayList<>(frequencyMap.entrySet());

        // Step 3. Sort the list by frequency in descending order
        sortedWordsByFrequency.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                // Comparing the frequencies in descending order
                int freqComparison = entry2.getValue().compareTo(entry1.getValue());
                if (freqComparison == 0) {
                    // if frequencies are the same, compare alphabetically
                    return entry1.getKey().compareTo(entry2.getKey());
                }
                return freqComparison;
            }
        });

        //Step 4: Extract top three words
        // Since it is ascending, it will return the three least common words
        List<String> topThreeStrings = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWordsByFrequency) {
            if(count < 3) {
                topThreeStrings.add(entry.getKey());
                count++;
            } else{
                break;
            }
        }

        // Step 5 : Sort the extracted top 3 words alphabetically
        Collections.sort(topThreeStrings);

        return topThreeStrings;
    }


    public static void main(String[] args) {
        // Test Cases
        System.out.println("--- Test Case 1: Standard sentence ---");
        String sentence1 = "The quick brown fox jumps over the lazy dog. The dog is lazy.";
        List<String> result1 = mostCommonStrings(sentence1);
        // Frequencies: brown:1, fox:1, is:1, jumps:1, quick:1, over:1, lazy:2, dog:2, the:2
        // Sorted: brown, fox, is, jumps, quick, over (all 1s, alphabetical), then lazy, dog, the (all 2s, alphabetical)
        // Top 3 (least common, then alphabetical): [brown, fox, is] (or similar first 3 with count 1)
        System.out.println("Sentence: \"" + sentence1 + "\"");
        System.out.println("Top 3 most common words (ascending freq, then alpha): " + result1);
        System.out.println();

        System.out.println("--- Test Case 2: Fewer than 3 distinct words ---");
        String sentence2 = "Hello world hello.";
        List<String> result2 = mostCommonStrings(sentence2);
        // Frequencies: hello:2, world:1
        // Sorted: world (1), hello (2)
        // Top 3: [world, hello]
        System.out.println("Sentence: \"" + sentence2 + "\"");
        System.out.println("Top 3 most common words (ascending freq, then alpha): " + result2);
        System.out.println();

        System.out.println("--- Test Case 3: Empty sentence ---");
        String sentence3 = "";
        List<String> result3 = mostCommonStrings(sentence3);
        System.out.println("Sentence: \"" + sentence3 + "\"");
        System.out.println("Top 3 most common words (ascending freq, then alpha): " + result3); // Expected: []
        System.out.println();

        System.out.println("--- Test Case 4: Sentence with only punctuation/spaces ---");
        String sentence4 = "   !@#$%^&*() ";
        List<String> result4 = mostCommonStrings(sentence4);
        System.out.println("Sentence: \"" + sentence4 + "\"");
        System.out.println("Top 3 most common words (ascending freq, then alpha): " + result4); // Expected: []
        System.out.println();

        System.out.println("--- Test Case 5: Sentence with numbers and mixed case ---");
        String sentence5 = "Java is fun. Java 1 2 3. Fun with Java 1.";
        List<String> result5 = mostCommonStrings(sentence5);
        // Frequencies: 2:1, 3:1, is:1, with:1, fun:2, java:3, 1:2
        // Sorted: 2, 3, is, with (all 1s, alphabetical) ... then 1, fun (all 2s, alphabetical) ... then java (3)
        // Top 3: [2, 3, is] (or similar first 3 with count 1)
        System.out.println("Sentence: \"" + sentence5 + "\"");
        System.out.println("Top 3 most common words (ascending freq, then alpha): " + result5);
        System.out.println();

        System.out.println("--- Test Case 6: All words same frequency (more than 3 distinct) ---");
        String sentence6 = "apple banana cherry date elder fig";
        List<String> result6 = mostCommonStrings(sentence6);
        System.out.println("Sentence: \"" + sentence6 + "\"");
        System.out.println("Top 3 most common words (ascending freq, then alpha): " + result6); // Expected: [apple, banana, cherry] (alphabetical)
        System.out.println();
    }

}
