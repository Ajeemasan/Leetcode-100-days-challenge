# Day 95 — Longest Strictly Increasing or Strictly Decreasing Subarray

**LeetCode:** [3105. Longest Strictly Increasing or Strictly Decreasing Subarray](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/)

**Difficulty:** Easy

**Topic:** Array, Two Pointers

## 🧠 Intuition

We need to find the longest contiguous subarray that is either strictly increasing or strictly decreasing.

We can solve this by making two separate passes:
- One to find the longest strictly increasing subarray.
- Another to find the longest strictly decreasing subarray.

In each pass, maintain the length of the current valid sequence and update the maximum whenever the sequence breaks.

## 🔄 Approach

**1. Find the Longest Increasing Subarray**

- Initialize the current length to `1`.
- Traverse the array and compare each element with the previous one.
- If the current element is greater, increment the length.
- Otherwise, update the maximum length and reset the current length to `1`.
- Update the maximum once more after the loop to account for a sequence ending at the last element.

**2. Find the Longest Decreasing Subarray**

- Repeat the same process, but check whether the current element is smaller than the previous one.
- Track the maximum decreasing sequence length separately.

**3. Return the Result**

Return the maximum of the increasing and decreasing lengths.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the array.

- **Time:** O(n), since the array is traversed twice.
- **Space:** O(1), as only a constant number of variables are used.

## 📌 Key Takeaway

A simple linear scan can solve contiguous sequence problems efficiently. Separating increasing and decreasing conditions makes the logic straightforward while keeping the solution constant in auxiliary space.