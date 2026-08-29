# Day 20 — Make Lexicographically Smallest Array by Swapping Elements

**LeetCode:** [2948. Make Lexicographically Smallest Array by Swapping Elements](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/)

**Difficulty:** Medium

**Topic:** Greedy, Sorting, Arrays

## 🧠 Intuition

We can swap two elements when the difference between their values is at most `limit`.

The important observation is that after sorting the elements by value, consecutive elements whose difference is at most `limit` belong to the same group.

Within such a group, the elements can be rearranged among their original positions.

Therefore, to make the array lexicographically smallest, I:

- Sort the values.
- Group values that can be connected through the `limit` condition.
- Sort the original indices of each group.
- Place the smallest values at the smallest indices.

This gives the lexicographically smallest arrangement possible.

## 🔄 Approach

1. Store each number together with its original index.
2. Sort these pairs by their values.
3. Traverse the sorted array and identify groups where consecutive values differ by at most `limit`.
4. For each group:
    - Collect all the original indices.
    - Sort those indices.
    - The values are already sorted because the pairs were sorted by value.
5. Assign the smallest value in the group to the smallest original index, the next smallest value to the next index, and so on.
6. Return the resulting array.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Sorting the elements takes `O(n log n)` time.

For each group, the original indices are also sorted. Across all groups, this takes at most `O(n log n)` time.

- **Time:** `O(n log n)`
- **Space:** `O(n)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When elements can be rearranged within independent groups, sort the values and place the smallest values at the smallest available positions in each group.

This problem helped me practice combining **sorting, grouping, and greedy thinking** to construct a lexicographically smallest result.