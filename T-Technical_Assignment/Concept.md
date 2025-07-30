# Algorithm Solutions Reference

This document contains detailed solutions and algorithms for 7 common programming problems, including multiple approaches, time/space complexity analysis, and implementation strategies.

## Table of Contents
1. [Get Longest Valid String](#1-get-longest-valid-string)
2. [Unique Sum Ways](#2-unique-sum-ways)
3. [Make Array Zero Except First](#3-make-array-zero-except-first)
4. [First Unique Product](#4-first-unique-product)
5. [Distance Between Two Closest Minimums](#5-distance-between-two-closest-minimums)
6. [Three Most Common Strings in a Sentence](#6-three-most-common-strings-in-a-sentence)
7. [Rotate a List N Times to the Right](#7-rotate-a-list-n-times-to-the-right)

---

## 1. Get Longest Valid String

### Problem Statement
Implement a function `getLongestString` that returns the longest string from a given array of strings that meets two conditions:
- No repetitive identical characters (e.g., 'AA' is invalid)
- Contains only characters from a given list of valid characters

### Key Concepts
- String Iteration & Character Access
- Set/Hash Set for efficient lookups
- Looping/Iteration through arrays
- Conditional Logic for validation
- Tracking Maximum length

### Solution: Brute-Force / Direct Approach

**Algorithm:**
1. Initialize `longestValidString = ""`
2. Convert the characters list into a `HashSet<Character>` for efficient lookups
3. Iterate through each string in the input array:
    - **Check 1 - Non-Repetitive Characters:**
        - Iterate from first to second-to-last character
        - If `currentString.charAt(i) == currentString.charAt(i + 1)`, string is invalid
    - **Check 2 - Valid Characters Only:**
        - If Check 1 passed, iterate through each character
        - If character not in `validCharSet`, string is invalid
    - **Update Maximum:**
        - If both checks pass and length > current longest, update `longestValidString`
4. Return `longestValidString`

**Complexity:**
- Time: O(N × L) where N = number of strings, L = max string length
- Space: O(C) where C = number of unique valid characters

---

## 2. Unique Sum Ways

### Problem Statement
Given a number "result" and an array of numbers, find how many unique ways the array's numbers can be added to match the "result."

### Key Concepts
- Combinatorics/Subset Sum Problem
- Recursion/Backtracking
- Dynamic Programming optimization
- Uniqueness handling (sets vs permutations)

### Solution 1: Recursive Backtracking

**Algorithm:**
1. Sort the input array for consistent ordering
2. Define recursive helper: `countUniqueWays(target, currentIndex, currentSum, currentCombination)`
3. **Base Cases:**
    - If `currentSum == target`: increment counter
    - If `currentSum > target` or `currentIndex >= array.length`: invalid path
4. **Recursive Steps:**
    - Include `array[currentIndex]`: recurse with updated sum and index
    - Exclude `array[currentIndex]`: recurse with same sum, next index
5. Use HashSet to ensure combination uniqueness

**Complexity:**
- Time: O(2^N) worst case
- Space: O(N) for recursion stack + O(NumCombinations × N) for unique combinations

### Solution 2: Dynamic Programming

**Algorithm:**
1. Initialize DP array `dp[result + 1]` with `dp[0] = 1`
2. For each number in input array:
    - Iterate from `j = result` down to `num`
    - Update `dp[j] = dp[j] + dp[j - num]`
3. Return `dp[result]`

**Complexity:**
- Time: O(N × Result)
- Space: O(Result)

---

## 3. Make Array Zero Except First

### Problem Statement
Given a positive integer array, make all elements zero (except first element `a[0]`) by repeatedly applying: choose index `i` and replace `a[i]` with `a[i] - a[i-1]`. Return 1 if possible, 0 otherwise.

### Key Concepts
- Mathematical Invariance/Properties
- Greatest Common Divisor (GCD)
- Divisibility relationships
- Constraint interpretation

### Solution: GCD-Based Divisibility Check

**Algorithm:**
1. **Handle Edge Cases:**
    - If array is null/empty, return 0
    - If length == 1, return 1
    - If `a[0] <= 0`, return 0
2. **Check Divisibility Chain:**
    - Iterate from `i = 1` to `length - 1`
    - If `a[i] <= 0`, return 0
    - If `a[i] % a[0] != 0`, return 0 (not divisible by first element)
3. If loop completes, return 1

**Key Insight:** All elements must be multiples of `a[0]` to be reducible to zero through the given operation.

**Complexity:**
- Time: O(N)
- Space: O(1)

---

## 4. First Unique Product

### Problem Statement
Write a method that efficiently finds the first element in an array that occurs only once. If no unique elements exist, return null.

### Key Concepts
- Frequency Counting with HashMap
- Order Preservation
- Efficiency optimization

### Solution: Two-Pass Hash Map Approach

**Algorithm:**
1. **First Pass - Count Frequencies:**
    - Create `HashMap<Element_Type, Integer>`
    - Iterate through array, increment count for each element
2. **Second Pass - Find First Unique:**
    - Iterate through array in original order
    - For each element, check frequency in HashMap
    - If frequency == 1, return this element
3. If no unique element found, return null

**Complexity:**
- Time: O(N)
- Space: O(D) where D = number of distinct elements

### Alternative: LinkedHashMap Approach
Use `LinkedHashMap` to preserve insertion order, then iterate through entrySet to find first element with frequency 1.

---

## 5. Distance Between Two Closest Minimums

### Problem Statement
Given an array of integers, find the distance between the two closest minimum values. Guaranteed that minimum occurs at least twice.

### Key Concepts
- Finding minimum value
- Tracking indices
- Minimum distance calculation
- Guaranteed occurrences simplification

### Solution 1: Two-Pass Approach

**Algorithm:**
1. **First Pass - Find Global Minimum:**
    - Initialize `minVal = Integer.MAX_VALUE`
    - Iterate through array, update `minVal = Math.min(minVal, currentElement)`
2. **Second Pass - Find Closest Occurrences:**
    - Initialize `minDistance = Integer.MAX_VALUE`, `lastMinIndex = -1`
    - Iterate through array:
        - If `a[i] == minVal` and `lastMinIndex != -1`:
            - Calculate `currentDistance = i - lastMinIndex`
            - Update `minDistance = Math.min(minDistance, currentDistance)`
        - Update `lastMinIndex = i`
3. Return `minDistance`

**Complexity:**
- Time: O(N)
- Space: O(1)

### Solution 2: Single-Pass Approach

**Algorithm:**
1. Initialize `minVal = Integer.MAX_VALUE`, `minDistance = Integer.MAX_VALUE`, `lastMinIndex = -1`
2. Iterate through array:
    - If `a[i] < minVal`: new minimum found, reset tracking variables
    - Else if `a[i] == minVal`: calculate distance and update minimum distance
3. Return `minDistance`

**Complexity:**
- Time: O(N)
- Space: O(1)

---

## 6. Three Most Common Strings in a Sentence

### Problem Statement
Given a sentence, return the three most common strings in ascending alphabetic order.

### Key Concepts
- String normalization (case handling)
- Tokenization (word extraction)
- Frequency counting
- Custom sorting with multiple criteria
- Final output ordering

### Solution: Hash Map with Multi-Stage Sorting

**Algorithm:**
1. **Normalization & Tokenization:**
    - Convert sentence to lowercase
    - Use regex `\b[a-zA-Z0-9]+\b` to extract words
    - Populate `HashMap<String, Integer>` with word counts
2. **Intermediate Sorting:**
    - Create `ArrayList<Map.Entry<String, Integer>>` from entrySet
    - Sort with custom Comparator:
        - Primary: frequency (descending)
        - Secondary: alphabetical (ascending)
3. **Extract Top 3:**
    - Add first 3 entries' keys to `topThreeWords` list
4. **Final Output Sorting:**
    - Sort `topThreeWords` alphabetically ascending
    - Return result

**Complexity:**
- Time: O(L + D log D) where L = sentence length, D = distinct words
- Space: O(D × W_avg) where W_avg = average word length

---

## 7. Rotate a List N Times to the Right

### Problem Statement
Rotate a list by moving each element n times to the right.

### Key Concepts
- Array/Linked List manipulation
- Modular arithmetic for large n values
- Pointer/Index management
- Edge case handling

### Solution 1: Arrays - Temporary Array Approach

**Algorithm:**
1. **Handle Edge Cases:** null, empty, or n=0
2. **Effective Rotations:** `n_effective = n % list.size()`
3. **Create New Container:** Initialize `rotatedList` of same size
4. **Copy Elements:**
    - Copy trailing elements: `originalList[length - n_effective]` to `originalList[length - 1]` → beginning of `rotatedList`
    - Copy leading elements: `originalList[0]` to `originalList[length - n_effective - 1]` → remaining positions
5. Return `rotatedList`

**Complexity:**
- Time: O(L)
- Space: O(L)

### Solution 2: Arrays - Reversal Method (In-Place)

**Algorithm:**
1. Handle edge cases and calculate `n_effective = n % array.length`
2. **Three Reversals:**
    - Reverse entire array: `[0, length-1]`
    - Reverse first `n_effective` elements: `[0, n_effective-1]`
    - Reverse remaining elements: `[n_effective, length-1]`

**Complexity:**
- Time: O(L)
- Space: O(1)

### Solution 3: Linked Lists - Pointer Adjustment

**Algorithm:**
1. Handle edge cases
2. **Calculate Length & Form Circle:**
    - Traverse to find length and connect tail to head
3. **Find New Head/Tail:**
    - Calculate `stepsToNewHead = length - (n % length)`
    - Traverse to find new head and tail positions
4. **Break Circle:** Set new tail's next to null, return new head

**Complexity:**
- Time: O(L)
- Space: O(1)

### Solution 4: Repeated Move (Sub-Optimal)

**Algorithm:**
Repeat `n_effective` times: remove last element and insert at beginning.

**Complexity:**
- Time: O(L × n_effective) for ArrayList, O(n_effective) for proper linked lists
- Space: O(1)

---

## Usage Notes

- Choose algorithms based on your specific constraints (time vs space, in-place vs extra memory)
- Consider edge cases in all implementations
- For interview settings, discuss trade-offs between different approaches
- Test with various input sizes and edge cases

## Implementation Tips

- Use appropriate data structures (HashMap for frequency counting, HashSet for uniqueness)
- Handle modular arithmetic for rotation problems
- Consider mathematical properties (GCD, divisibility) for optimization
- Preserve order when required using LinkedHashMap or careful iteration