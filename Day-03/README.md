# Day 3 — Length of Longest Subarray With at Most K Frequency

**LeetCode:** [2958. Length of Longest Subarray With at Most K Frequency](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)

**Difficulty:** Medium

**Topic:** Arrays, HashMap, Sliding Window, Two Pointers

## 🧠 Intuition

We need to find the longest subarray in which no element appears more than `k` times.

The important observation is that we can maintain a **window** of elements and keep track of the frequency of each element inside that window.

If adding a new element causes its frequency to become greater than `k`, the current window is invalid.

We can then move the left pointer forward until the window becomes valid again.

## 🔄 Approach

I used the **Sliding Window + Two Pointer** technique with a `HashMap`.

1. Use two pointers `i` and `j` to represent the current window.
2. Use a `HashMap` to store the frequency of each element inside the current window.
3. Expand the window by moving `j` forward.
4. Before adding an element, check whether its current frequency has already reached `k`.
5. If it has, shrink the window by moving `i` forward and decreasing the frequency of `nums[i]`.
6. Continue expanding the window while maintaining the condition that every element appears at most `k` times.
7. Keep track of the maximum window length found.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Each element is added to the window at most once and removed from the window at most once.

* **Time:** `O(n)`
* **Space:** `O(n)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When a subarray must satisfy a frequency constraint, a sliding window can efficiently maintain the valid range while expanding and shrinking as needed.

This problem helped me practice the **Sliding Window + HashMap frequency** pattern.
