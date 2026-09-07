# Day 29 — Distinct Subsequences II

**LeetCode:** [940. Distinct Subsequences II](https://leetcode.com/problems/distinct-subsequences-ii/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Strings, Counting, Duplicate Handling

## 🧠 Intuition

The goal is to count the number of distinct non-empty subsequences that can be formed from the given string.

When processing a new character, every existing subsequence can either include or exclude that character. This initially appears to double the number of subsequences.

However, if the same character has appeared before, some of the newly generated subsequences will be duplicates.

To avoid counting them multiple times, I keep track of the previous occurrence of each character and subtract the subsequences that were already generated at that point.

## 🔄 Approach

I used **Dynamic Programming with last-occurrence tracking**.

1. Let `dp[i]` represent the number of distinct subsequences, including the empty subsequence, that can be formed using the first `i` characters.
2. Initially, `dp[0] = 1` because there is one empty subsequence.
3. For every character:
    - Double the previous number of subsequences because the current character can either be included or excluded.
    - If the character appeared before, subtract the subsequences that were already counted because of that previous occurrence.
4. Store the latest position of each character in the `last` array.
5. Finally, subtract `1` to exclude the empty subsequence.

The result is calculated modulo `10^9 + 7`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the string.

- **Time:** `O(n)`
- **Space:** `O(n)`

## 📌 Key Takeaway

> When counting distinct subsequences, simply generating new subsequences can lead to duplicate counting. Tracking the last occurrence of each character allows those duplicates to be removed efficiently.

This problem reinforced the importance of identifying **duplicate states in Dynamic Programming** and carefully defining what each DP state represents.