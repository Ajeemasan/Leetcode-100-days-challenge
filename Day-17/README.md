# Day 17 — Shortest and Lexicographically Smallest Beautiful String

**LeetCode:** [2904. Shortest and Lexicographically Smallest Beautiful String](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/)

**Difficulty:** Medium

**Topic:** Sliding Window, Strings, Two Pointers

## 🧠 Intuition

A beautiful substring is a substring that contains exactly `k` ones.

The goal is to find:

1. The shortest beautiful substring.
2. If multiple substrings have the same length, return the lexicographically smallest one.

I use a **sliding window** to maintain a substring containing exactly `k` ones.

Whenever the window contains `k` ones, I try to shrink it from the left while keeping exactly `k` ones. This allows me to find the shortest possible substring ending at the current position.

If two substrings have the same length, I compare them lexicographically and keep the smaller one.

## 🔄 Approach

1. Maintain two pointers `i` and `j` representing the current window.
2. Keep track of the number of ones using `onesCount`.
3. Expand the right pointer `j` through the string.
4. Whenever a `1` is encountered, increment `onesCount`.
5. When `onesCount == k`, the current window is a valid beautiful substring.
6. Calculate its length.
7. Update the answer if:
    - The current substring is shorter than the best one found so far.
    - Or both have the same length but the current substring is lexicographically smaller.
8. Remove characters from the left of the window and continue searching for another valid substring.
9. If no valid substring exists, return an empty string.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the string.

The sliding window moves both pointers from left to right, so the main traversal takes `O(n)` time.

- **Time:** `O(n²)` in the worst case because substring creation and lexicographical comparison can take `O(n)`.
- **Space:** `O(n)` due to temporary substrings created during comparison.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> Sliding Window is useful when we need to find the shortest or longest substring satisfying a condition.

This problem also showed me how to combine **Sliding Window with lexicographical comparison** when multiple valid answers have the same length.