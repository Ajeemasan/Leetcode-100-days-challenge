# Day 21 — Removing Minimum and Maximum From Array

**LeetCode:** [2091. Removing Minimum and Maximum From Array](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/)

**Difficulty:** Medium

**Topic:** Arrays, Greedy

## 🧠 Intuition

We need to remove both the minimum and maximum elements from the array using the minimum number of deletions.

After finding the positions of the minimum and maximum elements, there are only three meaningful ways to remove both:

1. Remove everything from the front up to the farther element.
2. Remove everything from the back starting from the farther element.
3. Remove the elements from both ends, using the front for one element and the back for the other.

So the problem can be reduced to finding the minimum cost among these three possibilities.

## 🔄 Approach

1. Traverse the array once to find:
    - The minimum value and its index.
    - The maximum value and its index.
2. Consider the three possible deletion strategies:
    - **From the front:** remove up to the farther of the two indices.
    - **From the back:** remove from the farther index to the end.
    - **From both ends:** remove the earlier element from the front and the later element from the back.
3. Calculate the number of deletions for each strategy.
4. Return the minimum of the three.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

We traverse the array once to find the minimum and maximum elements.

- **Time:** `O(n)`
- **Space:** `O(1)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When an array problem allows operations from both ends, identify the important positions first and compare the possible ways of reaching them.

Instead of simulating every deletion, we can directly calculate the cost of the three possible strategies.