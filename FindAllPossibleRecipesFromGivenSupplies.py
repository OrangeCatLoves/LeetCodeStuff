# Khan's algorithm
# Arrows point from ingredients to recipes
# All supplies have in-degree of zero
# Add all in-degree zero ingredients into the queue
# Decrease the in-degree of respective ingredients, check if they're in the list of recipes
# If they are, add it into final result, and add to queue
# Else, don't add into final result and add to the queue.

from collections import deque

class Solution(object):
    def findAllRecipes(self, recipes, ingredients, supplies):
        """
        :type recipes: List[str]
        :type ingredients: List[List[str]]
        :type supplies: List[str]
        :rtype: List[str]
        """
        result = list()
        allrecipes = set()
        queue = deque()
        totalrecipes = len(recipes)
        for i in range(totalrecipes):
            allrecipes.add(recipes[i])
        
        directedgraph = defaultdict(list)
        indegreecount = defaultdict(int) # Default in-degree value is 0 for all supplies
        # Initialisation
        for i in range(totalrecipes):
            totalingredients = len(ingredients[i])
            for j in range(totalingredients):
                directedgraph[ingredients[i][j]].append(recipes[i])
                indegreecount[recipes[i]] += 1
        
        totalsupplies = len(supplies)
        for i in range(totalsupplies):
            queue.append(supplies[i])
        while (len(queue) > 0):
            curringredient = queue.popleft()
            pointingto = directedgraph[curringredient]
            for i in range(len(pointingto)):
                indegreecount[pointingto[i]] -= 1
                if (indegreecount[pointingto[i]] == 0):
                    queue.append(pointingto[i])
                    if (pointingto[i] in allrecipes):
                        result.append(pointingto[i])

        return result

        
