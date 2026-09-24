# Day 46 — Smallest Index With Digit Sum Equal to Index

**LeetCode:** [3550. Smallest Index With Digit Sum Equal to Index](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/)

**Difficulty:** Easy

**Topic:** Arrays, Math, Digit Manipulation

## 🧠 Intuition

We need to find the smallest index `i` where the sum of the digits of `nums[i]` is exactly equal to `i`.

Since we only need the first valid index, we can scan the array from left to right and return immediately when the condition is satisfied.

## 🔄 Approach

- Traverse the array from left to right.
- Calculate the digit sum of `nums[i]`.
- Compare the digit sum with the current index `i`.
- Return the first index where both values are equal.
- If no such index exists, return `-1`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n × d), where `d` is the maximum number of digits in an element.
- **Space:** O(1)

## 📌 Key Takeaway

For simple array problems, a direct traversal combined with a small helper function can be both efficient and easy to understand. Since we need the **smallest index**, scanning from left to right lets us return as soon as the condition is met.