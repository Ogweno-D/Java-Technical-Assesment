package question_3;

import java.util.Arrays;

public class NonZeroIntegerArray {
    // Well, a[i] = a[i]-a[i-1]
    // Used finding th GCD Approach

    // Check if array can be transformed to have all zeros except the first
    // That is by repeatedly applying A[i]= A[i] - A[i-1]

    public static int canMakeZeroExceptFirst(int[]a){
        // Null case handling
        if(a==null || a.length==0) {
            System.out.println("Sorry, the input array is null. Returning 0");
            return 0;
        }

        if(a.length == 1){
            System.out.println("The array only has one element. Returning 1");
            return 1;
        }

        // A sample value for the iterations
        int base = a[0];
        //Ensure the base value is positive
        if(base <= 0){
            System.out.println("First element is zero or negative hence it cannot be a baseValue");
        }

        //Iterate from the second element to the end
        for(int i=1; i< a.length; i++){
            int currentElement = a[i];

            // If currentElement is negative or zero. It is not positive as required
            if(currentElement <= 0){
                System.out.println("Encountered non-positive element at index" + i + ". Returning 0");
                return 0;
            }

            // Check if current element is perfectly divisible by our base value
            if(currentElement % base != 0){
                System.out.println("Element a["+i+"] (" + currentElement + ") is not multiple of a[0] or base of " + base);
                return 0;
            }
        }
        // If  all elements, pass the divisibility check, then it is possible
        System.out.println("All elements pass the check so it is possible");
        return  1;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("--- Test Cases (Integer Array) ---");

        // Example 1: Should be possible
        int[] arr1 = {2, 4, 6, 8};
        System.out.println("Array: " + Arrays.toString(arr1) + " -> Result: " + canMakeZeroExceptFirst(arr1)); // Expected: 1
        System.out.println("--------------------");

        // Example 2: Should not be possible (4 is not a multiple of 3)
        int[] arr2 = {3, 6, 4, 9};
        System.out.println("Array: " + Arrays.toString(arr2) + " -> Result: " + canMakeZeroExceptFirst(arr2)); // Expected: 0
        System.out.println("--------------------");

        // Example 3: Already in desired state (single element)
        int[] arr3 = {5};
        System.out.println("Array: " + Arrays.toString(arr3) + " -> Result: " + canMakeZeroExceptFirst(arr3)); // Expected: 1
        System.out.println("--------------------");

        // Example 4: Empty array
        int[] arr4 = {};
        System.out.println("Array: " + Arrays.toString(arr4) + " -> Result: " + canMakeZeroExceptFirst(arr4)); // Expected: 0
        System.out.println("--------------------");

        // Example 5: Null array
        int[] arr5 = null;
        System.out.println("Array: " + Arrays.toString(arr5) + " -> Result: " + canMakeZeroExceptFirst(arr5)); // Expected: 0
        System.out.println("--------------------");

        // Example 6: First element is 1 (should always work if numbers are positive)
        int[] arr6 = {1, 5, 10, 20};
        System.out.println("Array: " + Arrays.toString(arr6) + " -> Result: " + canMakeZeroExceptFirst(arr6)); // Expected: 1
        System.out.println("--------------------");

        // Example 7: Contains a zero (violates positive elements constraint)
        int[] arr7 = {5, 10, 0, 15};
        System.out.println("Array: " + Arrays.toString(arr7) + " -> Result: " + canMakeZeroExceptFirst(arr7)); // Expected: 0
        System.out.println("--------------------");

        // Example 8: Contains a negative number (violates positive elements constraint)
        int[] arr8 = {5, 10, -5, 15};
        System.out.println("Array: " + Arrays.toString(arr8) + " -> Result: " + canMakeZeroExceptFirst(arr8)); // Expected: 0
        System.out.println("--------------------");
    }
}
