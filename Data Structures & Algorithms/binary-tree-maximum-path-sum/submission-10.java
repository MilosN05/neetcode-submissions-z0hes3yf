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

    int max_suma_grana = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root ==null) return Integer.MIN_VALUE;
        
        int jedno_resenje = max_path_sum_helper(root);
        System.out.println(max_suma_grana + " " + jedno_resenje);

        return Math.max(jedno_resenje,max_suma_grana);
    }

    private int max_path_sum_helper(TreeNode root) {
        if (root==null) return Integer.MIN_VALUE;
        if (root.left==null && root.right==null) return root.val;

        int levo_ps = max_path_sum_helper(root.left);
        int desno_ps = max_path_sum_helper(root.right);

        
        if (levo_ps>0 && desno_ps>0 && (root.val + levo_ps + desno_ps > max_suma_grana) )
            max_suma_grana = root.val + levo_ps + desno_ps;

        if (levo_ps>max_suma_grana)
            max_suma_grana = levo_ps;
        
        if (desno_ps>max_suma_grana)
            max_suma_grana = desno_ps;
        
        if ((levo_ps >= desno_ps) && levo_ps > 0 )
            return levo_ps + root.val;
        else if ((desno_ps > levo_ps) && desno_ps>0 )
            return desno_ps + root.val;
        return root.val;
    }
}
