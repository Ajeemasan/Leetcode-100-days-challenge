# Day 18 — Lexicographically Smallest Permutation Greater Than Target

**LeetCode:** [3720. Lexicographically Smallest Permutation Greater Than Target](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)

**Difficulty:** Medium

**Topic:** Greedy, Strings, Frequency Array, Lexicographical Ordering

## 🧠 Intuition

We need to construct the lexicographically smallest permutation of `s` that is strictly greater than `target`.

The key idea is that we should keep the permutation identical to `target` for as long as possible.

When we can no longer continue matching `target`, we try to make the smallest possible increase at the latest position.

To efficiently track which characters are still available, I use a frequency array of size `26`.

## 🔄 Approach

1. Count the frequency of every character in `s`.
2. Subtract the characters of `target` from the frequency array.
3. Traverse `target` from right to left.
4. At each position, add the current target character back to the available characters.
5. Check whether the prefix up to this position can be formed using the available characters.
6. Try to replace the current character with the smallest available character that is strictly greater than it.
7. Once such a character is found:
    - Keep the prefix unchanged.
    - Place the larger character at the current position.
    - Append all remaining characters in sorted order.
8. Return the constructed permutation.
9. If no valid permutation can be constructed, return an empty string.

Working from right to left is important because we want to make the change as late as possible while still making the entire string greater than `target`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the strings.

We scan the string from right to left, and the frequency array contains only `26` characters.

- **Time:** `O(26n)`
- **Space:** `O(26)`

Since the alphabet size is fixed at `26`, the time complexity can effectively be considered `O(n)`.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> To find the smallest string greater than a target, keep the prefix unchanged for as long as possible and make the smallest possible increase at the latest position.

This problem helped me practice combining **greedy thinking, frequency counting, and lexicographical ordering**.