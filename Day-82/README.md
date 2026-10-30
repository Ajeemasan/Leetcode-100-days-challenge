# Day 82 — Shortest Path With At Most K Consecutive Identical Characters

**LeetCode:** [3970. Shortest Path With At Most K Consecutive Identical Characters](https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/)

**Difficulty:** Hard

**Topic:** Graph, Dijkstra's Algorithm, Priority Queue, Shortest Path, Dynamic Programming

## 🧠 Intuition

A normal shortest-path algorithm tracks only the minimum distance to each node. However, this problem introduces an additional constraint: we cannot have more than `k` consecutive nodes with identical labels along a path.

Therefore, reaching the same node with different consecutive-character counts represents different states.

We can solve this using Dijkstra's algorithm with an expanded state consisting of the current node and the number of consecutive identical labels.

## 🔄 Approach

1. Build an adjacency list to represent the directed weighted graph.
2. Create a 2D distance array `dist[n][k + 1]`, where `dist[u][c]` stores the minimum cost to reach node `u` with `c` consecutive identical labels.
3. Initialize the starting state at node `0` with distance `0` and consecutive count `1`.
4. Use a priority queue to process states in increasing order of their accumulated cost.
5. For each outgoing edge:
    - If the current and next node have the same label, increment the consecutive count.
    - Otherwise, reset the count to `1`.
6. If the updated count does not exceed `k` and the new cost improves the distance, update the distance and push the new state into the priority queue.
7. Return the cost when the destination is reached. If no valid path exists, return `-1`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the number of nodes, `E` the number of directed edges, and `k` the maximum allowed consecutive count.

- **Time:** O((n × k + E × k) log(n × k)), using Dijkstra's algorithm on the expanded state graph.
- **Space:** O(n × k + E), for the distance array, priority queue, and adjacency list.

## 📌 Key Takeaway

When a shortest-path problem has additional constraints, the current node alone may not be enough to define a state. Expanding the state to include relevant information allows Dijkstra's algorithm to handle these constraints while preserving shortest-path optimality.