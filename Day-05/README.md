# Day 5 — Maximum Length Substring With Two Occurrences

**LeetCode:** [3090. Maximum Length Substring With Two Occurrences](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/)

**Difficulty:** Easy

**Topic:** String, HashMap, Sliding Window, Two Pointers

## 🧠 Intuition

We need to find the longest substring in which every character appears at most twice.

The important observation is that we can maintain a **sliding window** containing only valid characters.

As we expand the window, if a character appears for the third time, the current window becomes invalid.

We can then move the left pointer forward until that character appears at most twice again.

## 🔄 Approach

I used the **Sliding Window + HashMap** technique.

1. Use two pointers `i` and `j` to represent the current window.
2. Use a `HashMap` to store the frequency of each character inside the current window.
3. Move `j` forward while the current character appears at most twice.
4. If adding a character would make its frequency greater than `2`, shrink the window from the left by moving `i`.
5. Decrease the frequency of each character removed from the window.
6. Keep track of the maximum valid window length found.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Each character is added to the window at most once and removed from the window at most once.

* **Time:** `O(n)`
* **Space:** `O(k)`

where `n` is the length of the string and `k` is the number of distinct characters in the window.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When a substring must satisfy a frequency constraint, a sliding window can maintain the valid range efficiently by expanding when possible and shrinking when the constraint is violated.

This problem helped me reinforce the **Sliding Window + Frequency Map** pattern.
