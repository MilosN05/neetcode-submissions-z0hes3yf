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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> red_podataka = new LinkedList<>();
        List<Integer> solution= new LinkedList<>();
        if (root==null)
            return solution;

        red_podataka.add(root);

        while (!red_podataka.isEmpty()) {
            LinkedList<Integer> dati_nivo = new LinkedList<>();
            int tr_datog_nivoa = red_podataka.size();

            for (int i=0;i<tr_datog_nivoa;i++) {
                TreeNode procesuiran = red_podataka.poll();
                dati_nivo.add(procesuiran.val);

                if (procesuiran.left!=null)
                    red_podataka.add(procesuiran.left);
                if (procesuiran.right!=null)
                    red_podataka.add(procesuiran.right);
            }

            solution.add(dati_nivo.getLast());

        }

        return solution;
    }
}
