# Day 96 — Count Non-Decreasing Subarrays After K Operations

**LeetCode:** [3420. Count Non-Decreasing Subarrays After K Operations](https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/)

**Difficulty:** Hard

**Topic:** Array, Sliding Window, Monotonic Deque, Greedy

## 🧠 Intuition

We need to count subarrays that can be made non-decreasing using at most `k` operations, where each operation increments an element by one.

Instead of modifying every subarray independently, we process the array from right to left using a sliding window and a monotonic deque.

The deque maintains blocks of values and their frequencies. When a larger value is encountered, smaller blocks to its right are merged, and the cost of increasing those elements is updated.

## 🔄 Approach

**1. Maintain a Monotonic Deque**

- Each deque entry stores `{value, count}`.
- Traverse the array from right to left.
- While the last block's value is smaller than the current value, remove and merge that block.
- Increase the operation cost by `(currentValue - nextValue) * nextCount`.
- Insert the merged block into the deque.

**2. Maintain the Sliding Window**

- Use `j` as the right boundary of the valid window.
- If the total operation cost exceeds `k`, shrink the window from the right.
- Reduce the cost using the difference between the rightmost block's value and the element being removed.
- Decrease the block count and remove it when its count reaches zero.

**3. Count Valid Subarrays**

For each left boundary `i`, all subarrays ending between `i` and `j` are valid.

Therefore, add:

`ans += (j - i + 1)`

After processing every starting position, return the total count.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the array.

- **Time:** O(n), because each element is inserted into and removed from the deque at most once, and both pointers move only across the array.
- **Space:** O(n), for the monotonic deque.

## 📌 Key Takeaway

This problem combines a sliding window with a monotonic deque to maintain the minimum cost of transforming a subarray into a non-decreasing sequence. The key optimization is representing repeated values as blocks instead of processing individual elements repeatedly.