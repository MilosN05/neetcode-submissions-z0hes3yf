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
    public int goodNodes(TreeNode root) {
        if (root==null) return 0;
        return good_nodes_helper(root,Integer.MIN_VALUE);
    }


    private int good_nodes_helper(TreeNode root, int max_do_sad) {
        if (root==null) return 0;
        int cvor_ispunjava_uslov = root.val>=max_do_sad ? 1:0;
        max_do_sad = Math.max(root.val,max_do_sad);

        int levo_dobrih_cvorova = good_nodes_helper(root.left,max_do_sad);
        int desno_dobrih_cvorova = good_nodes_helper(root.right,max_do_sad);

        return cvor_ispunjava_uslov+ levo_dobrih_cvorova+desno_dobrih_cvorova;

    }
}
