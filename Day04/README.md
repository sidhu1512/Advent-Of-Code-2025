# Day 4: Printing Department (Part One)

Approach & Thought Process

The problem involves a 2D grid of paper rolls ('@') and empty spaces ('.'). Forklifts can only remove rolls that have fewer than 4 adjacent rolls in the 8 cardinal and ordinal directions.

Grid Traversal & Boundary Checks:
- The input is parsed into a 2D array representing the grid layout.
- We need to identify and count all accessible rolls.
- I iterate through every coordinate containing a roll and check the 8 surrounding relative coordinates. A helper method ensures we do not throw boundary exceptions when checking edges.
- If the adjacent roll count is strictly less than 4, the roll is marked as accessible.

Complexity Analysis

Time Complexity: O(R * C)
Where R is rows and C is columns. We visit each cell and do a constant O(1) lookup of its 8 neighbors.
Space Complexity: O(R * C)
Storing the parsed input into a 2D matrix in memory.

Solution

[View Java Solution](D4q1.java)

---

# Day 4: Printing Department (Part Two)

Approach & Thought Process

Removing rolls creates a cascading domino effect. A roll that is blocked initially might become accessible once its neighbors are removed. We must simulate this until the grid reaches a stable state.

Iterative Matrix Updates:
- We perform a simulation loop. In each pass, we scan the entire grid to collect the coordinates of all rolls that currently have fewer than 4 neighbors.
- Because state changes must happen simultaneously in a wave, we cannot mutate the grid while checking it.
- After the scan is complete, we mutate the grid by replacing those specific rolls with empty spaces. We repeat this until a scan yields zero removable rolls.

Complexity Analysis

Time Complexity: O(W * R * C)
Where W is the number of waves/rounds it takes for the grid to stabilize.
Space Complexity: O(R * C)
We maintain the grid and a secondary state mechanism to track simultaneous updates safely.

Solution

[View Java Solution](D4q2.java)
