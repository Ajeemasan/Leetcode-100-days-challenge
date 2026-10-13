# Day 65 — Maximum Alternating Sum of Squares

**LeetCode:** [3727. Maximum Alternating Sum of Squares](https://leetcode.com/problems/maximum-alternating-sum-of-squares/)

**Difficulty:** Medium

**Topic:** Greedy, Sorting, Array

## 🧠 Intuition

Since squaring each element produces a non-negative value, the goal is to maximize the alternating sum by placing larger squared values in positions that contribute positively and smaller squared values in positions that contribute negatively.

Sorting the squared values allows us to separate them into two groups: the smaller half to subtract and the larger half to add.

## 🔄 Approach

1. Square every element in the array.
2. Sort the squared values in ascending order.
3. Subtract the sum of the smaller half of the values.
4. Add the sum of the larger half of the values.
5. Return the resulting maximum alternating sum.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n log n), dominated by sorting.
- **Space:** O(log n) auxiliary space for sorting, depending on the sorting implementation.

## 📌 Key Takeaway

Sorting helps maximize an alternating sum by assigning smaller values to negative contributions and larger values to positive contributions. Transforming the elements first—in this case, by squaring them—makes the optimization easier to reason about.