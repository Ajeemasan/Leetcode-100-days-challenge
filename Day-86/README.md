# Day 86 — Minimum Moves to Equal Array Elements III

**LeetCode:** [3736. Minimum Moves to Equal Array Elements III](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/)

**Difficulty:** Easy

**Topic:** Array, Math, Greedy

## 🧠 Intuition

The goal is to make all array elements equal using the minimum number of moves.

Since each move increases an individual element by `1`, choosing the maximum element as the target ensures that every other element only needs to be increased.

The minimum number of moves is therefore the sum of the differences between the maximum element and every array element.

## 🔄 Approach

1. Initialize `max` with the first element.
2. Traverse the array to find the maximum value.
3. Initialize the answer to `0`.
4. Traverse the array again and add `max - nums[i]` to the answer.
5. Return the total number of moves.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n), since the array is traversed twice.
- **Space:** O(1), since only a constant amount of extra space is used.

## 📌 Key Takeaway

Choosing the maximum element as the target eliminates unnecessary operations. A simple greedy observation reduces the problem to finding the maximum and calculating the total difference.