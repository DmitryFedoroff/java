# Wave algorithm

### Description:

Given a maze in the form of a binary rectangular matrix. Write a program to find the shortest path's length in the maze from a given source to a given destination using Wave algorithm.

### Example:

```
Input:
{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
  { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
  { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
  { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
  { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
  { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
  { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1 },
  { 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1 },
  { 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
  { 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1 },
  { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
 
Output:
(1, 1)	Down
(2, 1)	Down
(3, 1)	Down
(4, 1)	Down
(5, 1)	Down
(6, 1)	Right
(6, 2)	Right
(6, 3)	Down
(7, 3)	Right
(7, 4)	Right
(7, 5)	Right
(7, 6)	Down
(8, 6)	Right
(8, 7)	Right
(8, 8)	Right
(8, 9)	Right
(8, 10)	Down
(9, 10)	Down
(10, 10) Exit
```

