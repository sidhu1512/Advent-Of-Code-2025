# Day 9: Movie Theater (Part One)

Approach & Thought Process

We need to find the maximum area of a rectangle formed by red tiles as opposite corners on a grid.

Geometry Calculation:
- The input is parsed to extract coordinate pairs (pointA, pointB). 
- I created a calculateArea method to compute the mathematical area defined by two opposite points using absolute coordinate differences. 
- I tracked the maxarea using a Long variable to prevent integer overflow.

Complexity Analysis

Time Complexity: O(N^2)
Iterating through all combinations of pairs of points to calculate the area. N is the number of red tiles.
Space Complexity: O(N)
Storing the parsed string arrays of coordinates.

Solution

[View Java Solution](D9q1.java)

---

# Day 9: Movie Theater (Part Two)

Approach & Thought Process

Part Two introduces strict geometric constraints. Not all calculated areas are valid; they must form strictly valid rectangles based on four specific points and cannot contain invalid bounding regions.

Validation Layer:
- I expanded the logic to evaluate four points at a time (pointA, pointB, pointC, pointD). 
- I introduced a checkValid method to verify their geometric properties to ensure they form a strictly valid shape. 
- Only if checkValid returns true does the calculateArea method execute.

Complexity Analysis

Time Complexity: O(N^4)
Checking combinations of 4 points in the worst-case scenario, filtered by early validation checks.
Space Complexity: O(1)
Memory usage remains strictly tied to tracking a few point variables.

Solution

[View Java Solution](D9q2.java)
