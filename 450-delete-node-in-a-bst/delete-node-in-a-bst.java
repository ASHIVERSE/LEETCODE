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
    public TreeNode deleteNode(TreeNode root, int key) {
          // Node not found
        if (root == null) {
            return null;
        }

        // Search left
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search right
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // Case 1 + Case 2
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children

            // Find inorder successor
            TreeNode successor = findMin(root.right);

            // Replace value
            root.val = successor.val;

            // Delete successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
    private TreeNode findMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}