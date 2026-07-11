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
     public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> resenje = new LinkedList<>();

        if (root!=null)
            queue.add(root);


        while (!queue.isEmpty()) {
            LinkedList<Integer> int_lista = new LinkedList<>();

            int tr_queue_size = queue.size();
            for (int i = 0; i < tr_queue_size; i++) {
                TreeNode procesuiran = queue.poll();
                int_lista.add(procesuiran.val);

                if (procesuiran.left != null)
                    queue.add(procesuiran.left);
                if (procesuiran.right != null)
                    queue.add(procesuiran.right);
            }

            resenje.add(int_lista);

            
        }

        return resenje;
    }
}
