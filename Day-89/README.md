# Day 89 — Count Zero Request Servers

**LeetCode:** [2747. Count Zero Request Servers](https://leetcode.com/problems/count-zero-request-servers/)

**Difficulty:** Medium

**Topic:** Array, Sorting, Sliding Window, Two Pointers

## 🧠 Intuition

For each query, we need to count the servers that received no requests within the time interval `[queryTime - x, queryTime]`.

Checking every log independently for every query would be inefficient. Instead, we can sort the queries and logs by time and process them using two pointers, maintaining the number of active requests for each server.

## 🔄 Approach

**1. Sort Queries and Logs**

- Store the original indices of queries so their answers can be restored to the original order.
- Sort query indices by query time.
- Sort the logs by timestamp.

**2. Maintain the Sliding Time Window**

For each query:

- Calculate the left boundary as `queryTime - x`.
- Move the right pointer `j` forward, adding logs with timestamps less than or equal to the query time.
- Move the left pointer `i` forward, removing logs with timestamps strictly less than the left boundary.
- Maintain `serverCount[]` to track the number of requests from each server within the current window.
- Update `activeServers` whenever a server's request count changes between zero and non-zero.

**3. Calculate the Answer**

The number of servers that received no requests is:

`n - activeServers`

Store the result using the query's original index.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `L` be the number of logs and `Q` be the number of queries.

- **Time:** O(L log L + Q log Q), for sorting the logs and queries, followed by O(L + Q) pointer processing.
- **Space:** O(L + Q + n), for the query indices, server counts, and sorting-related auxiliary space.

## 📌 Key Takeaway

Sorting queries and logs by time transforms repeated interval checks into an efficient offline sliding-window problem. Two pointers allow each log to enter and leave the window at most once, while frequency tracking makes server activity updates efficient.