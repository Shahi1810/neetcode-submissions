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
        List<List<Integer>> lo = levelOrder(root);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < lo.size(); i++){
            int size = lo.get(i).size();
            ans.add(lo.get(i).get(size-1));
        }
        return ans;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i=q.size();i>0;i--){
                TreeNode temp = q.poll();
                if(temp!=null){
                    list.add(temp.val);
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            if(list.size()>0){
                ans.add(list);
            }
        }
        return ans;
    }
}
