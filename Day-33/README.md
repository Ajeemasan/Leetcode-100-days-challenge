# Day 33 — Unique 3-Digit Even Numbers

**LeetCode:** [3483. Unique 3-Digit Even Numbers](https://leetcode.com/problems/unique-3-digit-even-numbers/)

**Difficulty:** Easy

**Topic:** Arrays, HashSet, Brute Force

## 🧠 Intuition

A valid number must have exactly 3 digits, cannot start with `0`, and must end with an even digit. We can try every combination of three distinct indices and use a `HashSet` to store only unique numbers.

## 🔄 Approach

Iterate through all possible hundreds, tens, and ones positions using three nested loops. Skip reused indices, leading zeros, and odd digits in the ones position. Store each valid number in a `HashSet` and return its size.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(n³)`
- **Space:** `O(k)`, where `k` is the number of unique 3-digit numbers.

## 📌 Key Takeaway

When the input size is small, straightforward brute force can be a clean and reliable solution. A `HashSet` is useful for automatically handling duplicate numbers created from repeated digits.