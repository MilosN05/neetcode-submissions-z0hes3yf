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

    int trenutni_po_velicini = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return Integer.MAX_VALUE;
        int[] niz_resenje = new int[1];

        kth_najmanji_helper(root,k,niz_resenje);
        return niz_resenje[0];
    }

    private void kth_najmanji_helper(TreeNode root, int k, int[] resenje) {
        if (root==null) return;

        kth_najmanji_helper(root.left,k,resenje);
        if (trenutni_po_velicini ==k)
            resenje[0]=root.val;
        trenutni_po_velicini+=1;
        kth_najmanji_helper(root.right,k,resenje);

        
    }
}
