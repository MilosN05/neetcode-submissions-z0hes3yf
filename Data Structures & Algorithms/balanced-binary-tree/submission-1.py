# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    max_razlika_visina =0
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.is_balanced_helper(root)
        return self.max_razlika_visina<=1


    def is_balanced_helper(self,root) -> int:
        if root is None: return 0

        if not root.left and not root.right:
            print(f"Ovo je list {root.val}")
            return 1

        visina_levog = self.is_balanced_helper(root.left)
        visina_desnog = self.is_balanced_helper(root.right)

        razlika_visina = abs(visina_levog - visina_desnog)
        if razlika_visina > self.max_razlika_visina:
            self.max_razlika_visina = razlika_visina


        return 1 + max(visina_levog, visina_desnog)