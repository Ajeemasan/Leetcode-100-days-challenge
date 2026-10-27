**LeetCode:** [3963. Create Grid With Exactly One Path](https://leetcode.com/problems/create-grid-with-exactly-one-path/)

**Difficulty:** Medium

**Topic:** Array, String, Constructive Algorithm

## 🧠 Intuition

The goal is to construct a grid that contains exactly one valid path between the required endpoints.

The key idea is to create a simple corridor using `.` cells while blocking alternative routes with `#` cells. My construction keeps the entire first row and the last column open, while filling the remaining cells with obstacles.

## 🔄 Approach

1. Create a string array of size `m` to represent the grid.
2. Iterate through every cell using nested loops.
3. Place `.` if the cell belongs to the first row or the last column.
4. Place `#` in every other cell to block alternative routes.
5. Convert each completed row into a string and store it in the grid.
6. Return the constructed grid.

A `StringBuilder` is reused for each row and cleared after storing it.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(m × n), since every cell is processed once.
- **Space:** O(m × n), for storing the grid.

## 📌 Key Takeaway

Constructive problems can often be solved by designing a simple structure that satisfies the required constraints rather than searching through every possible configuration.