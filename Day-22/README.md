# Day 22 — Find the Minimum and Maximum Number of Nodes Between Critical Points

**LeetCode:** [2058. Find the Minimum and Maximum Number of Nodes Between Critical Points](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/)

**Difficulty:** Medium

**Topic:** Linked List, Traversal

## 🧠 Intuition

A critical point is a node that is either:

- A local maximum: its value is greater than both neighboring nodes.
- A local minimum: its value is smaller than both neighboring nodes.

We need to find:

- The minimum distance between any two critical points.
- The maximum distance between the first and last critical points.

Instead of storing all critical point positions, I only keep track of the **first critical point**, the **previous critical point**, and the current minimum distance.

This allows the problem to be solved in a single traversal.

## 🔄 Approach

1. Traverse the linked list while keeping track of the previous, current, and next node values.
2. Check whether the current node is a local maximum or local minimum.
3. When a critical point is found:
    - Store its position as the first critical point if it is the first one.
    - Calculate the distance from the previous critical point.
    - Update the minimum distance.
    - Update the last critical point.
4. After the traversal:
    - The maximum distance is the difference between the last and first critical points.
5. If fewer than two critical points exist, return `[-1, -1]`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

The linked list is traversed only once.

- **Time:** `O(n)`
- **Space:** `O(1)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When only distances between important positions are needed, we don't always need to store every position. Tracking the first and previous relevant positions can be enough.

This problem helped me practice **single-pass linked-list traversal** while keeping the extra space constant.