# Day 36 — Rectangle Overlap

**LeetCode:** [836. Rectangle Overlap](https://leetcode.com/problems/rectangle-overlap/)

**Difficulty:** Easy

**Topic:** Geometry, Arrays

## 🧠 Intuition

Two rectangles overlap only if they have a positive-width intersection horizontally and a positive-height intersection vertically. If one rectangle is completely to the left, right, above, or below the other, they do not overlap.

## 🔄 Approach

Check all four non-overlapping conditions and negate the result. Using `<=` ensures that rectangles touching only at an edge or corner are not considered overlapping.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(1)`
- **Space:** `O(1)`

## 📌 Key Takeaway

For geometry problems, identifying the conditions where the desired result **cannot** happen can often lead to a simple and efficient solution.