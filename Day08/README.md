# Day 8: Junction Boxes (Part One)

Approach & Thought Process

We are given 3D coordinates representing electrical junction boxes. The goal is to connect them efficiently with the shortest total distance.

Coordinate Parsing & Distance Calculation:
- I parsed the coordinates and created a getDistance helper method using Math.hypot to calculate the Euclidean distance between every pair of points. 
- I stored these distances in a Map, extracted the entries, and sorted them in ascending order.

Disjoint Set Union (Kruskal's Algorithm):
- I implemented a Disjoint Set Union (Union-Find) using leader1, leader2, and parent tracking to connect points without forming cycles.
- Iterating through the sorted distances, I connected two points if they had different leaders, accumulating the totalConnection distance.

Complexity Analysis

Time Complexity: O(N^2 * log(N^2))
Where N is the number of points. Calculating all pairs takes O(N^2), and sorting the resulting list of distances dominates the execution time.
Space Complexity: O(N^2)
Storing all pairwise distances in a Map/List.

Solution

[View Java Solution](D8q1.java)

---

# Day 8: Junction Boxes (Part Two)

Approach & Thought Process

Part Two requires tracking the remaining circuits as connections are made to find a specific optimal connection point.

Component Tracking:
- The core Union-Find algorithm remains the same. 
- I added a tracker for circuitsRemaining to identify when the network reaches the target state. 
- A getans method was used to extract and print the final connection details ("The final connection is between: ...").

Complexity Analysis

Time Complexity: O(N^2 * log(N^2))
The sorting phase remains the bottleneck, followed by near O(1) lookups for the Union-Find path compression.
Space Complexity: O(N^2)
Storage for the disjoint set parent map and the sorted edge list.

Solution

[View Java Solution](D8q2.java)
