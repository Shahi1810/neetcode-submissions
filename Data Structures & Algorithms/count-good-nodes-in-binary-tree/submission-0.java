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
        return dfs(root,root.val);
    }

    int dfs(TreeNode node, int maxNode){
        if(node == null) return 0;

        int res = maxNode <= node.val ? 1 : 0;
        maxNode = Math.max(maxNode,node.val);

        res += dfs(node.left,maxNode);
        res += dfs(node.right,maxNode);

        return res;
    }
}
