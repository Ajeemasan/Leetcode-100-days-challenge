# Day 35 — Image Overlap

**LeetCode:** [835. Image Overlap](https://leetcode.com/problems/image-overlap/)

**Difficulty:** Medium

**Topic:** Arrays, Hashing, Coordinate Shift

## 🧠 Intuition

Only the cells containing `1` contribute to the overlap. For every `1` in `img1`, pair it with every `1` in `img2` and calculate the shift required to align them. The shift that occurs most frequently gives the maximum overlap.

## 🔄 Approach

Store the coordinates of all `1`s from both images. For every pair of coordinates, calculate the row and column shift and count how often each shift occurs using a 2D array. The maximum shift count is the answer.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(n² + k₁ × k₂)`
- **Space:** `O(n² + k₁ + k₂)`

where `k₁` and `k₂` are the number of `1`s in `img1` and `img2`.

## 📌 Key Takeaway

Instead of trying every possible image shift directly, count the relative coordinate differences between every pair of `1`s. The most frequent shift represents the maximum overlap.