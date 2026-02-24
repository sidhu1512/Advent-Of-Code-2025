# Day 7: Tachyon Manifold (Part One)

Approach & Thought Process

The problem involves simulating a tachyon beam falling through a manifold grid. When the beam hits a splitter, it duplicates and travels left and right.

Simulation & Deduplication:
- To prevent exponential path growth on overlapping beams, I simulated the descent row by row. 
- I used a HashSet to track the active beam column indices at the current level. 
- If a beam hits a splitter, its column is removed and replaced by two new columns. The HashSet inherently merges beams that fall onto the same coordinate, preventing redundant calculations.

Complexity Analysis

Time Complexity: O(R * C)
Where R is the number of rows and C is the width of the grid. Using the HashSet ensures we process each column at most once per row.
Space Complexity: O(C)
The HashSet stores at most C integers (the column positions) at any given depth.

Solution

[View Java Solution](D7q1.java)

---

# Day 7: Tachyon Manifold (Part Two)

Approach & Thought Process

Part Two requires counting the exact number of distinct timelines (paths) that safely reach the bottom. 

Recursive Path Tracking:
- I expanded the logic to use a recursive helper function to branch the simulation.
- I included a detailed debug trace with print statements like "Beam falling starting at Row", "HIT SPLITTER at Row", and "REACHED BOTTOM safely. Count +1" to track the flow and tally the successful terminal points.

Complexity Analysis

Time Complexity: O(V + E)
Treated as a Directed Acyclic Graph (DAG) traversal where nodes are splitters.
Space Complexity: O(R)
The call stack depth is bound by the number of rows in the grid.

Solution

- [View Java Solution](D7q2.java)
