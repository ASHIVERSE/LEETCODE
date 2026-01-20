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
       List<List<Integer>> ans=new ArrayList<>();

        if(root==null) return ans;

        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            List<Integer> level=new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i<size; i++)
            {
                TreeNode curr=q.poll();
                level.add(curr.val);
                if(curr.left!=null)  q.offer(curr.left);
                 if(curr.right!=null)  q.offer(curr.right);

             }
             ans.add(level);
        }
        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<List<Integer>> levels=levelOrder(root);
        List<Integer> right=new ArrayList<>();
        for(List<Integer> level: levels)
        {
            right.add(level.get(level.size()-1));
        }
        return right;
    }
}
