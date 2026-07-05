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
     public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;

        pomocna_tree(root);
        return root;
    }



    public void pomocna_tree(TreeNode root) {
        if (root==null) return;

        TreeNode levo = root.left;
        TreeNode desno = root.right;

        root.left=desno;
        root.right=levo;

        pomocna_tree(root.left);
        pomocna_tree(root.right);
    }
}
