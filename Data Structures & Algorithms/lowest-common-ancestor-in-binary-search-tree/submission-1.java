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

    public boolean tree_contains(TreeNode root, TreeNode cvor) {
        if (root==null) return false;

        return root==cvor || tree_contains(root.left,cvor) || tree_contains(root.right,cvor);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==null || q==null) return null;
        Solution solucija = new Solution();

        // if (!solucija.tree_contains(root, p) || !solucija.tree_contains(root,q)) return null;
        // if (root==p || root==q) return null;


        return lowestCommonAncestor_helper( root, p, q);
    }

    private TreeNode lowestCommonAncestor_helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor_helper(root.left,p,q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor_helper(root.right,p,q);

       return root;

    }
}   
