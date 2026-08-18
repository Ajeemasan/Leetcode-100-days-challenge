# Day 9 — Find the Largest Almost Missing Integer

**LeetCode:** [3471. Find the Largest Almost Missing Integer](https://leetcode.com/problems/find-the-largest-almost-missing-integer/)

**Difficulty:** Easy

**Topic:** Arrays, HashMap, HashSet, Sliding Window

## 🧠 Intuition

We need to find the largest integer that appears in exactly one subarray of length `k`.

The important observation is that we need to examine every possible window of size `k`.

Within each window, an element should only be counted once, even if it appears multiple times in that same window.

So I use a `HashSet` to keep track of the elements already encountered in the current window, and a `HashMap` to count how many different windows contain each number.

## 🔄 Approach

I used a **Sliding Window with HashMap and HashSet**.

1. Start with the first window of size `k`.
2. Use a `HashSet` to avoid counting the same number more than once within the current window.
3. For every unique number in the current window, increase its count in the `HashMap`.
4. Move the window one position to the right and repeat.
5. After processing all windows, iterate through the `HashMap`.
6. Among the numbers that appeared in exactly one window, return the largest one.
7. If no such number exists, return `-1`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

There are `O(n)` windows, and each window can contain up to `k` elements.

- **Time:** `O(nk)`
- **Space:** `O(n)`

The `HashMap` and `HashSet` store information about the elements encountered.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When an element needs to be counted across multiple windows but only once within each window, combining a HashSet with a HashMap can separate these two types of frequency tracking.

This problem helped me practice **sliding windows and frequency counting across overlapping subarrays**.