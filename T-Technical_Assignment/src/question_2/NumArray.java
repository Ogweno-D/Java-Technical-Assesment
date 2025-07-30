package question_2;

import java.util.Arrays;

public class NumArray {

    // Classic Coin Change Problem
    // Use Dynamic Programming to solve this problem
    // Assuming dp[i] are the optimum ways to find the sum[i]
    // So for example we want to find for a result = 5,
    // The number of subproblems will be 6(From index 0-6)
    // We are given a result = type int
    // And an array int numArray[]= {2,5,7,8,3}

    public static int countWays(int result, int[] numbers) {
        // Create a dp array to store the number of ways for each sum
        // from 0 to result == result+1
        int[] dp = new int[result + 1];

        // Base case- i.e starting with zero,which takes no numbers
        dp[0] = 1;

        // Then iterate through each number available in the array
        // for each  (num) we iterate through all the possible sums from num upto result
        for (int num : numbers) {
            System.out.println("Current num: " + num);

            for (int i = num; i <= result; i++) {
                System.out.println("  Processing sum i: " + i + ", looking up dp[" + (i - num) + "]");

                dp[i] = dp[i] + dp[i - num];
            }
            System.out.println("After processing number" + num + ": " + Arrays.toString(dp));
        }

        return dp[result];
    }

    public static void main(String[] args) {
        // Test Case 1
        int result1 = 5;
        int[] numbers1 = {1, 2, 5};
        System.out.println("Target: " + result1 + ", Numbers: " + Arrays.toString(numbers1));
        int ways1 = countWays(result1, numbers1);
        System.out.println("Number of ways: " + ways1); // Expected output: 4
        // Ways for 5:
        // [1,1,1,1,1]
        // [1,1,1,2]
        // [1,2,2]
        // [5]

        System.out.println("\n--------------------\n");

        // Test Case 2
        int result2 = 10;
        int[] numbers2 = {2, 3, 5};
        System.out.println("Target: " + result2 + ", Numbers: " + Arrays.toString(numbers2));
        int ways2 = countWays(result2, numbers2);
        System.out.println("Number of ways: " + ways2); // Expected output: 4
        // Ways for 10:
        // [2,2,2,2,2]
        // [2,2,3,3]
        // [2,3,5]
        // [5,5]

        System.out.println("\n--------------------\n");

        // Test Case 3: No way to make the sum
        int result3 = 7;
        int[] numbers3 = {3, 5};
        System.out.println("Target: " + result3 + ", Numbers: " + Arrays.toString(numbers3));
        int ways3 = countWays(result3, numbers3);
        System.out.println("Number of ways: " + ways3); // Expected output: 0
    }
}

