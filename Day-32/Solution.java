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
    private int maxCount = 0;
    class TreeInfo{
        int sum = 0;
        int count = 0;
        public TreeInfo(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        maxCount = 0;
        solve(root);
        return maxCount;
    }
    public TreeInfo solve(TreeNode root){
        if (root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = solve(root.left);
        TreeInfo right = solve(root.right);
        int val = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;

        if (val / count == root.val){
            maxCount++;
        }

        return new TreeInfo(val, count);
    }
}