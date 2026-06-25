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
     TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
     inorder(root);

        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;   
    }
    private void inorder(TreeNode node)
    {
        if (node == null) {
            return;
        }

        inorder(node.left);

        // Violation detected
        if (prev != null && prev.val > node.val) {

            // First violation
            if (first == null) {
                first = prev;
            }

            // Always update second
            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}