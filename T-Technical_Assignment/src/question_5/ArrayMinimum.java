package question_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayMinimum {
    public static int findDistanceBetweenClosestMinimums(int[] arr) {
        // NULL ASSUMPTION CHECK
        if (arr == null || arr.length < 2) {
            System.out.println("Array must contain at least 2 elements");
            return 0;
        }
        // Find the global minimum
        // (This is initially set to the first element)
        int minValue = arr[0];

        // Looping through the array to set the minimum
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
//            System.out.println(minValue);
        }

        // For the second array pass,
        // To find the minimum distance between occurrences of minVal
        int minDistance = Integer.MAX_VALUE;
        int lastMinIndex = -1; // or -1
        int occurrences = 0;


        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == minValue) {
                // If the element equals the minValue
                // occurrences are incremented by one
                occurrences++;
                if(lastMinIndex != -1){
                    int currentDistance = i - lastMinIndex;
                    minDistance = Math.min(minDistance, currentDistance);
                }
                // Update the current index to current
                lastMinIndex = i;
            }
//            System.out.println(occurrences);
        }
        // For less than two occurrence of minimum value
        if(occurrences < 2){
            System.out.println("Error: Minimum value occurs less than twice");
            return -1;
        }
        return minDistance;
        // This one has a potential issue -> Check it out in the first array test case

    }

    public static int findDistanceBetweenClosestMinimumByHashMaps(int[] arr){
        if (arr == null || arr.length < 2) {
            System.out.println("Array must contain at least 2 elements");
            return -1;
        }

        // Count frequencies to identify the value that comes at lease once
        Map<Integer, Integer> frequnecyMap = new HashMap<>();
        for (int num : arr) {
            frequnecyMap.put(num, frequnecyMap.getOrDefault(num, 0) + 1);
        }

        // Find smallest value that at occurs at least twice
        int targetMinValue = Integer.MAX_VALUE;
        boolean foundTarget = false;
        for (Map.Entry<Integer, Integer> entry : frequnecyMap.entrySet()) {
            //For each entry, only consider values that appear >=2
            if (entry.getValue() >= 2) {
                if (entry.getKey() < targetMinValue) {
                    targetMinValue = entry.getKey();
                    foundTarget = true;
                }
            }
        }
        if (!foundTarget) {
            System.out.println("Error: Minimum value occurs less than twice");
        }

        // Find min distance between occurrences of  targetMinValue
        int minDistance = Integer.MAX_VALUE;
        int lastMinIndex = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == targetMinValue) {
                if (lastMinIndex != -1){
                    int currentDistance = i - lastMinIndex;
                    minDistance = Math.min(minDistance, currentDistance);
                }
                lastMinIndex = i;
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] arr1 = {1, 5, 2, 8, 2, 3, 2};
        System.out.println("Array: " + Arrays.toString(arr1) + ", Distance: " + findDistanceBetweenClosestMinimumByHashMaps(arr1)); // Expected: 2

        int[] arr2 = {3, 1, 4, 1, 5, 9, 1, 2};
        System.out.println("Array: " + Arrays.toString(arr2) + ", Distance: " + findDistanceBetweenClosestMinimums(arr2)); // Expected: 2

        int[] arr3 = {10, 20, 10, 5, 30, 5, 40};
        System.out.println("Array: " + Arrays.toString(arr3) + ", Distance: " + findDistanceBetweenClosestMinimums(arr3)); // Expected: 2 (between the two 5s)

        int[] arr4 = {5, 5, 5, 5};
        System.out.println("Array: " + Arrays.toString(arr4) + ", Distance: " + findDistanceBetweenClosestMinimums(arr4)); // Expected: 1

        int[] arr5 = {1, 2, 3, 4, 1}; // Min appears twice, but not "closest"
        System.out.println("Array: " + Arrays.toString(arr5) + ", Distance: " + findDistanceBetweenClosestMinimums(arr5)); // Expected: 4

        int[] arr6 = {7, 7, 7, 2, 2, 2, 1, 1}; // Min is 1, closest distance is 1
        System.out.println("Array: " + Arrays.toString(arr6) + ", Distance: " + findDistanceBetweenClosestMinimums(arr6)); // Expected: 1

        // Edge Cases
        int[] arr7 = {10, 20, 30}; // Min occurs once
        System.out.println("Array: " + Arrays.toString(arr7) + ", Distance: " + findDistanceBetweenClosestMinimums(arr7)); // Expected: -1 (or error message)

        int[] arr8 = {5}; // Less than two elements
        System.out.println("Array: " + Arrays.toString(arr8) + ", Distance: " + findDistanceBetweenClosestMinimums(arr8)); // Expected: -1 (or error message)

        int[] arr9 = {}; // Empty array
        System.out.println("Array: " + Arrays.toString(arr9) + ", Distance: " + findDistanceBetweenClosestMinimums(arr9)); // Expected: -1 (or error message)

        int[] arr10 = null; // Null array
        System.out.println("Array: " + Arrays.toString(arr10) + ", Distance: " + findDistanceBetweenClosestMinimums(arr10)); // Expected: -1 (or error message)
    }

}
