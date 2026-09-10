# Day 32 — Count Nodes Equal to Average of Subtree

**LeetCode:** [2265. Count Nodes Equal to Average of Subtree](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/)

**Difficulty:** Medium

**Topic:** Binary Tree, DFS, Recursion

## 🧠 Intuition

Use postorder DFS to calculate the sum and number of nodes in each subtree. If the integer average of a subtree equals the current node's value, count that node.

## 🔄 Approach

For every node, recursively calculate the sum and count of its left and right subtrees, combine them with the current node, and check whether `sum / count == root.val`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(n)`
- **Space:** `O(h)`, where `h` is the height of the tree.

## 📌 Key Takeaway

Postorder DFS is useful when a node's result depends on information from its children. Returning both the subtree sum and node count allows us to solve the problem in a single traversal.