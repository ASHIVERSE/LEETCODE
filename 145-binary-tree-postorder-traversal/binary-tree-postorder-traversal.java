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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        TreeNode lastvis=null;
        while(curr!=null || !st.isEmpty())
        {
            if(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
             else
             {
                TreeNode node=st.peek();
                if(node.right!=null && lastvis!=node.right)
                {
                    curr=node.right;
                }
                else{
                    res.add(node.val);
                    lastvis = node;
                    st.pop();
                }
             }
        }
        return res;

    }
}