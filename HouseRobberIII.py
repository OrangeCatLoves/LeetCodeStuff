# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Incorrect solution: Wrong recursive call. You only considered the money stolen from 1 side of the subtree,
# Total money of the entire subtree has to be considered simultaneously
'''
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def rec(node, money, parentrobbed):
            if (node is None):
                return money
            if (node.left is not None):
                if (parentrobbed):
                    return rec(node.left, money, False)
                else:
                    return max(rec(node.left, money + node.left.val, True), rec(node.left, money, False))
            if (node.right is not None):
                if (parentrobbed):
                    return rec(node.right, money, False)
                else:
                    return max(rec(node.right, money + node.right.val, True), rec(node.right, money, False))
            return money
        
        return max(rec(root, root.val, True), rec(root, 0, False))
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def rec(node, parentrobbed):
            if node is None:
                return 0
            
            if parentrobbed:
                # If the parent is robbed, this node cannot be robbed
                return rec(node.left, False) + rec(node.right, False)
            else:
                # If the parent is not robbed, we consider two cases:
                # 1. Rob this node
                rob_this = node.val + rec(node.left, True) + rec(node.right, True)
                # 2. Do not rob this node
                skip_this = rec(node.left, False) + rec(node.right, False)
                # Take the maximum of the two
                return max(rob_this, skip_this)
        
        # Start with the root node
        return rec(root, False)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        from functools import lru_cache

        @lru_cache(None)
        def rec(node, parentrobbed):
            if node is None:
                return 0
            
            if parentrobbed:
                # If the parent is robbed, this node cannot be robbed
                return rec(node.left, False) + rec(node.right, False)
            else:
                # If the parent is not robbed, consider two cases:
                # 1. Rob this node
                rob_this = node.val + rec(node.left, True) + rec(node.right, True)
                # 2. Do not rob this node
                skip_this = rec(node.left, False) + rec(node.right, False)
                # Take the maximum of the two
                return max(rob_this, skip_this)
        
        # Start with the root node
        return rec(root, False)


# Either you choose to rob your current node, or you don't rob the node you're on
# If the parent node is being robbed, you cannot rob your current node
# If your parent node is not robbed, you can choose either to rob or not to rob,
# And you have to return the maximum of these 2 choices
