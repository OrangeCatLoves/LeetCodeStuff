# '.' means empty space '+' represents a wall. 'v' means visited and is empty space
# Perform a BFS and keep checking if the edge of the maze has been reached.
# Else, if the exit is never reached, return -1

# MLE 156/192 for this first solution, memory usage can be optimised by using only a single deque and triples
'''
from collections import deque

class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        max_row = len(maze)
        max_col = len(maze[0])
        startingrow = entrance[0]
        startingcol = entrance[1]
        currqueue = deque()
        nextqueue = deque()
        currqueue.append((startingrow, startingcol))
        numberofsteps = 0
        while currqueue:
            currentpos = currqueue.popleft()
            currrow = currentpos[0]
            currcol = currentpos[1]
            if ((currrow == 0 or currrow == max_row - 1 or currcol == 0 or currcol == max_col - 1) and (currrow != entrance[0] or currcol != entrance[1])):
                return numberofsteps
            maze[currrow][currcol] = 'v' # Mark as visited 
            if (currrow - 1 >= 0 and maze[currrow - 1][currcol] != '+' and maze[currrow - 1][currcol] != 'v'): # Can we move up ?
                nextqueue.append((currrow - 1, currcol))
            if (currrow + 1 < max_row and maze[currrow + 1][currcol] != '+' and maze[currrow + 1][currcol] != 'v'): # Can we move down ?
                nextqueue.append((currrow + 1, currcol))
            if (currcol + 1 < max_col and maze[currrow][currcol + 1] != '+' and maze[currrow][currcol + 1] != 'v'): # Can we move right ?
                nextqueue.append((currrow, currcol + 1))
            if (currcol - 1 >= 0 and maze[currrow][currcol - 1] != '+' and maze[currrow][currcol - 1] != 'v'): # Can we move left ?
                nextqueue.append((currrow, currcol - 1))
            if (len(currqueue) == 0):
                currqueue = nextqueue
                nextqueue = deque()
                numberofsteps += 1
        
        return -1
'''

from collections import deque

class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        max_row = len(maze)
        max_col = len(maze[0])
        startingrow = entrance[0]
        startingcol = entrance[1]
        currqueue = deque([(startingrow, startingcol, 0)])  # Added steps to tuple
        maze[startingrow][startingcol] = 'v'  # Mark entrance as visited immediately
        
        while currqueue:
            currrow, currcol, numberofsteps = currqueue.popleft()
            
            if ((currrow == 0 or currrow == max_row - 1 or currcol == 0 or currcol == max_col - 1) and (currrow != entrance[0] or currcol != entrance[1])):
                return numberofsteps
                
            # Can we move up?
            if (currrow - 1 >= 0 and maze[currrow - 1][currcol] != '+' and maze[currrow - 1][currcol] != 'v'):
                maze[currrow - 1][currcol] = 'v'  # Mark as visited immediately
                currqueue.append((currrow - 1, currcol, numberofsteps + 1))
                
            # Can we move down?
            if (currrow + 1 < max_row and maze[currrow + 1][currcol] != '+' and maze[currrow + 1][currcol] != 'v'):
                maze[currrow + 1][currcol] = 'v'  # Mark as visited immediately
                currqueue.append((currrow + 1, currcol, numberofsteps + 1))
                
            # Can we move right?
            if (currcol + 1 < max_col and maze[currrow][currcol + 1] != '+' and maze[currrow][currcol + 1] != 'v'):
                maze[currrow][currcol + 1] = 'v'  # Mark as visited immediately
                currqueue.append((currrow, currcol + 1, numberofsteps + 1))
                
            # Can we move left?
            if (currcol - 1 >= 0 and maze[currrow][currcol - 1] != '+' and maze[currrow][currcol - 1] != 'v'):
                maze[currrow][currcol - 1] = 'v'  # Mark as visited immediately
                currqueue.append((currrow, currcol - 1, numberofsteps + 1))
        
        return -1
