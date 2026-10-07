# Day 59 — Remove Invalid Parentheses

**LeetCode:** [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)

**Difficulty:** Hard

**Topic:** BFS, String, HashSet, Parentheses

## 🧠 Intuition

The goal is to remove the minimum number of parentheses so that the resulting strings are valid.

Since every removal represents one step, **Breadth-First Search (BFS)** is a natural approach. We start with the original string and generate all possible strings by removing one parenthesis. If no valid string is found, we continue to the next level by removing one more parenthesis.

The first level containing valid strings guarantees that the minimum number of removals has been made.

## 🔄 Approach

1. Use a `Queue` for BFS and start with the original string.
2. Use a `HashSet` to avoid processing the same string multiple times.
3. For each string:
    - Check whether it is valid using a balance counter.
    - If valid, add it to the result.
4. Once a valid string is found at the current BFS level, stop generating strings for deeper levels.
5. Otherwise, generate the next level by removing one parenthesis at each possible position.
6. Finally, sort the valid results lexicographically and return them.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n · 2ⁿ) in the worst case.
- **Space:** O(n · 2ⁿ) for the generated strings, queue, and visited set.

## 📌 Key Takeaway

BFS is useful when we need to find all solutions requiring the **minimum number of modifications**. Here, each BFS level represents one additional parenthesis removal, so the first level containing valid strings guarantees minimum removals.