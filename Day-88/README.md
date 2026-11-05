# Day 88 — Find the Distance Value Between Two Arrays

**LeetCode:** [1385. Find the Distance Value Between Two Arrays](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)

**Difficulty:** Easy

**Topic:** Array, Brute Force

## 🧠 Intuition

An element in `arr1` contributes to the distance value only if its absolute difference from every element in `arr2` is strictly greater than `d`.

We can check this condition for each element independently and count the elements that satisfy it.

## 🔄 Approach

1. Iterate through every element in `arr1`.
2. Assume the current element is valid by initializing a boolean flag to `true`.
3. Compare it with every element in `arr2`.
4. If `Math.abs(arr1[i] - arr2[j]) <= d`, the element is invalid. Set the flag to `false` and stop checking further elements.
5. If the flag remains `true`, increment the answer.
6. Return the final count.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of `arr1` and `m` be the length of `arr2`.

- **Time:** O(n × m), since each element of `arr1` may be compared with every element of `arr2`.
- **Space:** O(1), as only a few variables are used.

## 📌 Key Takeaway

A straightforward nested-loop approach is sufficient when the input constraints are small. Identifying when an element can be rejected early using a boolean flag also avoids unnecessary comparisons.