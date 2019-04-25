# Minimum Cost Path
## Description
Given a cost matrix cost[][] and a position (n, n) in cost[][], write a function that returns cost of minimum cost path to reach (n, n) from (0, 0).

Each cell of the matrix represents a cost to traverse through that cell.

Total cost of a path to reach (n, n) is sum of all the costs on that path (including both source and destination).

### Input sample

First line contains the  is the lenght of the matrix.

Next lines contain the rows of the matrix.

Each cell is comma separated. E.g.:
```
3
1,2,3
4,8,2
1,5,3
```
### Output sample

Por previous example minimun path cost would be 11.

## Constraints
You can only traverse down and right from a given cell, i.e., from a given cell.

You may assume that all costs are positive integers.
