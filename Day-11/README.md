# Day 11 — Distribute Elements Into Two Arrays I

**LeetCode:** [3069. Distribute Elements Into Two Arrays I](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)

**Difficulty:** Easy

**Topic:** Arrays, Simulation

## 🧠 Intuition

The problem asks us to distribute the elements into two arrays.

The first element goes into `arr1` and the second element goes into `arr2`.

For every remaining element:

- If the last element of `arr1` is greater than the last element of `arr2`, add the current element to `arr1`.
- Otherwise, add it to `arr2`.

After processing all elements, concatenate `arr1` and `arr2` to obtain the result.

The important observation is that we only need to compare the **last elements** of the two arrays.

## 🔄 Approach

I used a simple **simulation** approach.

1. Initialize two arrays to store the elements.
2. Put `nums[0]` into the first array.
3. Put `nums[1]` into the second array.
4. Iterate through the remaining elements.
5. Compare the last elements of the two arrays.
6. Add the current element to the appropriate array.
7. Finally, combine both arrays into the result.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

We traverse the input array once and then combine the two arrays.

- **Time:** `O(n)`
- **Space:** `O(n)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When a problem describes a process step by step, directly simulating the process can often be the simplest and clearest solution.

This problem helped me practice **array manipulation and simulation**.