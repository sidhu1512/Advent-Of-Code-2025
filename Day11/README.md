# Day 11: Reactor (Part One)

Approach & Thought Process

We need to trace data flow through a directed graph of devices based on an adjacency list.

Graph Parsing & Traversal:
- I parsed the input using string replacement and split operations to build a Map connecting a parent node to a List of child nodes. 
- I used a recursive helper method to traverse these paths to find how many ways data can flow from the start to the output.

Complexity Analysis

Time Complexity: O(V + E)
Standard graph traversal where V is the number of vertices and E is the number of edges.
Space Complexity: O(V + E)
Memory is required for the HashMap representing the graph.

Solution

[View Java Solution](D11q1.java)

---

# Day 11: Reactor (Part Two)

Approach & Thought Process

The number of steps increases, causing the number of paths to explode exponentially. A brute-force traversal results in a Time Limit Exceeded error.

Memoization & Frequency Counting:
- Instead of tracing individual paths, I used a frequency map approach. 
- I maintained maps (fftcounts1, daccounts1) using Long values to track how many times a node is reached at a specific depth. 
- By using getOrDefault, identical sub-paths are collapsed into single mathematical additions, converting exponential recursive growth into linear dynamic programming.

Complexity Analysis

Time Complexity: O(S * V)
Where S is the number of steps and V is the number of vertices. We process the active states once per step.
Space Complexity: O(V)
Storing the frequency count of each node at the current step.

Solution

[View Java Solution](D11q2.java)
