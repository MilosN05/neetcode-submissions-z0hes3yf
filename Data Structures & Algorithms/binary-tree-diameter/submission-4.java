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
    int najv_rast = 0;
    public int diameterOfBinaryTree_helper(TreeNode root) {
        if (root==null) return 0;


        int visina_levog_podstabla = diameterOfBinaryTree_helper(root.left);
        int visina_desnog_podstabla =diameterOfBinaryTree_helper(root.right);

        int najvece_rastojanje = visina_levog_podstabla+visina_desnog_podstabla;
        
        
        if (najvece_rastojanje>najv_rast)
            najv_rast=najvece_rastojanje;
        
        return 1+Math.max(visina_levog_podstabla,visina_desnog_podstabla);
    }
    
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTree_helper(root);
        return najv_rast;
    }
}
