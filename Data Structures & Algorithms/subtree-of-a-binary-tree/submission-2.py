# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   


    def max_depth(self,p:TreeNode):
        if not p:return 0


        return 1+max(self.max_depth(p.left),self.max_depth(p.right))

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        solucija = Solution()
        visina_p = solucija.max_depth(p)
        visina_q = solucija.max_depth(q)

        if visina_p!=visina_q: return False

        return self.isSameTree_helper(p,q)

    def isSameTree_helper(self, p: TreeNode, q: TreeNode) -> bool:

        if (not p) and (not q): return True

        if (p and not q) or (not p and q):return False

        if p.val==q.val:
            return self.isSameTree_helper(p.left,q.left) and self.isSameTree_helper(p.right,q.right)
        return False

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:return False

        ima_li_ga = self.isSameTree(root,subRoot)

        return ima_li_ga or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right,subRoot)
