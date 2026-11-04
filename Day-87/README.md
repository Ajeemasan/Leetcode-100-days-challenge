# Day 87 — Minimum Operations to Make Elements Within K Subarrays Equal

**LeetCode:** [3505. Minimum Operations to Make Elements Within K Subarrays Equal](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/)

**Difficulty:** Hard

**Topic:** Array, Sliding Window, Sorting, TreeMap, Median, Dynamic Programming

## 🧠 Intuition

The problem requires selecting exactly `k` non-overlapping subarrays of length `x` and minimizing the operations needed to make all elements within each selected subarray equal.

The optimal target for a subarray is its median, since the median minimizes the sum of absolute differences.

Computing this cost independently for every window would be expensive. Instead, we maintain two balanced `TreeMap` structures to efficiently track the median and calculate the cost as the sliding window moves. A second phase uses dynamic programming to select the optimal non-overlapping windows.

## 🔄 Approach

**1. Sliding Window with Two TreeMaps**

- Maintain two multisets using `TreeMap`:
    - `left` stores the smaller half of the window.
    - `right` stores the larger half.
- Track the sizes and sums of both halves.
- Keep `left` with `(x + 1) / 2` elements so that its largest element represents the median.
- As the window slides, remove the outgoing element, insert the incoming element, and rebalance the two halves.

**2. Calculate Minimum Window Cost**

For each complete window, calculate the cost of making all its elements equal to the median:

`cost = median * leftSize - leftSum + rightSum - median * rightSize`

Store this value in `minOps`.

**3. Dynamic Programming**

Define `solve(i, k)` as the minimum cost of selecting `k` non-overlapping windows starting from index `i`.

At each position, consider two choices:

- **Take:** Select the window starting at `i`, add its cost, and continue from `i + x`.
- **Skip:** Ignore the current position and continue from `i + 1`.

Take the minimum of both choices and memoize the result.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the array length.

- **Time:** O(n log x + nk), for sliding-window maintenance and the DP states.
- **Space:** O(n + nk), for window costs, the two TreeMaps, and the DP table.

## 📌 Key Takeaway

This problem combines two important optimization techniques: maintaining a sliding-window median efficiently and using dynamic programming to select non-overlapping intervals.

Breaking a complex problem into independent window-cost computation and optimal interval selection makes the overall solution easier to reason about.