# Day 84 — Minimum Moves to Equal Array Elements

**LeetCode:** [453. Minimum Moves to Equal Array Elements](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)

**Difficulty:** Medium

**Topic:** Array, Math, Greedy

## 🧠 Intuition

Incrementing every element except one by `1` is equivalent to decrementing a single element by `1` relative to all the others.

Therefore, instead of simulating operations, we can reduce every element to the minimum value in the array.

The minimum number of moves is simply the sum of the differences between each element and the minimum element.

## 🔄 Approach

1. Traverse the array to find the minimum element.
2. Initialize an answer variable to `0`.
3. Iterate through the array again.
4. For every element, calculate its difference from the minimum value and add it to the answer.
5. Return the total number of moves.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n), since the array is traversed twice.
- **Space:** O(1), since only a constant number of extra variables are used.

## 📌 Key Takeaway

A useful mathematical transformation can eliminate the need to simulate repeated operations. Recognizing that incrementing all but one element is equivalent to decrementing one element simplifies this problem into finding the minimum and calculating the total difference.