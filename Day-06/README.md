# Day 6 — Longest Subsequence With Non-Zero Bitwise XOR

**LeetCode:** [3702. Longest Subsequence With Non-Zero Bitwise XOR](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/)

**Difficulty:** Easy

**Topic:** Arrays, Bit Manipulation, Bitwise XOR

## 🧠 Intuition

We want the longest subsequence whose bitwise XOR is non-zero.

The first thing to notice is that we can initially consider the **entire array**, because it gives us the maximum possible length.

There are two cases:

* If the XOR of the entire array is non-zero, the entire array is already the answer.
* If the XOR is zero, we need to remove at least one element.

If the array contains at least one non-zero element, removing any one non-zero element from a zero-XOR array makes the resulting XOR equal to that removed element, which is non-zero.

Therefore, we only need to remove one element.

If every element is zero, every possible subsequence also has XOR `0`, so the answer is `0`.

## 🔄 Approach

I used a **single traversal with bitwise XOR**.

1. Traverse the entire array.
2. Keep calculating the XOR of all elements.
3. Keep track of whether the array contains at least one non-zero element.
4. If all elements are zero, return `0`.
5. If the total XOR is non-zero, return the length of the entire array.
6. If the total XOR is zero but there is at least one non-zero element, remove one non-zero element and return `n - 1`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

We traverse the array only once.

* **Time:** `O(n)`
* **Space:** `O(1)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When working with XOR, understanding how removing an element changes the XOR can sometimes eliminate the need for complex subsequence or dynamic programming techniques.

This problem helped me strengthen my understanding of **bitwise XOR properties and greedy reasoning**.
