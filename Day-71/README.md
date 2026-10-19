# Day 71 — Find Target Indices After Sorting Array

**LeetCode:** [2089. Find Target Indices After Sorting Array](https://leetcode.com/problems/find-target-indices-after-sorting-array/)

**Difficulty:** Easy

**Topic:** Array, Hash Map, Counting

## 🧠 Intuition

After sorting the array in ascending order, all elements smaller than `target` appear before it, and all occurrences of `target` occupy consecutive positions.

Instead of sorting the array, we can count how many elements are smaller than `target` and how many times `target` occurs. The count of smaller elements gives the first target index.

## 🔄 Approach

1. Traverse the array once:
    - Store each element's frequency in a `HashMap`.
    - Count how many elements are smaller than `target`.
2. Initialize an empty result list.
3. If `target` exists in the map, repeatedly add the current count of smaller elements to the result.
4. Increment the index for each occurrence of `target` until its frequency reaches zero.
5. Return the list of target indices.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n + c), where `n` is the array length and `c` is the number of occurrences of `target`. This simplifies to O(n).
- **Space:** O(u), where `u` is the number of distinct elements stored in the `HashMap`.

## 📌 Key Takeaway

A sorted array's target indices can be determined without actually sorting it. Counting smaller elements identifies the starting index, while counting target occurrences determines how many consecutive indices to return.