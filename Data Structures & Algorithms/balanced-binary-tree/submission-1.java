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
    //dfs returning both height of subtrees and balanced or not status at once
    //array function dfs -> 1st index = balanced or not , 2nd index = height of subtree
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0]==1;
    }
    private int[] dfs(TreeNode root){
        //null node is balanced
        if(root==null) return new int[]{1,0};
        //compute the dfs for subtrees    
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //check status for balanced or not using the left and right subtre arrays
        boolean balanced = (left[0] == 1 && right[0] == 1)
                            && (Math.abs(left[1]-right[1])<=1);
        //assign height recursively to the subtree arrays
        int height = 1 + Math.max(left[1],right[1]);
        //update each node's balanced status.
        return new int[]{balanced ? 1 : 0 , height};
    }
}
