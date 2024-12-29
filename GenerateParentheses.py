'''
Why this solution works?
# Stack is actually not utilised here :O
For the third if condition, we cannot have a closing bracket before an opening bracket
'''

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backtrack(ans, curr, openp, closep, maxp):
            if (len(curr) ==  2 * maxp):
                ans.append(curr)
            if (openp < maxp):
                backtrack(ans, curr + '(', openp + 1, closep, maxp)
            if (closep < openp):
                backtrack(ans, curr + ')', openp, closep + 1, maxp)
        
        ans = []
        openp, closep = 0, 0
        curr = ''
        backtrack(ans, curr, openp, closep, n)
        return ans
