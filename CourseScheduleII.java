# Initialise an inDegreeList for every course
# Add all course with zero inDegree inside a queue and then dequeue them
# Simultaneously maintain a separate list and add the course
# Keep doing this until the queue is empty
# If the size of the queue is equals to numCourses return the list
# Else return an empty array

from queue import Queue

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        inDegreeList = [0] * numCourses
        # Using a dict fixed the problem. Using list() of lists was an issue
        directedGraph = {i: [] for i in range(numCourses)}  # Initialize directedGraph as a dictionary of empty lists
        q = Queue()
        orderedList = list() # To be returned as the result if possible
        for edge in prerequisites:
            directedGraph[edge[1]].append(edge[0])
            inDegreeList[edge[0]] += 1
        for i in range(numCourses):
            if (inDegreeList[i] == 0):
                q.put(i)
                orderedList.append(i)
        for e in directedGraph:
            print(e)
        while not q.empty():
            currCourse = q.get()
            print("currCourse " + str(currCourse))
            nextCourses = directedGraph[currCourse]
            for nextCourse in nextCourses:
                inDegreeList[nextCourse] -= 1
                if (inDegreeList[nextCourse] == 0):
                    q.put(nextCourse)
                    orderedList.append(nextCourse)
        print("Size of orderedList: " + str(len(orderedList)))
        if (len(orderedList) == numCourses):
            return orderedList
        else:
            return list()
