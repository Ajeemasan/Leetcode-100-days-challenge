# Day 91 — Count Servers that Communicate

**LeetCode:** [1267. Count Servers that Communicate](https://leetcode.com/problems/count-servers-that-communicate/)

**Difficulty:** Medium

**Topic:** Array, Matrix, Counting

## 🧠 Intuition

A server can communicate with another server if they share the same row or column.

Instead of checking every server against every other server, we can count the number of servers in each row and column. A server can communicate if its row or column contains more than one server.

## 🔄 Approach

**1. Count Servers in Each Row and Column**

- Create two arrays: `rows[]` and `cols[]`.
- Traverse the grid and increment the corresponding row and column counts whenever a server (`1`) is found.

**2. Count Communicating Servers**

- Traverse the grid again.
- For every server, check whether its row count or column count is greater than one.
- If either condition is satisfied, increment the answer.

**3. Return the Result**

The final count represents all servers that can communicate with at least one other server.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `m` be the number of rows and `n` be the number of columns.

- **Time:** O(m × n), as the grid is traversed twice.
- **Space:** O(m + n), for the row and column frequency arrays.

## 📌 Key Takeaway

Precomputing row and column frequencies avoids repeated comparisons between servers. A simple two-pass matrix traversal is enough to solve the problem efficiently.