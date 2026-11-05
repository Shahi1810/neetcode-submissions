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
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        ans.add(List.of(root.val));
        List<TreeNode> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null){
                // q.add(temp.left);
                list.add(temp.left);
            }
            if(temp.right!=null){
                // q.add(temp.right);
                list.add(temp.right);
            }
            if(q.isEmpty()){
                
                if(list.size()>0){   
                    List<Integer> values = new ArrayList<>();
                    for(TreeNode i : list){
                        q.add(i);
                        values.add(i.val);
                    }
                    ans.add(values);
                    list.clear();
                }
            }
        }
        return ans;
    }
}
