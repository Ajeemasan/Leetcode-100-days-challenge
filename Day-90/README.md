# Day 90 — Process Tasks Using Servers

**LeetCode:** [1882. Process Tasks Using Servers](https://leetcode.com/problems/process-tasks-using-servers/)

**Difficulty:** Medium

**Topic:** Array, Heap, Priority Queue, Simulation

## 🧠 Intuition

Each task must be assigned to an available server with the smallest weight. If multiple servers have the same weight, the server with the smallest index is chosen.

To efficiently select servers and track their availability, we can maintain two priority queues:

- One for idle servers, ordered by weight and index.
- One for busy servers, ordered by their finish time, weight, and index.

## 🔄 Approach

**1. Initialize the Priority Queues**

- Insert every server into the `idle` queue as `{weight, index}`.
- Maintain the `busy` queue with entries `{finishTime, weight, index}`.

**2. Process Tasks in Order**

For each task at index `j`:

- Update `currentTime` to at least `j`, ensuring tasks are considered at their arrival times.
- Move all servers whose finish time is less than or equal to `currentTime` from `busy` to `idle`.
- If no server is idle, advance `currentTime` to the earliest finishing time and release all servers that become available at that time.

**3. Assign the Task**

- Select the best available server from `idle`.
- Store its index in the answer.
- Add it to `busy` with its updated finish time: `currentTime + tasks[j]`.

Continue until all tasks are assigned.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the number of servers and `m` be the number of tasks.

- **Time:** O((n + m) log n), since each server is inserted into and removed from the priority queues at most once per task assignment cycle, with each heap operation taking O(log n).
- **Space:** O(n + m), including the two priority queues and the answer array.

## 📌 Key Takeaway

Using two priority queues separates server selection from server availability tracking. This makes it possible to simulate task scheduling efficiently while respecting both server weight and index priorities.