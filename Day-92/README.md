# Day 92 — Find Servers That Handled Most Number of Requests

**LeetCode:** [1606. Find Servers That Handled Most Number of Requests](https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/)

**Difficulty:** Hard

**Topic:** Array, Heap, Priority Queue, TreeSet, Simulation

## 🧠 Intuition

Each incoming request is assigned to the first available server whose index is greater than or equal to `i % k`. If no such server exists, we wrap around and choose the smallest available server index.

We can efficiently simulate this process using:
- A `PriorityQueue` to track busy servers by their finishing times.
- A `TreeSet` to maintain idle servers in sorted order.

## 🔄 Approach

**1. Initialize Data Structures**

- Add all server indices to a `TreeSet` called `idle`.
- Use a min-heap called `busy` to store `{finishTime, serverIndex}`.
- Maintain `requestsHandled[]` to count requests assigned to each server.

**2. Process Incoming Requests**

For each request:

- Release all busy servers whose finishing time is less than or equal to the current arrival time.
- If no server is idle, drop the request.
- Calculate the preferred server index using `i % k`.
- Use `idle.ceiling(preferred)` to find the smallest available server index greater than or equal to the preferred index.
- If no such server exists, wrap around using `idle.first()`.
- Remove the selected server from `idle` and add it to `busy` with its finishing time.
- Increment its request count and update `maxHandled`.

**3. Find the Busiest Servers**

Traverse `requestsHandled[]` and collect all server indices whose request count equals `maxHandled`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `k` be the number of servers and `n` be the number of requests.

- **Time:** O((k + n) log k), for initializing the `TreeSet`, processing requests, and performing heap and sorted-set operations.
- **Space:** O(k), for the `TreeSet`, priority queue, and request-count array.

## 📌 Key Takeaway

Combining a min-heap with a `TreeSet` is effective when a problem requires tracking availability by time while also selecting the smallest available index satisfying a condition. This approach handles both scheduling and circular server selection efficiently.