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

public class Codec {
    private Queue<TreeNode> q;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root,list);
        return String.join(",", list);
    }

    private void dfsSerialize(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }

        list.add(String.valueOf(root.val));
        dfsSerialize(root.left,list);
        dfsSerialize(root.right,list);
    }

    private TreeNode dfsDeserialize(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        root.left = dfsDeserialize(vals,i);
        root.right = dfsDeserialize(vals,i);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsDeserialize(vals,i);
    }

    
}
