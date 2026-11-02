# Day 85 — Minimum Moves to Equal Array Elements II

**LeetCode:** [462. Minimum Moves to Equal Array Elements II](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)

**Difficulty:** Medium

**Topic:** Array, Sorting, Math, Greedy

## 🧠 Intuition

Unlike the previous problem, where incrementing all but one element makes the minimum value optimal, this problem allows incrementing or decrementing any element individually.

The optimal target is the **median** of the array because it minimizes the sum of absolute differences between all elements and the target.

## 🔄 Approach

1. Sort the array in ascending order.
2. Find the median:
    - For an odd-sized array, select the middle element.
    - For an even-sized array, calculate the average of the two middle elements.
3. Iterate through the array and calculate the absolute difference between every element and the selected median.
4. Add all differences to obtain the minimum number of moves.
5. Return the total.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n log n), dominated by sorting. The final traversal takes O(n).
- **Space:** O(1) auxiliary space, excluding the sorting implementation's internal stack.

## 📌 Key Takeaway

The median minimizes the sum of absolute differences. Recognizing this mathematical property transforms an optimization problem into a simple sorting and traversal approach.