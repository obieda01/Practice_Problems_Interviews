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
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();

        if(root != null){
            q.add(root);
        }
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
            TreeNode curr = temp.left;
            temp.left = temp.right;
            temp.right = curr;
        }
        return root;
    }
}