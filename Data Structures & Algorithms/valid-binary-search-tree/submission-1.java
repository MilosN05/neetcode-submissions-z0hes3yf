/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
      if (root==null) return true;

      return is_valid_bst_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    private boolean is_valid_bst_helper(TreeNode root, int dg, int gg) {
        if (root==null) return true;

        if (root.val<=dg || root.val>=gg)
            return false;
        
        return is_valid_bst_helper(root.left,dg,root.val) && is_valid_bst_helper(root.right,root.val,gg);
        
    }

   
}
