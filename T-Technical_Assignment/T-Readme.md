# Junior Developer Technical Assessment

## Programming Language and Version
**Java 23**

[//]: # (## Project Structure)

[//]: # (```)

[//]: # (test/)

[//]: # (├── Question1_GetLongestString.java)

[//]: # (├── Question2_UniqueSums.java)

[//]: # (├── Question3_MakeArrayZero.java)

[//]: # (├── Question4_UniqueProduct.java)

[//]: # (├── Question5_ClosestMinimums.java)

[//]: # (├── Question6_ThreeMostCommon.java)

[//]: # (├── Question7_RotateList.java)

[//]: # (├── TestRunner.java)

[//]: # (├── README.md)

[//]: # (└── test_cases/)

[//]: # (    ├── test_question1.txt)

[//]: # (    ├── test_question2.txt)

[//]: # (    ├── test_question3.txt)

[//]: # (    ├── test_question4.txt)

[//]: # (    ├── test_question5.txt)

[//]: # (    ├── test_question6.txt)

[//]: # (    └── test_question7.txt)

[//]: # (```)

[//]: # ()
[//]: # (## How to Run the Code)

[//]: # ()
[//]: # (### Compile and Run Individual Solutions:)

[//]: # (```bash)

[//]: # (# Compile)

[//]: # (javac Question1_GetLongestString.java)

[//]: # (javac Question2_UniqueSums.java)

[//]: # (javac Question3_MakeArrayZero.java)

[//]: # (javac Question4_UniqueProduct.java)

[//]: # (javac Question5_ClosestMinimums.java)

[//]: # (javac Question6_ThreeMostCommon.java)

[//]: # (javac Question7_RotateList.java)

[//]: # ()
[//]: # (# Run)

[//]: # (java Question1_GetLongestString)

[//]: # (java Question2_UniqueSums)

[//]: # (java Question3_MakeArrayZero)

[//]: # (java Question4_UniqueProduct)

[//]: # (java Question5_ClosestMinimums)

[//]: # (java Question6_ThreeMostCommon)

[//]: # (java Question7_RotateList)

[//]: # (```)

[//]: # ()
[//]: # (### Compile and Run All Tests:)

[//]: # (```bash)

[//]: # (javac *.java)

[//]: # (java TestRunner)

[//]: # (```)

## Solution Explanations

### Question 1: Get Longest Valid String
**Approach:** Two-pass validation using HashSet for efficient character lookup. First, convert valid characters to HashSet for O(1) lookup time. Then iterate through each string, checking for consecutive identical characters and invalid characters. Track the longest valid string found.

**Time Complexity:** O(N × L) where N = number of strings, L = maximum string length
**Space Complexity:** O(C) where C = number of valid characters

### Question 2: Unique Sum Ways
**Approach:** Dynamic Programming approach using subset sum counting. Create a DP array where dp[i] represents the number of ways to achieve sum i. For each number in the array, update the DP table by adding the number of ways to form (current_sum - number) to the ways to form current_sum.

**Time Complexity:** O(N × Result) where N = array length, Result = target sum
**Space Complexity:** O(Result)

### Question 3: Make Array Zero Except First
**Approach:** Mathematical analysis using GCD properties. The key insight is that for an element a[i] to become zero through repeated subtraction of a[i-1], a[i] must be divisible by a[0] (the first element). Check if all elements after the first are multiples of a[0].

**Time Complexity:** O(N)
**Space Complexity:** O(1)

### Question 4: First Unique Product
**Approach:** Two-pass HashMap approach. First pass counts frequency of each element, second pass iterates through original array to find the first element with frequency 1, preserving original order.

**Time Complexity:** O(N)
**Space Complexity:** O(D) where D = number of distinct elements

### Question 5: Distance Between Two Closest Minimums
**Approach:** Single-pass algorithm that tracks the minimum value and the distance between consecutive occurrences. When a new global minimum is found, reset tracking. When the current minimum is encountered again, calculate and update the minimum distance.

**Time Complexity:** O(N)
**Space Complexity:** O(1)

### Question 6: Three Most Common Strings in a Sentence
**Approach:** Tokenization and frequency counting with custom sorting. Split sentence into words, count frequencies using HashMap, sort by frequency (descending) then alphabetically (ascending), take top 3, and finally sort the result alphabetically.

**Time Complexity:** O(L + D log D) where L = sentence length, D = distinct words
**Space Complexity:** O(D × W) where W = average word length

### Question 7: Rotate List N Times to the Right
**Approach:** Linked list pointer manipulation with modular arithmetic. Calculate effective rotations using modulo operation, find the new tail (length - n positions from start), break the list at that point, and reconnect to form the rotated list.

**Time Complexity:** O(N)
**Space Complexity:** O(1)

## Test Cases Coverage

### Edge Cases Tested:
- **Empty inputs:** null arrays, empty strings, empty lists
- **Single elements:** arrays/lists with one element
- **Boundary conditions:** n=0 for rotation, target sum of 0, minimum occurring exactly twice
- **Large inputs:** testing with larger datasets to verify efficiency
- **Special cases:** all identical elements, no valid solutions, maximum possible values

### Test File Structure:
Each test file contains multiple test cases with expected outputs:
- Input parameters
- Expected output
- Description of what the test case covers
- Edge case classification

## Testing Strategy

### Unit Testing Approach:
1. **Positive Test Cases:** Verify correct functionality with valid inputs
2. **Negative Test Cases:** Test with invalid inputs and edge cases
3. **Boundary Testing:** Test with minimum and maximum values
4. **Performance Testing:** Verify efficiency with larger datasets

[//]: # (### Test Execution:)

[//]: # (```bash)

[//]: # (# Run comprehensive test suite)

[//]: # (java TestRunner)

[//]: # ()
[//]: # (# Expected output format:)

[//]: # (# Question 1: PASSED &#40;8/8 test cases&#41;)

[//]: # (# Question 2: PASSED &#40;6/6 test cases&#41;  )

[//]: # (# Question 3: PASSED &#40;7/7 test cases&#41;)

[//]: # (# Question 4: PASSED &#40;5/5 test cases&#41;)

[//]: # (# Question 5: PASSED &#40;6/6 test cases&#41;)

[//]: # (# Question 6: PASSED &#40;4/4 test cases&#41;)

[//]: # (# Question 7: PASSED &#40;9/9 test cases&#41;)

[//]: # (# )

[//]: # (# All tests completed successfully: 45/45 passed)
[//]: # (```)

## Code Quality Standards

### Design Principles Applied:
- **Clean Code:** Meaningful variable names, clear method signatures
- **Single Responsibility:** Each method has one clear purpose
- **DRY Principle:** Common functionality extracted into helper methods
- **Error Handling:** Proper null checks and edge case handling
- **Documentation:** Inline comments explaining complex logic

### Variable Naming Conventions:
- `validCharSet` - HashSet of valid characters
- `longestValid` - tracking variable for longest valid string
- `dp` - dynamic programming array
- `frequencyMap` - HashMap for counting occurrences
- `minDistance` - minimum distance between elements

## Algorithm Optimizations

### Performance Optimizations Implemented:
1. **Question 1:** HashSet for O(1) character lookup instead of O(C) linear search
2. **Question 2:** Bottom-up DP to avoid recursion overhead and stack overflow
3. **Question 3:** Mathematical insight eliminates need for simulation
4. **Question 4:** Single HashMap pass instead of nested loops
5. **Question 5:** Single pass instead of multiple array traversals
6. **Question 6:** Efficient tokenization using built-in string methods
7. **Question 7:** Modular arithmetic to handle large rotation values efficiently

### Memory Optimizations:
- Reusing data structures where possible
- Using primitive arrays instead of wrapper collections when appropriate
- Minimizing object creation in loops
- Efficient string handling to avoid unnecessary concatenations

## Additional Notes

### Development Process:
1. **Problem Analysis:** Carefully analyzed each problem to identify optimal approaches
2. **Algorithm Selection:** Chose algorithms based on time/space complexity requirements
3. **Implementation:** Wrote clean, readable code with comprehensive error handling
4. **Testing:** Developed extensive test cases covering all scenarios
5. **Optimization:** Refined solutions for better performance and code quality

### Challenges Encountered:
- **Question 2:** Initially implemented recursive solution but optimized to DP for better performance
- **Question 3:** Required mathematical insight about GCD properties rather than simulation
- **Question 6:** Handling tie-breaking in sorting required custom comparator implementation
- **Question 7:** Managing linked list pointers carefully to avoid circular references

### Future Improvements:
- Add more comprehensive error messages for invalid inputs
- Implement alternative algorithms for comparison
- Add performance benchmarking utilities
- Consider parallel processing for larger datasets where applicable

[//]: # (## Submission Checklist)

[//]: # ()
[//]: # (- ✅ All 7 questions implemented in Java 25)

[//]: # (- ✅ One file per question with proper naming convention)

[//]: # (- ✅ README.md with all required information)

[//]: # (- ✅ Test files and scripts included)

[//]: # (- ✅ Code comments explaining approach and logic)

[//]: # (- ✅ Edge cases tested and handled)

[//]: # (- ✅ Clean, readable code with meaningful variable names)

[//]: # (- ✅ GitHub repository created and committed)

[//]: # (- ✅ Video explanation recorded &#40;link to be provided separately&#41;)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (**Repository Link:** [GitHub Repository URL to be provided])

[//]: # (**Video Explanation:** [Video link to be provided with public access])

[//]: # ()
[//]: # (**Total Development Time:** Approximately 5 hours as estimated)

[//]: # (**Testing Time:** Additional 1 hour for comprehensive test case development)