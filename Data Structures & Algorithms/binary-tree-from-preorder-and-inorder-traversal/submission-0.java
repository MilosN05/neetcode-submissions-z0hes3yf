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
    int pok_i=0;
    HashMap<Integer,Integer> hesh = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++) {
            hesh.put(inorder[i],i);
        }

        return build_tree_helper(preorder, 0, inorder.length-1);
    }

    private TreeNode build_tree_helper(int[] preorder ,int l, int r) {
        if (l>r) return null;

        int nas_cvor_info = preorder[pok_i++]; 
        int mid = hesh.get(nas_cvor_info);

        TreeNode root = new TreeNode(nas_cvor_info);

        root.left = build_tree_helper(preorder, l, mid - 1 );
        root.right = build_tree_helper(preorder, mid+1, r);

        return root;
    }
}
